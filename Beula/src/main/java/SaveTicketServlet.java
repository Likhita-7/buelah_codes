

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveTicketServlet
 */
@WebServlet("/SaveTicketServlet")
public class SaveTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection c=null;
			Class.forName("org.postgresql.Driver");
			
			
			String s="";
			s="jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";
			c=DriverManager.getConnection(s);
			 String from = request.getParameter("from");
			 String to = request.getParameter("to");
			 String Class = request.getParameter("Class");
			 PreparedStatement statement = null;
			int Trno = Integer.parseInt(request.getParameter("TrainNo"));
				String Trname = request.getParameter("TrainName");
				
				String Fare = request.getParameter("fare");
				
				String p1n = request.getParameter("passenger1_name");
				String p2n = request.getParameter("passenger2_name");
				String p3n = request.getParameter("passenger3_name");
				String p4n = request.getParameter("passenger4_name");
				String p5n = request.getParameter("passenger5_name");
//				String p1g = request.getParameter("passenger1_gender");
//				String p2g = request.getParameter("passenger2_gender");
//				String p3g = request.getParameter("passenger3_gender");
//				String p4g = request.getParameter("passenger4_gender");
//				String p5g = request.getParameter("passenger5_gender");
				int p1a = Integer.parseInt(request.getParameter("passenger1_age"));
				int p2a = Integer.parseInt(request.getParameter("passenger2_age"));
				int p3a = Integer.parseInt(request.getParameter("passenger3_age"));
				int p4a = Integer.parseInt(request.getParameter("passenger4_age"));
				int p5a = Integer.parseInt(request.getParameter("passenger5_age"));
			  String sql = "INSERT INTO tickets (name , age  ,fromst ,Tost,TrainNo ,TrainName ,classtr ) VALUES (?,?,?,?,?,?,?)";

		        // Create the prepared statement
		        statement  = c.prepareStatement(sql);

		        // Set the parameter values
		        statement.setString(1, p1n);
		        statement.setInt(2, p1a);
		       
		        statement.setString(3, from);
		        statement.setString(4, to);
		        statement.setInt(5, Trno);
		        statement.setString(6, Trname);
		        statement.setString(7, Class);
		        
		        String sql1 = "INSERT INTO tickets (name , age  ,fromst ,Tost,TrainNo ,TrainName ,classtr ) VALUES (?,?,?,?,?,?,?)";

		        // Create the prepared statement
		        statement  = c.prepareStatement(sql1);

		        // Set the parameter values
		        statement.setString(1, p2n);
		        statement.setInt(2, p2a);
		       
		        statement.setString(3, from);
		        statement.setString(4, to);
		        statement.setInt(5, Trno);
		        statement.setString(6, Trname);
		        statement.setString(7, Class);
		        
		        String sql2 = "INSERT INTO tickets (name , age  ,fromst ,Tost,TrainNo ,TrainName ,classtr ) VALUES (?,?,?,?,?,?,?,?)";

		        // Create the prepared statement
		        statement  = c.prepareStatement(sql2);

		        // Set the parameter values
		        statement.setString(1, p3n);
		        statement.setInt(2, p3a);
		     
		        statement.setString(3, from);
		        statement.setString(4, to);
		        statement.setInt(5, Trno);
		        statement.setString(6, Trname);
		        statement.setString(7, Class);
		        
		        
		        String sql3 = "INSERT INTO tickets (name , age  ,fromst ,Tost,TrainNo ,TrainName ,classtr ) VALUES (?,?,?,?,?,?,?)";

		        // Create the prepared statement
		        statement  = c.prepareStatement(sql3);

		        // Set the parameter values
		        statement.setString(1, p4n);
		        statement.setInt(2, p4a);
		       
		        statement.setString(3, from);
		        statement.setString(4, to);
		        statement.setInt(5, Trno);
		        statement.setString(6, Trname);
		        statement.setString(7, Class);
		        
		        
		        String sql4 = "INSERT INTO tickets (name , age  ,fromst ,Tost,TrainNo ,TrainName ,classtr ) VALUES (?,?,?,?,?,?,?)";

		        // Create the prepared statement
		        statement  = c.prepareStatement(sql4);

		        // Set the parameter values
		        statement.setString(1, p5n);
		        statement.setInt(2, p5a);
		       
		        statement.setString(3, from);
		        statement.setString(4, to);
		        statement.setInt(5, Trno);
		        statement.setString(6, Trname);
		        statement.setString(7, Class);

		        // Execute the query
		        statement.executeUpdate();
	}catch(Exception e) {
		
	}

}
}
