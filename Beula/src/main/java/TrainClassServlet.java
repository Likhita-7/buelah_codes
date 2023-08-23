

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrainClassServlet
 */
@WebServlet("/TrainClassServlet")
public class TrainClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection c=null;
			Class.forName("org.postgresql.Driver");
			
			
			String s="";
			s="jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";
			c=DriverManager.getConnection(s);
			int TrainNo = Integer.parseInt(request.getParameter("TrainNo"));
			
			Statement st= c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet stt=st.executeQuery("select tr_tvl_class from beu_tvl_classes where tr_no ="+TrainNo+" ");
			stt.absolute(0);
			while(stt.next()) {
				response.getWriter().print("<option>"+stt.getString(1)+"</option>"+"<br>");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	
	

}
