import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  String[] recipients = new String[4];
	  //recipients[0]="beulahchristi77@gmail.com";
	  recipients[0]="beulahganji77@gmail.com";
	  //recipients[2]="seeladevi2002@gmail.com";
    // recipients = request.getParameterValues("recipients");
    System.out.println(recipients[0]);
   
    String subject = request.getParameter("subject");
    System.out.println(subject);
    String body = request.getParameter("body");
    String scheduleDate = request.getParameter("scheduleDate");

    // Check if the schedule date is provided
    if (scheduleDate != null && !scheduleDate.isEmpty()) {
      // Schedule the email based on the provided date
      LocalDate scheduledDate = LocalDate.parse(scheduleDate);

      // Store the scheduled email in the database
      storeScheduledEmail(recipients, subject, body, scheduledDate);

      // Redirect to a success page or display a success message
      response.sendRedirect("success.html");
    } else {
      // Send the email immediately
      for (String recipient : recipients) {
        sendEmail(recipient, subject, body);
        String htmlResponse = "<h2>Email Sent!</h2>"
                + "<p>Recipients: " +recipient + "</p>";

        // Set the response content type
        response.setContentType("text/html");

        // Write the HTML response to the client
        PrintWriter out = response.getWriter();
        out.println(htmlResponse);
        out.close();
      }

      // Redirect to a success page or display a success message
      response.sendRedirect("success.html");
    }
  }

  private void sendEmail(String recipientEmail, String subject, String body) {
    // Your email configuration details
	 
    String senderEmail = "beulahchristi77@gmail.com";
    String senderPassword = "ykwgjicliltbaljj";

    // Email properties
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.ssl.protocols", "TLSv1.2");

    // Create the session with authentication
    
    props.put("mail.smtp.ssl.ciphersuites", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
 // Disable SSL certificate validation
    props.put("mail.smtp.ssl.trust", "*");
    Session session = Session.getInstance(props, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(senderEmail, senderPassword);
      }
    });
   


    try {
      // Create the email message
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(senderEmail));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
      message.setSubject(subject);
      message.setText(body);

      // Send the email
      Transport.send(message);

      System.out.println("Email sent successfully to: " + recipientEmail);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

  public void storeScheduledEmail(String[] recipients, String subject, String body, LocalDate scheduledDate) {
    // Your database connection details
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

    // Database query to insert the scheduled email
    String insertQuery = "INSERT INTO scheduled_emails (to_email, subject, body, schedule_date) VALUES (?, ?, ?, ?)";

    try (
         PreparedStatement pstmt = c.prepareStatement(insertQuery)) {
      for (String recipient : recipients) {
        pstmt.setString(1, recipient);
        pstmt.setString(2, subject);
        pstmt.setString(3, body);
        pstmt.setDate(4, Date.valueOf(scheduledDate));
        pstmt.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
