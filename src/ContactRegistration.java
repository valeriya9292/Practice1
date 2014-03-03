
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContactRegistration extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        String action = request.getParameter("action");
        if (action != null && action.length() > 0) {
            session.setAttribute("action", action);
            
            if ("aCompany".equals(action)) {
              printPageCompany(out, request);	
            } else if("aPersonalInfo".equals(action)) {
              printPagePersonal(out, request); 
            } else if ("aSave".equals(action)) {
              saveContact(session, request, out); 	
            }
            
        } else {
        	printPageRegistration(out, request);
        }
       
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    	doGet(request, response);
    }
    
    private void printPageRegistration(PrintWriter out, HttpServletRequest request) {
    	out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Contact Registreation</h1>");
        out.println("<P>");
        out.print("<form action=\"Registration\"");
        out.println("method=POST>");
        out.println("<input type=hidden name=action value=aCompany>");
        out.println("First Name: ");
        out.println("<input type=text size=20 name=firstname>");
        out.println("<br>");
        out.println("Last Name: ");
        out.println("<input type=text size=20 name=lastname>");
        out.println("<br>");
        out.println("<input type=submit value=Next>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
    
    private void printPageCompany(PrintWriter out, HttpServletRequest request ) {
    	out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Person's Company Registreation</h1>");
        out.println("<P>");
        out.print("<form action=\"Registration\"");
        out.println("method=POST>");
        out.println("<input type=hidden name=action value=aPersonalInfo>");
        out.println("First Name: " + request.getParameter("firstname"));
        out.println("<input type=hidden name=firstname value=" + request.getParameter("firstname") + ">");
        out.println("<br>");
        out.println("Last Name: " + request.getParameter("lastname"));
        out.println("<input type=hidden name=lastname value=" + request.getParameter("lastname") + ">" );
        out.println("<br>");
        out.println("Company Name: ");
        out.println("<input type=text size=20 name=companyname>");
        out.println("<br>");
        out.println("<input type=submit value=Next>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
    private void printPagePersonal(PrintWriter out, HttpServletRequest request ) {
    	out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Personal Info Registreation</h1>");
        out.println("<P>");
        out.print("<form action=\"Registration\"");
        out.println("method=POST>");
        out.println("<input type=hidden name=action value=aSave>");
        out.println("First Name: " + request.getParameter("firstname"));
        out.println("<input type=hidden name=firstname value=" + request.getParameter("firstname") + ">");
        out.println("<br>");
        out.println("Last Name: " + request.getParameter("lastname"));
        out.println("<input type=hidden name=lastname value=" + request.getParameter("lastname") + ">" );
        out.println("<br>");
        out.println("Company Name: " +  request.getParameter("companyname"));
        out.println("<input type=hidden name=companyname value=" + request.getParameter("companyname") + ">");
        out.println("<br>");
        out.println("Hobby: ");
        out.println("<input type=text name=hobby >");
        out.println("<input type=submit value=Save>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
    
    private void printSessionInfo(HttpSession session, PrintWriter out) {
        out.println("<p>ID " + session.getId()+"</p>");
        out.println("<p>Created: " + session.getCreationTime()+"</p>");
        out.println("<p>Last Accessed: " + session.getLastAccessedTime() + "</p>");
        
        // print session contents
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = session.getAttribute(name).toString();
            out.println(name + " = " + value);
        }
    }
    
    private void saveContact(HttpSession session,HttpServletRequest request,PrintWriter out) {
    	out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Congratulation!</h1>");
        out.println("<P>");
        out.println("Contact has been saved successfully.");
        out.println("</body>");
        out.println("</html>");
    }
}
    

