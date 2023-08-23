package MVC;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fareServlet
 */
@WebServlet("/fareServlet")
public class fareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainDAL td = new TrainDAL();
		int pa1, pa2, pa3, pa4, pa5;
		String p1, p2, p3, p4, p5, pg1, pg2, pg3, pg4, pg5;

		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String lsc = request.getParameter("lsc");
		System.out.println("Class is" + lsc);
		int TrainNo = Integer.parseInt(request.getParameter("TrainNo"));
		double classfare = td.TrainFareclass(lsc, TrainNo, response);
		System.out.println(classfare);
		double distfare = td.TrainFaredist(from, to, TrainNo, response);
		System.out.println(distfare);
		//
		// double TotalFare = distfare * classfare;
		// System.out.println(TotalFare);
		response.setContentType("text/html");
		p1 = request.getParameter("p1");
		p2 = request.getParameter("p2");
		p3 = request.getParameter("p3");
		p4 = request.getParameter("p4");
		p5 = request.getParameter("p5");
		pa1 = Integer.parseInt(request.getParameter("pa1"));
		pa2 = Integer.parseInt(request.getParameter("pa2"));
		pa3 = Integer.parseInt(request.getParameter("pa3"));
		pa4 = Integer.parseInt(request.getParameter("pa4"));
		pa5 = Integer.parseInt(request.getParameter("pa5"));
		pg1 = request.getParameter("pg1");
		pg2 = request.getParameter("pg2");
		pg3 = request.getParameter("pg3");
		pg4 = request.getParameter("pg3");
		pg5 = request.getParameter("pg4");
		Passengers pass1 = new Passengers(p1, pa1, pg1);
		Passengers pass2 = new Passengers(p2, pa2, pg2);
		Passengers pass3 = new Passengers(p3, pa3, pg3);
		Passengers pass4 = new Passengers(p4, pa4, pg4);
		Passengers pass5 = new Passengers(p5, pa5, pg5);

		ArrayList<Passengers> pass = new ArrayList<>();
		pass.add(pass1);
		pass.add(pass2);
		pass.add(pass3);
		pass.add(pass4);
		pass.add(pass5);

		BusinessLogicFare blf = new BusinessLogicFare();

		List<Double> FinalfareList = blf.bbl(classfare, distfare, pass);
		// double TotalFare1 = 0;
		// for (Passengers y : pass) {
		//
		// if (y.getage() > 10 && y.getage() < 80) {
		// TotalFare1 += TotalFare;
		// } else if (y.getage() > 80 || y.getage() < 10) {
		// TotalFare1 += TotalFare / 2;
		// }
		// }

		// Get the PrintWriter object to write the response
		double TotalFare1 = blf.bblFinal(classfare, distfare, pass);
		PrintWriter out = response.getWriter();
		out.println("<script>document.getElementById('fare').value = " + TotalFare1 + ";</script>");
	}

}
