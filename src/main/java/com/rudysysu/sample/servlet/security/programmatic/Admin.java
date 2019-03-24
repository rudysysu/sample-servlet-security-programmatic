package com.rudysysu.sample.servlet.security.programmatic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "admin" }))
public class Admin extends HttpServlet {
    private static final long serialVersionUID = -2730106767844286820L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.authenticate(response)) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("有admin角色，就可以看到这个页面");
            out.println("<a href='logout'>登出</a>");
        }
    }
}
