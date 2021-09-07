package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Profile</title>");
            out.println("</head>");
            out.println("<body>");

            RequestDispatcher rd = request.getRequestDispatcher("links.html");
            rd.include(request, response);

            Cookie ck[] = request.getCookies();
            if (ck != null) {
                String name = ck[0].getName();
                if (!name.equals("") || name != null) {
                    out.println("<h1>Welcome to your Profile </h1>");
                    out.println("<h2> Welcome " + name + "</h2>");
                }
                
            }
            else{
                    out.println("To see your profile please login");
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
