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



<%
try{
		int ngold=Integer.parseInt(request.getParameter("ngold"));
		Connection cn=ConnectionDb.getConnect();
		PreparedStatement ps=cn.prepareStatement("delete from ngo where nid=?");
		ps.setInt(1,ngold);
		int i=ps.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("a1_AdminAddNgos.jsp");
		}
		else
		{
			response.sendRedirect("error.html");
		}
}
catch(Exception e)
{
	e.printStackTrace();
}
%>

</body>
</html>