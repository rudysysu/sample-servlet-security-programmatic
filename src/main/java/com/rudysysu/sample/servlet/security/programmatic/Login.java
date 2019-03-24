package com.rudysysu.sample.servlet.security.programmatic;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = -5212519085836634673L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            request.login(username, password);

            System.out.println(request.isUserInRole("user"));
            System.out.println(request.getRemoteUser());
            
            Principal userPrincipal = request.getUserPrincipal();
            System.out.println(userPrincipal);

            response.sendRedirect("user");
        } catch (ServletException e) {
            response.sendRedirect("login.html");
        }
    }
}