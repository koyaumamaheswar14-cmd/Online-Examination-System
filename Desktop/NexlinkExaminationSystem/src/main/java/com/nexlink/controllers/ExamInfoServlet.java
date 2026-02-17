package com.nexlink.controllers;

import com.nexlink.dao.ExamDAO;
import com.nexlink.model.Exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/examInfo")
public class ExamInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String examIdParam = request.getParameter("examId");

        if (examIdParam == null) {
            response.getWriter().println("Error: examId missing");
            return;
        }

        int examId = Integer.parseInt(examIdParam);

        ExamDAO dao = new ExamDAO();
        Exam exam = dao.getExamById(examId);

        if (exam == null) {
            response.getWriter().println("Error: exam not found");
            return;
        }

        request.setAttribute("exam", exam);
        request.getRequestDispatcher("examinfo.jsp").forward(request, response);
    }
}
