package com.nexlink.controllers;

import com.nexlink.dao.UserDAO;
import com.nexlink.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        UserDAO dao = new UserDAO();

        if (dao.emailExists(email)) {
            resp.sendRedirect("register.jsp?exists=1");
            return;
        }

        User user = new User(name, email, pass);

        if (dao.register(user)) {
            resp.sendRedirect("login.jsp?registered=1");
        } else {
            resp.sendRedirect("register.jsp?error=1");
        }
    }
}	