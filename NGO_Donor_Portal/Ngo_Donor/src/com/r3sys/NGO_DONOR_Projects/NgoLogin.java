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
 * Servlet implementation class NgoLogin
 */
public class NgoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NgoLogin() {
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
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			Connection cn=ConnectionDb.getConnect();
			PreparedStatement ps=cn.prepareStatement("select * from ngo where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Ngo.setNid(rs.getInt(1));
				Projects.setPid(rs.getInt(1));
				response.sendRedirect("n3_NgoPostProjects.html");
				
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

