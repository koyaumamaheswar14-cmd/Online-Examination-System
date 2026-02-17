package com.nexlink.controllers;

import com.nexlink.dao.QuestionDAO;
import com.nexlink.dao.ResultDAO;
import com.nexlink.model.ExamResult;
import com.nexlink.model.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/finishExam")
public class FinishExamServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("🔥 finishExam servlet called");

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Integer examId = (Integer) session.getAttribute("examId");
        Integer userId = (Integer) session.getAttribute("userId");
        String userName = (String) session.getAttribute("userName");

        if (examId == null || userId == null) {
            System.out.println("❌ Missing examId or userId");
            response.sendRedirect("login.jsp");
            return;
        }

        Map<Integer, String> answers =
                (Map<Integer, String>) session.getAttribute("answers");

        if (answers == null) {
            System.out.println("❌ Answers map missing");
            response.sendRedirect("dashboard.jsp");
            return;
        }

        // 🔹 LOAD ALL QUESTIONS OF EXAM (IMPORTANT)
        QuestionDAO qdao = new QuestionDAO();
        List<String> sections = (List<String>) session.getAttribute("sections");

        int correct = 0, incorrect = 0, unanswered = 0, total = 0;

        for (String sec : sections) {
            List<Question> qs = qdao.getQuestionsBySection(examId, sec);
            total += qs.size();

            for (Question q : qs) {
                String userAns = answers.get(q.getId());
                String correctAns = q.getCorrectOption();

                if (userAns == null) unanswered++;
                else if (userAns.equalsIgnoreCase(correctAns)) correct++;
                else incorrect++;
            }
        }

        System.out.println("➡ FINAL RESULT");
        System.out.println("Total=" + total);
        System.out.println("Correct=" + correct);
        System.out.println("Incorrect=" + incorrect);
        System.out.println("Unanswered=" + unanswered);

        ExamResult r = new ExamResult();
        r.setUserId(userId);
        r.setUserName(userName);
        r.setSection("FINAL");
        r.setTotalQuestions(total);
        r.setCorrect(correct);
        r.setIncorrect(incorrect);
        r.setUnanswered(unanswered);

        ResultDAO dao = new ResultDAO();
        dao.saveSectionResult(r);

        // Optional: clear exam session
        session.removeAttribute("answers");
        session.removeAttribute("currentIndex");
        session.removeAttribute("currentSection");
        session.removeAttribute("sections");

        response.sendRedirect("dashboard.jsp");
    }
}
