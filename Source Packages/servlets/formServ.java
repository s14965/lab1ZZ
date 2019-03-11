package servlets;
/**
 *
 * @author s14965
 */
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/harmonogram")
public class formServ extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
   
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String kwota = request.getParameter("kwota");
        if(kwota==null)
        {
            response.sendRedirect("");
        }
        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello "
            + kwota
            + "</h1>");
    }
}
