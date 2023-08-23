
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fetchContacts")
public class fetchContacts extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Your database connection details


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contact List</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Contact List</h1>");
        Connection c = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String s = "jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";

		try {
			c = DriverManager.getConnection(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Query the database for the contacts
        String selectQuery = "SELECT mail_id FROM Beucontacts";
        try (
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {
            // Iterate through the result set and display the contacts
        	List<String> emails = new ArrayList<>();

            // Iterate through the result set and add the emails to the list
            while (rs.next()) {
                String email = rs.getString("mail_id");
                emails.add(email);
            }

            // Generate the HTML options using the email addresses
            for (String email : emails) {
                out.println("<option value='" + email + "'>" + email + "</option>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");
    }
}
