<%@page import="com.r3sys.Connection.ConnectionDb"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<h1>View All NGOs</h1>
        
        <table>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Focus Area</th>
            <th>Contact</th>
            <th>Email</th>
          
          </tr>
          <%
            try {
                int ngold=0;
                Connection cn = ConnectionDb.getConnect();
                PreparedStatement ps = cn.prepareStatement("select * from ngo");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
          %>
          <tr>
            <td><%= rs.getInt(1) %></td>
            <td><%= rs.getString(2) %></td>
            <td><%= rs.getString(3) %></td>
            <td><%= rs.getString(4) %></td>
            <td><%= rs.getString(5) %></td>
            <td>
             
            </td>
          </tr>
          <%
                }
                rs.close();
                ps.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
          %>
        </table>
</body>
</html>