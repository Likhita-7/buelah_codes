package MVC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public class TrainDAL {

	public FromTomodel FromTo(HttpServletResponse response) {
		FromTomodel fm = new FromTomodel();
		String s1 = " ";
		try {
			Connection c = null;
			Class.forName("org.postgresql.Driver");

			String s = "";

			s = "jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";

			c = DriverManager.getConnection(s);
			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet stt = st.executeQuery("select * from sow_stn");
			stt.absolute(0);
			String arr[] = {};
			while (stt.next()) {

				s1 = s1 + stt.getString(1);
				fm.setfrom(s1);

				s1 = " ";
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return fm;
	}

	public TrainsModel Trains(String from, String to, HttpServletResponse response) {
		TrainsModel tm = new TrainsModel();
		String dat = "";
		try {
			Connection c = null;

			Class.forName("org.postgresql.Driver");

			String s = "jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";

			c = DriverManager.getConnection(s);

			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			PreparedStatement p = c.prepareStatement(
					"select * from sow_trains where tr_no in(select tr_no  from sow_stn where stn_code =?  ) and tr_no in(select tr_no from sow_stn where stn_code =?) ");
			p.setString(1, from);
			p.setString(2, to);
			ResultSet stt = p.executeQuery();

			while (stt.next()) {

				dat = stt.getString(1);
				tm.setTrainno(dat);
				dat = stt.getString(2);
				tm.setTrainName(dat);

				dat = " ";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tm;
	}

	public ClassModel TrainClass(int TrainNo, HttpServletResponse response) {
		String se = " ";
		ClassModel cm = new ClassModel();
		try {
			Connection conn = null;

			String cs;
			Class.forName("org.postgresql.Driver");
			cs = "jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";
			conn = DriverManager.getConnection(cs);
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet stt = st.executeQuery("select * from tn_tvl_classes where tr_no =" + TrainNo + " ");
			System.out.println("hello1");
			stt.absolute(0);
			while (stt.next()) {
				se = " ";
				se += stt.getString(2) + ",";

				cm.setcls(se);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return cm;
	}

	public int TrainFaredist(String from, String to, int TrainNo, HttpServletResponse response) {

		// dist, class cost
		int faredist = 0;
		try {
			Connection c = null;
			Class.forName("org.postgresql.Driver");

			String s = "";
			s = "jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";
			c = DriverManager.getConnection(s);

			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st1 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st2 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st3 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet stt = st.executeQuery("select * from sow_stn_dis");
			ResultSet stt3 = st1.executeQuery("select * from sow_stn_dis");
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
					"select * from sow_tr_fares where far_dist=(select min(far_dist) from sow_tr_fares where far_dist>="
							+ dist + ")");
			stt1.absolute(1);
			System.out.println("fare" + stt1.getInt(2));
			faredist = stt1.getInt(2);

			// response.setContentType("text/html");
			//
			// // Get the PrintWriter object to write the response
			// PrintWriter out = response.getWriter();
			//
			// out.println("<script>document.getElementById('fare').value = " + TotalFare + ";</script>");

		} catch (Exception e) {
			System.out.println(e);
		}
		return faredist;

	}

	public double TrainFareclass(String clss, int TrainNo, HttpServletResponse response) {
		double farefactor = 0.0;
		// dist, class cost
		try {
			Connection c = null;
			Class.forName("org.postgresql.Driver");

			String s = "";
			s = "jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";
			c = DriverManager.getConnection(s);

			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st1 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st2 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			Statement st3 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet stt2 = st.executeQuery(
					"select * from tn_tvl_classes where tr_no=" + TrainNo + " and tr_tvl_class='" + clss + "'");
			stt2.absolute(1);
			farefactor = stt2.getDouble(3);

			// response.setContentType("text/html");
			//
			// // Get the PrintWriter object to write the response
			// PrintWriter out = response.getWriter();
			//
			// out.println("<script>document.getElementById('fare').value = " + TotalFare + ";</script>");

		} catch (Exception e) {
			System.out.println(e);
		}
		return farefactor;
	}

	public void SaveDB(int Trno, String Trname, String from, String to, String cls, Passengers pass,double fd) {
		try {
			Connection c = null;
			Class.forName("org.postgresql.Driver");

			String s = "";
			s ="jdbc:postgresql://localhost:5432/newdb?user=postgres&password=Beuganji7@";
			c = DriverManager.getConnection(s);
			PreparedStatement statement = null;
			
				String sql = "INSERT INTO tickets (name , age ,gender,fromst ,Tost,TrainNo ,TrainName ,classtr,fare ) VALUES (?,?,?,?,?,?,?,?,?)";

				// Create the prepared statement
				statement = c.prepareStatement(sql);

				// Set the parameter values
				System.out.println(pass.getName());
				statement.setString(1, pass.getName());
				System.out.println(pass.getage());
				statement.setInt(2, pass.getage());
				statement.setString(3, pass.getGender());
				System.out.println(pass.getGender());
				statement.setString(4, from);
				statement.setString(5, to);
				statement.setInt(6, Trno);
				System.out.println(from);
				statement.setString(7, Trname);
				statement.setString(8, cls);
				statement.setDouble(9, fd);
			
			//TicketModel tm = new TicketModel(Trname, Trno, from, to, cls, pass);

		} catch (Exception e) {

		}

	}

}
