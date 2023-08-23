
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // Start the email scheduler
    EmailScheduler.scheduleEmails();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
	    // Clean up any resources if needed
	  }
	}
