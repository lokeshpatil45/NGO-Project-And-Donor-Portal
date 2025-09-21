package com.r3sys.NGO_DONOR_Projects;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.Connection.ConnectionDb;

import Getter_Setter.Ngo;
import Getter_Setter.Projects;

/**
 * Servlet implementation class NgoPostProjects
 */
public class NgoPostProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NgoPostProjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
		try
		{
			int pid=0;
			int ngoid=Ngo.getNid();
			String title=request.getParameter("title");
			String description=request.getParameter("description");
			String goalAmount=request.getParameter("goalAmount");
			String startDate=request.getParameter("startDate");
			String status = "";
			Connection cn=ConnectionDb.getConnect();
			PreparedStatement ps=cn.prepareStatement("insert into projects values(?,?,?,?,?,?)");
			ps.setInt(1, pid);
			ps.setInt(2, ngoid);
			ps.setString(3, title);
			ps.setString(4, description);
			ps.setString(5, goalAmount);
			ps.setString(6, startDate);
			System.out.println(ngoid);
			int i=ps.executeUpdate();
			if(i>0)
			{
				
				response.sendRedirect("n6_NgoDashBoard.html");
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
	}

}
