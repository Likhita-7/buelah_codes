import java.io.IOException;
import java.io.PrintWriter;
import java.util.random.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassengerServlet
 */
@WebServlet("/PassengerServlet")
public class PassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request.getParameter("TrainNo"));
		String Trno = request.getParameter("TrainNo");
		String Trname = request.getParameter("TrainName");
		String from = request.getParameter("From");
		String to = request.getParameter("To");
		String Class = request.getParameter("TrainClass");
		String Fare = request.getParameter("fare");
		
		String p1n = request.getParameter("passenger1_name");
		String p2n = request.getParameter("passenger2_name");
		String p3n = request.getParameter("passenger3_name");
		String p4n = request.getParameter("passenger4_name");
		String p5n = request.getParameter("passenger5_name");
		String p1a = request.getParameter("passenger1_age");
		String p2a = request.getParameter("passenger2_age");
		String p3a = request.getParameter("passenger3_age");
		String p4a = request.getParameter("passenger4_age");
		String p5a = request.getParameter("passenger5_age");
		
//		int Trno = 1234;
//		String Trname = null;
//		String from = "ND";
//		String to = "BBR";
//		String Class = "1AC";
//		int Fare =2;
//		System.out.println(Trno);
//		System.out.println(Trname);
//		System.out.println(from);
//		System.out.println(to);
//		System.out.println(Class);
//		System.out.println(Fare);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> TICKET DETAILS</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Ticket Details</h1>");
		out.println("<table>");
		out.println("<tr><th>Train number</th><th>Train Name   </th><th>From   </th><th>To</th><th>Class  </th><th>Passenger Name  </th><th>Passenger Age  </th>");
		out.println("<tr><td>" + Trno + "</td><td>" + Trname + "</td><td>" + from + "</td><td>" + to + "</td><td>"
				+ Class + "</td><td>"+p1n + "</td><td>"+p1a + "</td><td>" );
		out.println("<tr><td>" + Trno + "</td><td>" + Trname + "</td><td>" + from + "</td><td>" + to + "</td><td>"
				+ Class + "</td><td>"+p2n + "</td><td>"+p2a + "</td><td>" );
		out.println("<tr><td>" + Trno + "</td><td>" + Trname + "</td><td>" + from + "</td><td>" + to + "</td><td>"
				+ Class + "</td><td>"+p3n + "</td><td>"+p3a + "</td><td>" );
		out.println("<tr><td>" + Trno + "</td><td>" + Trname + "</td><td>" + from + "</td><td>" + to + "</td><td>"
				+ Class + "</td><td>"+p4n + "</td><td>"+p4a + "</td><td>" );
		out.println("<tr><td>" + Trno + "</td><td>" + Trname + "</td><td>" + from + "</td><td>" + to + "</td><td>"
				+ Class + "</td><td>"+p5n + "</td><td>"+p5a + "</td><td>" );

		out.println("</table>");
		out.println("</center>");
		out.println("<center>");
		out.println("<p>Total Fare:"+Fare+"</p>");
		out.println("</center>");
		out.println("</body>");
		out.println("<html><body>");
		out.println("<center>");
        out.println("<button onclick=\"goBack()\">Edit</button>");
        out.println("<script>");
        out.println("function goBack() {");
        out.println("    window.history.back();");
        out.println("}");
        out.println("</script>");
        out.println("</center>");
        out.println("<center>");
        out.println("<h1>Data saved successfully!</h1>");
       
        out.println("<button onclick=\"location.href='/SaveTicketservlet'\">Save</button>");
        
        out.println("</center>");
        out.println("</body></html>");

		out.println("</html>");
		
		
//		request.setAttribute("TrainNo", Trno);
//        request.setAttribute("TrainName", Trname);
//        request.setAttribute("From", from);
//        request.setAttribute("To", to);
//        request.setAttribute("TrainClass", Class);
//        request.setAttribute("fare", Fare);
//        request.setAttribute("passenger1_name", p1n);
//        request.setAttribute("passenger2_name", p2n);
//        request.setAttribute("passenger3_name", p3n);
//        request.setAttribute("passenger4_name", p4n);
//        request.setAttribute("passenger5_name", p5n);
//        request.setAttribute("passenger1_age", p1a);
//        request.setAttribute("passenger2_age", p2a);
//        request.setAttribute("passenger3_age", p3a);
//        request.setAttribute("passenger4_age", p4a);
//        request.setAttribute("passenger5_age", p5a);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/SaveTicketServlet");
//        dispatcher.forward(request, response);
		

	}

}