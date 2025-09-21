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


 <table >
            <tr>
                <th>ID</th>
                <th>NgoId</th>
                <th>Title</th>
                <th>Description</th>
                <th>Goal Amount</th>
                <th>Start Date</th>
                <th>Donations</th>
            </tr>
            <%
              try
            {
                  Connection cn=ConnectionDb.getConnect();
                  PreparedStatement ps=cn.prepareStatement("select * from projects");
                  ResultSet rs=ps.executeQuery();
                  while(rs.next())
                  {
            %>
                      
                       <tr>
                            <td><%=rs.getInt(1) %></td>
                            <td><%=rs.getInt(2) %></td>
                            <td><%=rs.getString(3) %></td>
                            <td><%=rs.getString(4)%></td>
                            <td><%=rs.getString(5)%></td>
                            <td><%=rs.getString(6)%></td>
                            <td><a href="d4_DonatToNgo.html">Donate</a></td>
                       </tr>
            <% 
                  }
                  
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            %>
        </table>
</body>
</html>