package com.form;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class success extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("Your Data was saved Successfully");
    }
}
