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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String kwot = request.getParameter("kwota");
                double kwota = Double.parseDouble(kwot);
		//response.setContentType("text/plaintext"); 
		response.setContentType("text/html");
		response.getWriter().println("<h1>Hello " 
				+kwota
				+ "</h1>");
	}
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        
        String kwot = request.getParameter("kwota");
        String iloscRa = request.getParameter("iloscRat");
        String oprocentowani = request.getParameter("oprocentowanie");
        String stal = request.getParameter("stala");
        String rodzajRaty = request.getParameter("rodzajRaty");
        
        if(kwot == null || iloscRa == null || oprocentowani == null || stal == null || kwot == "" || iloscRa == "" || oprocentowani == "" || stal == "" )
        {
            response.sendRedirect("");
        }
        
        double kwota = Double.parseDouble(kwot);
        double iloscRat = Double.parseDouble(iloscRa);
        double oprocentowanie = Double.parseDouble(oprocentowani)/100;
        double stala = Double.parseDouble(stal);                                //nie znalazlem wzoru ktory by o tej stalej wspominal wiec odejmuje ja od czesci kapitalowej 
                
        if(kwota == 0 || iloscRat == 0 || oprocentowanie == 0 || stala == 0)
        {
            response.sendRedirect("");
        }
        
        
        int nrRaty;
        double kwotaKapitalu = 0, kwotaOdsetek = 0, calkowitaKwotaRaty = 0, ileSplacono = 0;
        
        java.text.DecimalFormat df=new java.text.DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        
        response.setContentType("text/html");
        if(rodzajRaty.equals("malejaca"))
        {
            response.getWriter().println("<table>"
                    + "<tr>"
                    + "<td>Nr raty</td>"
                    + "<td>Kwota kapitalu</td>"
                    + "<td>Kwota odstetek</td>"
                    + "<td>Oplata stala</td>"
                    + "<td>Calkowita kwota raty</td>"
                    + "</tr>");
            for(nrRaty = 1;nrRaty <= iloscRat; nrRaty++)
            {
                response.getWriter().println("<tr>"
                        + "<td>"
                        + df.format(nrRaty)
                        + "</td>"
                        + "<td>"
                        + df.format(kwotaKapitalu=(kwota/iloscRat)- stala)
                        + "</td>"
                        + "<td>"
                        + df.format(kwotaOdsetek=(kwota-((nrRaty-1)*kwota/iloscRat))*oprocentowanie/iloscRat)
                        + "</td>"
                        + "<td>"
                        + df.format(stala)                                      
                        + "</td>"
                        + "<td>"
                        + df.format(calkowitaKwotaRaty = kwotaKapitalu + kwotaOdsetek + stala)
                        + "</td>"
                        +"</tr>");
                        ileSplacono += calkowitaKwotaRaty;
            }
                        response.getWriter().println("</table><br />Do splaty "+df.format(ileSplacono) + "zl");

        }
        else if(rodzajRaty.equals("stala"))
        {
            double q = 1 + (oprocentowanie/iloscRat);
            calkowitaKwotaRaty = kwota * (Math.pow(q,iloscRat)) * (q-1)/(Math.pow(q, iloscRat)-1);
            response.getWriter().println("<table>"
                    + "<tr>"
                    + "<td>Nr raty</td>"
                    + "<td>Kwota kapitalu</td>"
                    + "<td>Kwota odstetek</td>"
                    + "<td>Oplata stala</td>"
                    + "<td>Calkowita kwota raty</td>"
                    + "</tr>");
            for(nrRaty = 1;nrRaty <= iloscRat; nrRaty++)
            {
                response.getWriter().println("<tr>"
                        + "<td>"
                        + df.format(nrRaty)
                        + "</td>"
                        + "<td>"
                        + df.format(kwotaKapitalu=(kwota/iloscRat)- stala)              // nie znalazlem wzoru na osobne policzenie czesci kapitalowej
                        + "</td>"
                        + "<td>"
                        + df.format(kwotaOdsetek= calkowitaKwotaRaty - kwotaKapitalu)   // lub tez odsetkowej
                        + "</td>"
                        + "<td>"
                        + df.format(stala)
                        + "</td>"
                        + "<td>"
                        + df.format(calkowitaKwotaRaty)
                        + "</td>"
                        +"</tr>");
                        ileSplacono += calkowitaKwotaRaty;
            }
                        response.getWriter().println("</table><br />Do splaty "+df.format(ileSplacono) + "zl");

        }
             
    }
}
