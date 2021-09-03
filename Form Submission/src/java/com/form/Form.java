package com.form;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Form extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        PrintWriter pw = res.getWriter();

        String name = req.getParameter("user_name");
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String age = req.getParameter("user_age");
        String gender = req.getParameter("user_gender");
        String tc = req.getParameter("user_condition");

        if (tc != null) {
            if (tc.equals("checked")) {
                pw.println("<h1>Name : " + name + "</h1>");
                pw.println("<h1>Email : " + email + "</h1>");
                pw.println("<h1>Password : " + password + "</h1>");
                pw.println("<h1>Age : " + age + "</h1>");
                pw.println("<h1>Gender : " + gender + "</h1>");
                
                RequestDispatcher rd=req.getRequestDispatcher("success");
                rd.forward(req, res);

            } else {
                pw.println("Please accept our terms and conditions");
            }
        } else {
            pw.println("Please accept our terms and conditions");
            RequestDispatcher rd=req.getRequestDispatcher("index.html");
            rd.include(req, res);
        }
    }

}
