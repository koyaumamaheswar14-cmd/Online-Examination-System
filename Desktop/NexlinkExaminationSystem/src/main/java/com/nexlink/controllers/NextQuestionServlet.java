package com.nexlink.controllers;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nexlink.dao.QuestionDAO;
import com.nexlink.model.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/nextQuestion")
public class NextQuestionServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
            session.getAttribute("examId") == null ||
            session.getAttribute("sections") == null ||
            session.getAttribute("currentSection") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        int examId = (int) session.getAttribute("examId");
        List<String> sections = (List<String>) session.getAttribute("sections");
        String currentSection = (String) session.getAttribute("currentSection");

        Integer currentIndex =
                (Integer) session.getAttribute("currentIndex");
        if (currentIndex == null) currentIndex = 0;

        // ✅ SAVE ANSWER
        Map<Integer, String> answers =
                (Map<Integer, String>) session.getAttribute("answers");
        if (answers == null) answers = new HashMap<>();

        String qid = request.getParameter("questionId");
        String userAns = request.getParameter("userAnswer");

        if (qid != null && userAns != null) {
            answers.put(Integer.parseInt(qid), userAns);
        }
        session.setAttribute("answers", answers);

        // 🔹 LOAD QUESTIONS FOR CURRENT SECTION
        QuestionDAO dao = new QuestionDAO();
        List<Question> questions =
                dao.getQuestionsBySection(examId, currentSection);

        System.out.println("👉 currentIndex = " + currentIndex);
        System.out.println("👉 questions.size = " + questions.size());
        System.out.println("👉 currentSection = " + currentSection);

        // 🔹 MOVE TO NEXT QUESTION
        currentIndex++;

        // 🔴 SECTION FINISHED
        if (currentIndex >= questions.size()) {

            int secPos = sections.indexOf(currentSection);

            // ➡️ NEXT SECTION EXISTS
            if (secPos + 1 < sections.size()) {
                session.setAttribute("currentSection",
                        sections.get(secPos + 1));
                session.setAttribute("currentIndex", 0);

                response.sendRedirect("question.jsp");
                return;
            }

            // ✅ LAST SECTION → FINISH EXAM
            System.out.println("🔥 Redirecting to finishExam");
            response.sendRedirect("finishExam");
            return;
        }

        // ➡️ CONTINUE SAME SECTION
        session.setAttribute("currentIndex", currentIndex);
        response.sendRedirect("question.jsp");
    }
}
