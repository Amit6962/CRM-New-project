package com.model.amit.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// set up db connection
		String user = "springstudent";
		String pass = "springstudent";
		String jdbc = "jdbc:mysql://localhost:3306/web_customer_tracker";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//get the connection
		
		try {
			PrintWriter out=response.getWriter();
			out.println("Connecting to db: "+jdbc);
			
		    Class.forName(driver);
			
			Connection con=DriverManager.getConnection(jdbc,user,pass);
			
			out.println("Success in connecting to db");
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
