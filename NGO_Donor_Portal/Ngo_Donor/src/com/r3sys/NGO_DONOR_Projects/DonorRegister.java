package com.r3sys.NGO_DONOR_Projects;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.Connection.ConnectionDb;

/**
 * Servlet implementation class DonorRegister
 */
public class DonorRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorRegister() {
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
			int did=0;
			String name=request.getParameter("name");
			String contact=request.getParameter("contact");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			Connection cn=ConnectionDb.getConnect();
			PreparedStatement ps=cn.prepareStatement("insert into donor values(?,?,?,?,?)");
			ps.setInt(1,did);
			ps.setString(2,name);
			ps.setString(3,contact);
			ps.setString(4,email);
			ps.setString(5,password);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("d2_DonorLogin.html");
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
