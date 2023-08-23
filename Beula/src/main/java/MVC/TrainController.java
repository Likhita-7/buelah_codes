package MVC;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrainController
 */
@WebServlet("/TrainController")
public class TrainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TrainDAL td = new TrainDAL();
String status="Fare";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void callDAL(HttpServletRequest request, HttpServletResponse response) {

		int pa1, pa2, pa3, pa4, pa5;
		String p1, p2, p3, p4, p5, pg1, pg2, pg3, pg4, pg5;

		try {
			String status = request.getParameter("status");
			// String status = "FromTo";
			if (status.equals("FromTo")) {
				TrainDAL td = new TrainDAL();

				FromTomodel fm = td.FromTo(response);
				String[] s1 = fm.getfrom().split(",");
				for (String x : s1) {
					response.getWriter().print("<option>" + x + "</option>" + "<br>");
				}
			}

			else if (status.equals("Trains")) {
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

			else if (status.equals("Classes")) {
				TrainDAL td = new TrainDAL();

				int TrainNo = Integer.parseInt(request.getParameter("TrainNo"));
				// int TrainNo = 22824;
				ClassModel cm = td.TrainClass(TrainNo, response);
				String[] s = cm.getcls().split(",");
				for (String s1 : s) {
					response.getWriter().print("<option>" + s1 + "</option>" + "<br>");
				}

			}

			else if (status.equals("Fare")) {
				TrainDAL td = new TrainDAL();

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

			} else if (status.equals("Save")) {
				//TrainDAL td = new TrainDAL();
int TrainNo=1222;
String Trname ="dfd";
String lsc="dds";
int Fare=4335;
String from="sfcs";
String to="sfcs";
//				String from = request.getParameter("from");
//				String to = request.getParameter("to");
//				String lsc = request.getParameter("lsc");
//				int TrainNo = Integer.parseInt(request.getParameter("TrainNo"));
//				String Trname = request.getParameter("TrainName");
//
//				int Fare = Integer.parseInt(request.getParameter("fare"));
//				System.out.println(from);
//				System.out.println(to);
//				System.out.println(lsc);
//				System.out.println(Fare);
//				System.out.println(TrainNo);
//				System.out.println(Trname);
//
//				p1 = request.getParameter("p1");
//				p2 = request.getParameter("p2");
//				p3 = request.getParameter("p3");
//				p4 = request.getParameter("p4");
//				p5 = request.getParameter("p5");
//				pa1 = Integer.parseInt(request.getParameter("pa1"));
//				pa2 = Integer.parseInt(request.getParameter("pa2"));
//				pa3 = Integer.parseInt(request.getParameter("pa3"));
//				pa4 = Integer.parseInt(request.getParameter("pa4"));
//				pa5 = Integer.parseInt(request.getParameter("pa5"));
//				pg1 = request.getParameter("pg1");
//				pg2 = request.getParameter("pg2");
//				pg3 = request.getParameter("pg3");
//				pg4 = request.getParameter("pg3");
//				pg5 = request.getParameter("pg4");
//				Passengers pass1 = new Passengers(p1, pa1, pg1);
//				Passengers pass2 = new Passengers(p2, pa2, pg2);
//				Passengers pass3 = new Passengers(p3, pa3, pg3);
//				Passengers pass4 = new Passengers(p4, pa4, pg4);
//				Passengers pass5 = new Passengers(p5, pa5, pg5);
//
//				ArrayList<Passengers> pass = new ArrayList<>();
//				pass.add(pass1);
//				pass.add(pass2);
//				pass.add(pass3);
//				pass.add(pass4);
//				pass.add(pass5);
				// td.SaveDB(TrainNo, Trname, from, to, lsc, pass);
				// Passengers ps = new Passengers(pass);

				 request.setAttribute("TrainNo", TrainNo);
				
				 request.setAttribute("TrainName", Trname);
				 request.setAttribute("From", from);
				 request.setAttribute("To", to);
				 request.setAttribute("TrainClass", lsc);
				 request.setAttribute("fare", Fare);
//				 request.setAttribute("passenger1_name", p1);
//				 request.setAttribute("passenger2_name", p2);
//				 request.setAttribute("passenger3_name", p3);
//				 request.setAttribute("passenger4_name", p4);
//				 request.setAttribute("passenger5_name", p5);
//				System.out.println("hrllo3");
//				 request.setAttribute("passenger1_age", pa1);
//				 request.setAttribute("passenger2_age", pa2);
//				 request.setAttribute("passenger3_age", pa3);
//				 request.setAttribute("passenger4_age", pa4);
//				 request.setAttribute("passenger5_age", pa5);
//				System.out.println("hrllo9");
//				 request.setAttribute("passenger1_gender", pg1);
//				 request.setAttribute("passenger2_gender", pg2);
//				 request.setAttribute("passenger3_gender", pg3);
//				 request.setAttribute("passenger4_gender", pg4);
//				 request.setAttribute("passenger5_gender", pg5);
				System.out.println("hrllo");
				RequestDispatcher dispatcher = request.getRequestDispatcher("preview.jsp");
				dispatcher.forward(request, response);
				// dispatcher.sendRedirect(request, response);
			}
		} catch (Exception e) {

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		callDAL(request, response);
	}
}

