<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>



<%@ page import ="java.io.IOException"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="javax.servlet.ServletException"%>
<%@ page import ="java.sql.*"%>

<%@ page import ="javax.servlet.annotation.WebServlet"%>
<%@ page import ="javax.servlet.http.HttpServlet"%>
<%@ page import ="javax.servlet.http.HttpServletRequest"%>
<%@ page import ="javax.servlet.http.HttpServletResponse"%>
<%@ page import =" javax.servlet.RequestDispatcher"%>



<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<%= request.getAttribute("fare") %>
<%

 
ArrayList<String> ss = new ArrayList<String>();
ArrayList<String> cs = new ArrayList<String>();
ArrayList<String> ss1 = new ArrayList<String>();
ArrayList<String> s1 = new ArrayList<String>();
ArrayList<String> s2 = new ArrayList<String>(); 
ArrayList<String> s3 = new ArrayList<String>();
ArrayList<String> s4 = new ArrayList<String>();
ArrayList<String> s5 = new ArrayList<String>();
cs.add(request.getParameter("lsc"));
cs.add(request.getParameter("lsc"));
cs.add(request.getParameter("lsc"));
cs.add(request.getParameter("lsc"));
cs.add(request.getParameter("lsc"));
cs.add(request.getParameter("lsc"));

ss.add(request.getParameter("from"));
ss1.add(request.getParameter("to"));
s1.add(request.getParameter("TrainNo"));
s2.add(request.getParameter("TraiName"));
s3.add(request.getParameter("p1"));
s4.add(request.getParameter("pa1"));
s5.add(request.getParameter("pg1"));
ss.add(request.getParameter("from"));
ss1.add(request.getParameter("to"));
s1.add(request.getParameter("TrainNo"));
s2.add(request.getParameter("TraiName"));
s3.add(request.getParameter("p2"));
s4.add(request.getParameter("pa2"));
s5.add(request.getParameter("pg2"));
ss.add(request.getParameter("from"));
ss1.add(request.getParameter("to"));
s1.add(request.getParameter("TrainNo"));
s2.add(request.getParameter("TraiName"));
s3.add(request.getParameter("p3"));
s4.add(request.getParameter("pa3"));
s5.add(request.getParameter("pg3"));
ss.add(request.getParameter("from"));
ss1.add(request.getParameter("to"));
s1.add(request.getParameter("TrainNo"));
s2.add(request.getParameter("TraiName"));
s3.add(request.getParameter("p4"));
s4.add(request.getParameter("pa4"));
s5.add(request.getParameter("pg4"));
ss.add(request.getParameter("from"));
ss1.add(request.getParameter("to"));
s1.add(request.getParameter("TrainNo"));
s2.add(request.getParameter("TraiName"));
s3.add(request.getParameter("p5"));
s4.add(request.getParameter("pa5"));
s5.add(request.getParameter("pg5"));
		//System.out.println(s3.get(1));
		for (int i = 0; i < s1.size(); i++) {
			if (s3.get(i).equals("")) {
				break;}
			else{
				response.getWriter().print("From:" + ss.get(i) + "<br>");
				response.getWriter().print("To:" + ss1.get(i) + "<br>");
				response.getWriter().print("Class:" + cs.get(i) + "<br>");
				response.getWriter().print("TrainNo:" + s1.get(i) + "<br>");
				response.getWriter().print("TrainName:" + s2.get(i) + "<br>");
				response.getWriter().print("pname:" + s3.get(i) + "<br>");
				response.getWriter().print("page:" + s4.get(i) + "<br>");
				response.getWriter().print("pgender:" + s5.get(i) + "<br>");			}
		}
		response.getWriter().print("fare:" +" "+ "<br>");


%>
</body>
</html>

