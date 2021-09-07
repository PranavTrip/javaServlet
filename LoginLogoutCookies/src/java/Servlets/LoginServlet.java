
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;



public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           RequestDispatcher rd=request.getRequestDispatcher("links.html");
           rd.include(request,response);
           String name= request.getParameter("user_name");
           String password= request.getParameter("user_password");
           
           if(password.equals("root")){
               out.println("<h3>You are successfully logged in... <br> Welcome"+name+"</h3>");
               Cookie ck=new Cookie("name",name);
               response.addCookie(ck);
           }
           else{
               out.println("<h2>Username or Password does not match with our records. <br> Please try again</h2>");
               RequestDispatcher rd1=request.getRequestDispatcher("login.html");
               rd1.include(request, response);
           }
           
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
