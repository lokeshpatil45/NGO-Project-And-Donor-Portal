package com.r3sys.NGO_DONOR_Projects;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.Connection.ConnectionDb;

import Getter_Setter.Donor;
import Getter_Setter.Projects;

/**
 * Servlet implementation class DonateToNgo
 */
public class DonateToNgo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateToNgo() {
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
			int id=0;
			String donorName=Donor.getName();
			int projectId=Projects.getPid();
			String amount=request.getParameter("amount");
			String date=request.getParameter("date");
			Connection cn=ConnectionDb.getConnect();
			PreparedStatement ps=cn.prepareStatement("insert into donations values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, donorName);
			ps.setInt(3, projectId);
			ps.setString(4, amount);
			ps.setString(5, date);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("d7_DonorDashboard.html");
				
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
