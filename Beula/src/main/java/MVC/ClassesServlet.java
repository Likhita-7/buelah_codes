package MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassesServlet
 */
@WebServlet("/ClassesServlet")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainDAL td = new TrainDAL();

		int TrainNo = Integer.parseInt(request.getParameter("TrainNo"));
		// int TrainNo = 22824;
		ClassModel cm = td.TrainClass(TrainNo, response);
		String[] s = cm.getcls().split(",");
		for (String s1 : s) {
			response.getWriter().print("<option>" + s1 + "</option>" + "<br>");
		}
	}

}
