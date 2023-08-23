

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrainsServlet
 */
@WebServlet("/TrainsServlet")
public class TrainsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String datee = request.getParameter("dates");
		//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		//	java.sql.Date fromDate = new java.sql.Date(formatter.parse(datee).getTime());

			Connection c = null;

			Class.forName("org.postgresql.Driver");

			String s = "jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";

			c = DriverManager.getConnection(s);

			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			PreparedStatement p = c.prepareStatement(
					"select * from beu_trains where tr_no in(select tr_no  from beu_stn where stn_code =?  ) and tr_no in(select tr_no from beu_stn where stn_code =?) ");
			p.setString(1, from);
			p.setString(2, to);
			ResultSet stt = p.executeQuery();
		

			String dat = "";
			while (stt.next()) {
				for (int i = 1; i <= 2; i++) {
					dat += stt.getString(i) + " ";

				}
				response.getWriter().print("<option>" + dat + "</option>" + "<br>");

				dat = " ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
