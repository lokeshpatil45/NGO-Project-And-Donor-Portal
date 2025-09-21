package com.r3sys.NGO_DONOR_Projects;

import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.Connection.ConnectionDb;

import Getter_Setter.Ngo;

/**
 * Servlet implementation class NgoRegister
 */
public class NgoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NgoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		try {

			int nid =0;
			String name = request.getParameter("name");
			String focusArea = request.getParameter("focusArea");
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Connection cn = ConnectionDb.getConnect();
			PreparedStatement ps1 = cn.prepareStatement("select * from ngo where email=? and password=?");
			ps1.setString(1, email);
			ps1.setString(2, password);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
			
				System.out.println("Account IS already exits.....!!!");
				response.sendRedirect("n2_NgoLogin.html");
			} else {

				PreparedStatement ps = cn.prepareStatement("insert into ngo values(?,?,?,?,?,?,?)");
				ps.setInt(1, nid);
				ps.setString(2, name);
				ps.setString(3, focusArea);
				ps.setString(4, contact);
				ps.setString(5, email);
				ps.setString(6, password);

				int i = ps.executeUpdate();
				if (i > 0) {
					response.sendRedirect("n2_NgoLogin.html");

				} else {

					response.sendRedirect("error.html");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
