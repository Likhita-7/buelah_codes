package MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FromToServlet
 */
@WebServlet("/FromToServlet")
public class FromToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FromToServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainDAL td = new TrainDAL();

		FromTomodel fm = td.FromTo(response);
		String[] s1 = fm.getfrom().split(",");
		for (String x : s1) {
			response.getWriter().print("<option>" + x + "</option>" + "<br>");
		}
	}

}
