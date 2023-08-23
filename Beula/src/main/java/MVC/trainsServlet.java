package MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class trainsServlet
 */
@WebServlet("/trainsServlet")
public class trainsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trainsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainDAL td = new TrainDAL();

		String from = request.getParameter("from");
		String to = request.getParameter("to");

		TrainsModel tm = td.Trains(from, to, response);
		String s1[] = tm.getTrainName().split(",");
		String s2[] = tm.getTrainno().split(",");
		for (int i = 0; i < s1.length; i++) {
			String y = " ";
			y += s2[i] + " " + s1[i];

			response.getWriter().print("<option>" + y + "</option>" + "<br>");

		}
	}

}
