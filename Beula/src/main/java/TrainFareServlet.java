

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrainFareServlet
 */
@WebServlet("/TrainFareServlet")
public class TrainFareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainFareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection c=null;
			Class.forName("org.postgresql.Driver");
			
			String s="";
			s="jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";
			c=DriverManager.getConnection(s);
			
			 String from = request.getParameter("from");
			 String to = request.getParameter("to");
			 String Class = request.getParameter("Class");

			int TrainNo = Integer.parseInt(request.getParameter("TrainNo"));
			int p1age = Integer.parseInt(request.getParameter("p1age"));
			int p2age = Integer.parseInt(request.getParameter("p2age"));
			int p3age = Integer.parseInt(request.getParameter("p3age"));
			int p4age = Integer.parseInt(request.getParameter("p4age"));
			int p5age = Integer.parseInt(request.getParameter("p5age"));
//			String from="ND";
//			String to="BBR";
//			String Class="3AC";
//			 int TrainNo = 22824;
			// System.out.println(from);
			// System.out.println(to);
			// System.out.println(Class);
			// System.out.println(TrainNo);
			System.out.println(p1age);
			System.out.println(p2age);
			System.out.println(p3age);

			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st1 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st2 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st3 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// ResultSet stt=st.executeQuery("select * from beu_stn_dis where fst_code='"+from+"' and
			// tst_code='"+to+"'");
			// stt.absolute(1);
			// System.out.println(stt.getInt(3));
			// int dist=stt.getInt(3);
//			String from = request.getParameter("from");
//			String to = request.getParameter("to");
//			String Class = request.getParameter("Class");

			ResultSet stt = st.executeQuery("select * from beu_stn_dis");
			ResultSet stt3 = st1.executeQuery("select * from beu_stn_dis");
			stt.absolute(0);
			stt3.absolute(0);
			int dist = 0;
			while (stt.next()) {

				// int TrainNo = Integer.parseInt(request.getParameter("TrainNo"));
				System.out.println(stt.getString(1));

				if (stt.getString(1).equals(from)) {

					System.out.println("dist is" + dist);
					while (stt3.next()) {

						if ((stt3.getString(2).equals(to))) {
							System.out.println("each dist" + (stt3.getInt(3)));
							dist = dist + stt3.getInt(3);
							break;
						} else {
							System.out.println("each dist" + (stt3.getInt(3)));
							dist = dist + stt3.getInt(3);
						}

					}

				}
			}

			System.out.println("dist is" + dist);
			stt.close();
			ResultSet stt1 = st.executeQuery(
					"select * from beu_tr_fares where far_dist=(select min(far_dist) from beu_tr_fares where far_dist>="
							+ dist + ")");
			stt1.absolute(1);
			System.out.println("fare" + stt1.getInt(2));
			int faredist = stt1.getInt(2);
			ResultSet stt2 = st.executeQuery(
					"select * from beu_tvl_classes where tr_no=" + TrainNo + " and tr_tvl_class='" + Class + "'");
			stt2.absolute(1);
			Double farefactor = stt2.getDouble(3);
			System.out.println("fare factor" + stt2.getDouble(3));
			Double TotalFare = farefactor * faredist;
			System.out.println(TotalFare);
			response.setContentType("text/html");

	        // Get the PrintWriter object to write the response
	        PrintWriter out = response.getWriter();
	        double TotalFare1=0,TotalFare2=0,TotalFare3=0,TotalFare4=0,TotalFare5=0;
	        if(p1age>10 && p1age<80) {
	        	 TotalFare1=TotalFare;
	        }
	        else if(p1age>80 || p1age<10){
	        	 TotalFare1=TotalFare/2;
	        }
	        if(p2age>10 && p2age<80) {
	        	 TotalFare2=TotalFare;
	        }
	        else if(p2age>80 || p2age<10){
	        	 TotalFare2=TotalFare/2;
	        }
	        if(p3age>10 && p3age<80) {
	        	 TotalFare3=TotalFare;
	        }
	        else if(p3age>80 || p3age<10){
	        	 TotalFare3=TotalFare/2;
	        }
	        if(p4age>10 && p4age<80) {
	        	 TotalFare4=TotalFare;
	        }
	        else if(p4age>80 || p4age<10){
	        	 TotalFare4=TotalFare/2;
	        }
	        if(p5age>10 && p5age<80) {
	        	 TotalFare5=TotalFare;
	        }
	        else if(p5age>80 || p5age<10){
	        	 TotalFare5=TotalFare/2;
	        }
	      double total=TotalFare1+TotalFare2+TotalFare3+TotalFare4+TotalFare5;
	        // Write the HTML response with the TotalFare value
	       // out.println("<h4>TotalFare is: " +TotalFare + "</h4><br>");

	        // Set the value of an HTML field using JavaScript
	        out.println("<script>document.getElementById('fare').value = " + total + ";</script>");
	    
	        
			 // response.getWriter().print("<h4>"+"TotalFare is:  "+TotalFare+"</h4>"+"<br>");
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	
}
