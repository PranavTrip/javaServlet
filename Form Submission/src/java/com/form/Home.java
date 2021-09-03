package com.form;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Home extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1> This is home Page <br> Click the link below to Fill the Form </h1>");
        out.println("<a href='index.html'>Fill Form </a>");
    }
}
