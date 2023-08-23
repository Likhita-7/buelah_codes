package MVC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FinalTicketServlet
 */
@WebServlet("/FinalTicketServlet")
public class FinalTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TrainDAL td = new TrainDAL();
		System.out.println("Inside trainfare");
		int pa1, pa2, pa3, pa4, pa5;
		
		String p1, p2, p3, p4, p5, pg1, pg2, pg3, pg4, pg5;
//		ArrayList<String> ss = new ArrayList<String>();
//		ArrayList<String> cs = new ArrayList<String>();
//		ArrayList<String> ss1 = new ArrayList<String>();
//		ArrayList<String> s1 = new ArrayList<String>();
//		ArrayList<String> s2 = new ArrayList<String>(); 
//		ArrayList<String> s3 = new ArrayList<String>();
//		ArrayList<String> s4 = new ArrayList<String>();
//		ArrayList<String> s5 = new ArrayList<String>();
		BusinessLogicFare blf = new BusinessLogicFare();
//		
//		cs.add(request.getParameter("TrainClass"));
//		cs.add(request.getParameter("TrainClass"));
//		cs.add(request.getParameter("TrainClass"));
//		cs.add(request.getParameter("TrainClass"));
//		cs.add(request.getParameter("TrainClass"));
//		cs.add(request.getParameter("TrainClass"));
		String from = request.getParameter("From");
		String to = request.getParameter("To");
		String lsc = request.getParameter("TrainClass");
		System.out.println(from);
		System.out.println(to);
		System.out.println(lsc);
		
		int TrainNo = Integer.parseInt(request.getParameter("TrainNo"));
		String Trname = request.getParameter("TrainName");
	    System.out.println("finaltick");
//		ss.add(request.getParameter("From"));
//		ss1.add(request.getParameter("To"));
//		s1.add(request.getParameter("TrainNo"));
//		s2.add(request.getParameter("TraiName"));
//		s3.add(request.getParameter("passenger1_name"));
//		s4.add(request.getParameter("passenger1_age"));
//		s5.add(request.getParameter("passenger1_gender"));
//		ss.add(request.getParameter("From"));
//		ss1.add(request.getParameter("To"));
//		s1.add(request.getParameter("TrainNo"));
//		s2.add(request.getParameter("TraiName"));
//		s3.add(request.getParameter("passenger2_name"));
//		s4.add(request.getParameter("passenger2_age"));
//		s5.add(request.getParameter("passenger2_gender"));
//		ss.add(request.getParameter("From"));
//		ss1.add(request.getParameter("To"));
//		s1.add(request.getParameter("TrainNo"));
//		s2.add(request.getParameter("TraiName"));
//		s3.add(request.getParameter("passenger3_name"));
//		s4.add(request.getParameter("passenger3_age"));
//		s5.add(request.getParameter("passenger3_gender"));
//		ss.add(request.getParameter("From"));
//		ss1.add(request.getParameter("To"));
//		s1.add(request.getParameter("TrainNo"));
//		s2.add(request.getParameter("TraiName"));
//		s3.add(request.getParameter("passenger4_name"));
//		s4.add(request.getParameter("passenger4_age"));
//		s5.add(request.getParameter("passenger4_gender"));
//		ss.add(request.getParameter("From"));
//		ss1.add(request.getParameter("To"));
//		s1.add(request.getParameter("TrainNo"));
//		s2.add(request.getParameter("TraiName"));
//		s3.add(request.getParameter("passenger5_name"));
//		s4.add(request.getParameter("passenger5_age"));
//		s5.add(request.getParameter("passenger5_gender"));
		
		p1 = request.getParameter("passenger1_name");
		p2 = request.getParameter("passenger2_name");
		p3 = request.getParameter("passenger3_name");
		p4 = request.getParameter("passenger4_name");
		p5 = request.getParameter("passenger5_name");
		pa1 = Integer.parseInt(request.getParameter("passenger1_age"));
		pa2 = Integer.parseInt(request.getParameter("passenger2_age"));
		pa3 = Integer.parseInt(request.getParameter("passenger3_age"));
		pa4 = Integer.parseInt(request.getParameter("passenger4_age"));
		pa5 = Integer.parseInt(request.getParameter("passenger5_age"));
		pg1 = request.getParameter("passenger1_gender");
		pg2 = request.getParameter("passenger2_gender");
		pg3 = request.getParameter("passenger3_gender");
		pg4 = request.getParameter("passenger4_gender");
		pg5 = request.getParameter("passenger5_gender");
	System.out.println("fare");
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
		double classfare = td.TrainFareclass(lsc,TrainNo, response);
		System.out.println(classfare);
		double distfare = td.TrainFaredist(from, to, TrainNo, response);
		List<Double> farelist=blf.bbl(classfare,distfare, pass);
//		for (int i = 0; i < 5; i++) {
			td.SaveDB(TrainNo, Trname, from, to, lsc, pass1,farelist.get(0));
			td.SaveDB(TrainNo, Trname, from, to, lsc, pass2,farelist.get(0));
			td.SaveDB(TrainNo, Trname, from, to, lsc, pass3,farelist.get(0));
			td.SaveDB(TrainNo, Trname, from, to, lsc, pass4,farelist.get(0));
			td.SaveDB(TrainNo, Trname, from, to, lsc, pass5,farelist.get(0));
//		}
		System.out.println("Insert Successful");
	}

}
