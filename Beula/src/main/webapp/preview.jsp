<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.sql.Connection"%>
<%@ page import ="java.sql.DriverManager"%>
<%@ page import= "java.sql.ResultSet"%>
<%@ page import ="java.sql.Statement"%>

<%@ page import ="javax.servlet.ServletException"%>
<%@ page import ="javax.servlet.annotation.WebServlet"%>
<%@ page import ="javax.servlet.http.HttpServlet"%>
<%@ page import ="javax.servlet.http.HttpServletRequest"%>
<%@ page import ="javax.servlet.http.HttpServletResponse" %>
<%@ page import ="javax.servlet.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<center>
<form action="FinalTicketServlet" method="post">
<table>

  <tr>
    <th>Train Number</th>
    <th>Train Name</th>
    <th>From</th>
    <th>To</th>
    <th>Class</th>
    <th>Fare</th>
  </tr>
  <tr>
    <td><%= request.getAttribute("TrainNo")%></td>
    <td><%= request.getAttribute("TrainName")%></td>
    <td><%= request.getAttribute("From")%></td>
    <td><%= request.getAttribute("To")%></td>
    <td><%= request.getAttribute("TrainClass")%></td>
    <td><%= request.getAttribute("fare")%></td>
     <input type="hidden" id= "TrainNo" name="TrainNo" value="<%= request.getAttribute("TrainNo") %>">
      <input type="hidden" id="TrainName" name="TrainName" value="<%= request.getAttribute("TrainName") %>">
      <input type="hidden" id="From" name="From" value="<%= request.getAttribute("From") %>">
      <input type="hidden" id="To" name="To" value="<%= request.getAttribute("To") %>">
       <input type="hidden" id="TrainClass" name="TrainClass" value="<%= request.getAttribute("TrainClass") %>">
        <input type="hidden"  id="fare" name="fare" value="<%= request.getAttribute("fare") %>">
  </tr>
</table>
</center>
<br>
<center>
<table>
  <tr>
    <th>Passenger Name</th>
    <th>Passenger Age</th>
     <th>Passenger Gender</th>
     <th>Passenger Fare</th>
  </tr>
  <tr>
    <td><%= request.getAttribute("passenger1_name") %></td>
    <td><%= request.getAttribute("passenger1_age") %></td>
    <td><%= request.getAttribute("passenger1_gender") %></td>
    <td><%= request.getAttribute("fare1") %></td>
    <input type="hidden" name="passenger1_name" value="<%= request.getAttribute("passenger1_name") %>">
      <input type="hidden" name="passenger1_age" value="<%= request.getAttribute("passenger1_age") %>">
      <input type="hidden" name="passenger1_gender" value="<%= request.getAttribute("passenger1_gender") %>">
      <input type="hidden" name="fare1" value="<%= request.getAttribute("fare1") %>">
  </tr>
  <tr>
    <td><%= request.getAttribute("passenger2_name") %></td>
    <td><%= request.getAttribute("passenger2_age") %></td>
    <td><%= request.getAttribute("passenger2_gender") %></td>
    <td><%= request.getAttribute("fare2") %></td>
     <input type="hidden" name="passenger2_name" value="<%= request.getAttribute("passenger2_name") %>">
      <input type="hidden" name="passenger2_age" value="<%= request.getAttribute("passenger2_age") %>">
      <input type="hidden" name="passenger2_gender" value="<%= request.getAttribute("passenger2_gender") %>">
      <input type="hidden" name="fare2" value="<%= request.getAttribute("fare2") %>">
  </tr>
  <tr>
 <td><%= request.getAttribute("passenger3_name") %></td>
    <td><%= request.getAttribute("passenger3_age") %></td>
    <td><%= request.getAttribute("passenger3_gender") %></td>
    <td><%= request.getAttribute("fare3") %></td>
    <input type="hidden" name="passenger3_name" value="<%= request.getAttribute("passenger3_name") %>">
      <input type="hidden" name="passenger3_age" value="<%= request.getAttribute("passenger3_age") %>">
      <input type="hidden" name="passenger3_gender" value="<%= request.getAttribute("passenger3_gender") %>">
      <input type="hidden" name="fare3" value="<%= request.getAttribute("fare3") %>">
  </tr>
  <tr>
    <td><%= request.getAttribute("passenger4_name") %></td>
    <td><%= request.getAttribute("passenger4_age") %></td>
    <td><%= request.getAttribute("passenger4_gender") %></td>
    <td><%= request.getAttribute("fare4") %></td>
    <input type="hidden" name="passenger4_name" value="<%= request.getAttribute("passenger4_name") %>">
      <input type="hidden" name="passenger4_age" value="<%= request.getAttribute("passenger4_age") %>">
      <input type="hidden" name="passenger4_gender" value="<%= request.getAttribute("passenger4_gender") %>">
      <input type="hidden" name="fare4" value="<%= request.getAttribute("fare4") %>">
  </tr>
  <tr>
    <td><%= request.getAttribute("passenger5_name") %></td>
    <td><%= request.getAttribute("passenger5_age") %></td>
    <td><%= request.getAttribute("passenger5_gender") %></td>
    <td><%= request.getAttribute("fare5") %></td>
    <input type="hidden" name="passenger5_name" value="<%= request.getAttribute("passenger5_name") %>">
      <input type="hidden" name="passenger5_age" value="<%= request.getAttribute("passenger5_age") %>">
      <input type="hidden" name="passenger5_gender" value="<%= request.getAttribute("passenger5_gender") %>">
      <input type="hidden" name="fare5" value="<%= request.getAttribute("fare5") %>">
  </tr>
  </table>
  <br>
  <input type="submit" value="Submit">
</form>
  </center>
 
<button onclick="history.back()">back</button>

</body>
</html>