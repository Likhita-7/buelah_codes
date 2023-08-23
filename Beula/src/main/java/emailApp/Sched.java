package emailApp;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sched")
public class Sched extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			String to = request.getParameter("to");
			String subject = request.getParameter("subject");
			String text = request.getParameter("text");
			//Date date = d.parse(request.getParameter("date"));
			Properties properties = System.getProperties();

			// Setting up mail server
			properties.setProperty("mail.smtp.host", "smtp.gmail.com");
			properties.setProperty("mail.smtp.port", "587");
			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("beulahchristi77@gmail.com", "ykwgjicliltbaljj");
				}
			});

			// MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From Field: adding senders email to from field.
			message.setFrom(new InternetAddress("beulahchristi77@gmail.com"));

			// Set To Field: adding recipient's email to from field.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: subject of the email
			message.setSubject(subject);

			// set body of the email.
			message.setText(text);
			String d = request.getParameter("date");
			String[] a = d.split("-");
			int year = Integer.parseInt(a[0]);
			int month = Integer.parseInt(a[1]);
			int day = Integer.parseInt(a[2]);
			System.out.println(year + " " + month + " " + day);

			int hour = Integer.parseInt(request.getParameter("hour"));
			int minutes = Integer.parseInt(request.getParameter("minute"));
			LocalDateTime scheduledDateTime = LocalDateTime.of(year, month, day, hour, minutes); // Set the
																									// scheduled
																									// date and time
			LocalDateTime currentDateTime = LocalDateTime.now();
			long delay = java.time.Duration.between(currentDateTime, scheduledDateTime).toMillis();
			System.out.println("email sending at " + scheduledDateTime + "   " + currentDateTime + "  " + delay);
			//Transport.send(message);
		
		
			Timer t = new Timer();
			System.out.println("Mail scheduled1");
			t.schedule(new TimerTask() {
				
				public void run() {
					System.out.println("Mail scheduled2");
					try {
						Transport.send(message);
						System.out.println("Mail successfully sent");
					} catch (Exception e1) {
					}
				}
			}, delay);
			System.out.println("Mail scheduled3");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Mail scheduled4");
	}

}
