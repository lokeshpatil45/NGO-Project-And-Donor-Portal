package com.r3sys.NGO_DONOR_Projects;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.Connection.ConnectionDb;

/**
 * Servlet implementation class DonorChangePassword
 */
public class DonorChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorChangePassword() {
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
		
		

		 try {
	            String email = request.getParameter("email");
	            String currentpass = request.getParameter("currentpass");
	            String newpass = request.getParameter("newpass");
	            String confirmpass = request.getParameter("confirmpass");

	            if (!newpass.equals(confirmpass)) {
	                System.out.println("New Password and Confirm Password do not match");
	                response.sendRedirect("D7_DonorChangePassword.html");
	                return;
	            }
	            Connection cn = ConnectionDb.getConnect();
	            PreparedStatement ps = cn.prepareStatement("select * from donor where email=?");
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                String oldpass = rs.getString("password");
	                if (!oldpass.equals(currentpass)) {
	                    System.out.println("Current password is incorrect");
	                    response.sendRedirect("d6_DonorChangePassword.html");
	                } 
	                else 
	                {
	     
	                    PreparedStatement ps1 = cn.prepareStatement("update donor set password=? where email=?");	
	                    ps1.setString(1, newpass);
	                    ps1.setString(2, email);

	                    int i = ps1.executeUpdate();

	                    if (i > 0) {
	                        response.sendRedirect("d2_DonarLogin.html");
	                    } else {
	                        response.sendRedirect("error.html");
	                    }
	                }
	            }
	            else 
	            {
	                System.out.println("Email not found");
	                response.sendRedirect("error.html");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("error.html");
	        }
	}

}
