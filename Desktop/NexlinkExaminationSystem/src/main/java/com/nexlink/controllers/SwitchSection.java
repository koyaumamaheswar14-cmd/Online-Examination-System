package com.nexlink.controllers;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/switchSection")
public class SwitchSection extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession();

        String section = req.getParameter("section"); // section is STRING (NOT number)

        session.setAttribute("currentSection", section);
        session.setAttribute("currentIndex", 0);

        resp.sendRedirect("question.jsp");
    }
}
