
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.mail.*;
import javax.mail.internet.*;

public class EmailScheduler implements Runnable {

  // Your database connection details
//	jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@
 

  // Your email configuration details
  private static final String senderEmail = "beulahchristii77@gmail.com";
  private static final String senderPassword = "ykwgjicliltbaljj";
  

  @Override
  public void run() {
    // Retrieve the current date
    LocalDate currentDate = LocalDate.now();
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

    // Query the database for scheduled emails with a scheduled date less than or equal to the current date
    String selectQuery = "SELECT * FROM scheduled_emails WHERE schedule_date <= ?";
    try (
         PreparedStatement pstmt = c.prepareStatement(selectQuery)) {
      pstmt.setDate(1, Date.valueOf(currentDate));
      ResultSet rs = pstmt.executeQuery();

      // Iterate through the result set and send the scheduled emails
      while (rs.next()) {
        String recipientEmail = rs.getString("to_email");
        String subject = rs.getString("subject");
        String body = rs.getString("body");

        // Send the email
        sendEmail(recipientEmail, subject, body);

        // Delete the scheduled email from the database
        deleteScheduledEmail(rs.getInt("id"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // Schedule birthday emails
    scheduleBirthdayEmails();
  }

  public void scheduleBirthdayEmails() {
	  // Retrieve the current date
	  LocalDate currentDate = LocalDate.now();
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

	  // Query the database for contacts with birthdays on the current date
	  String selectQuery = "SELECT * FROM Beucontacts WHERE EXTRACT(MONTH FROM date_of_birth) = ? AND EXTRACT(DAY FROM date_of_birth) = ?";
	  try (
	       PreparedStatement pstmt = c.prepareStatement(selectQuery)) {
	    pstmt.setInt(1, currentDate.getMonthValue());
	    pstmt.setInt(2, currentDate.getDayOfMonth());
	    ResultSet rs = pstmt.executeQuery();

	    // Iterate through the result set and schedule the birthday emails
	    while (rs.next()) {
	      String recipientEmail = rs.getString("mail_id");
	      String subject = "Happy Birthday!";
	      String body = "Happy Birthday to you, " + rs.getString("name") + "!";
	      LocalDate scheduledDate = currentDate.plusDays(1); // Schedule the email for the next day

	      // Store the scheduled email in the database
	      storeScheduledEmail(new String[]{recipientEmail}, subject, body, scheduledDate);
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	}


  private void sendEmail(String recipientEmail, String subject, String body) {
    // Email properties
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    // Create the session with authentication
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

  private void deleteScheduledEmail(int emailId) {
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
    // Delete the scheduled email from the database
    String deleteQuery = "DELETE FROM scheduled_emails WHERE id = ?";
    try (
         PreparedStatement pstmt = c.prepareStatement(deleteQuery)) {
      pstmt.setInt(1, emailId);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void scheduleEmails() {
    // Create a scheduled executor service with a single thread
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    // Schedule the email scheduler to run every minute
    executorService.scheduleAtFixedRate(new EmailScheduler(), 0, 1, TimeUnit.MINUTES);
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
