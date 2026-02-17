package com.nexlink.controllers;

import com.nexlink.dao.QuestionDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/startExam")
public class StartExamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        // 🔒 SAFETY: examId must exist
        String examIdStr = request.getParameter("examId");
        if (examIdStr == null) {
            response.sendRedirect("dashboard.jsp");
            return;
        }

        int examId = Integer.parseInt(examIdStr);

        QuestionDAO dao = new QuestionDAO();
        List<String> sections = dao.getSectionsByExam(examId);

        if (sections == null || sections.isEmpty()) {
            response.getWriter().println("No sections found for this exam");
            return;
        }

        // 🧹 CLEAR OLD EXAM DATA
        session.removeAttribute("answers");
        session.removeAttribute("currentIndex");
        session.removeAttribute("currentSection");

        // 🔹 INITIALIZE EXAM SESSION
        session.setAttribute("examId", examId);
        session.setAttribute("sections", sections);
        session.setAttribute("currentSection", sections.get(0));
        session.setAttribute("currentIndex", 0);

        // 🔹 INIT ANSWERS MAP
        Map<Integer, String> answers = new HashMap<>();
        session.setAttribute("answers", answers);

        response.sendRedirect("question.jsp");
    }
}
