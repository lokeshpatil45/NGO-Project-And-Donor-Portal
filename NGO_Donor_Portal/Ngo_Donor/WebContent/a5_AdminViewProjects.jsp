<%@page import="java.sql.*"%>
<%@page import="com.r3sys.Connection.ConnectionDb"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Projects</title>
</head>
<body>

    <h2>Project List</h2>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>NGO ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Goal Amount</th>
            <th>Start Date</th>
        </tr>
        <%
            try {
                Connection cn = ConnectionDb.getConnect();
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM projects");
                 ResultSet rs = ps.executeQuery();
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt(1) %></td>
            <td><%= rs.getString(2) %></td>
            <td><%= rs.getString(3) %></td>
            <td><%= rs.getString(4) %></td>
            <td><%= rs.getString(5) %></td>
            <td><%= rs.getString(6) %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } 
        %>
    </table>

</body>
</html>
