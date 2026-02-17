package com.nexlink.controllers;

import com.nexlink.dao.UserDAO;
import com.nexlink.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // 1️⃣ Read form data (matches login.jsp)
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 2️⃣ Call DAO login()
        UserDAO dao = new UserDAO();
        User user = dao.login(email, password);

        // 3️⃣ Validate result
        if (user != null) {
            // ✅ SUCCESS LOGIN
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", user.getName());
            session.setAttribute("email", user.getEmail());

            response.sendRedirect("dashboard.jsp");
        } else {
            // ❌ INVALID LOGIN
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
