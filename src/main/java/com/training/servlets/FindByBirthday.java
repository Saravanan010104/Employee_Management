package com.training.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

import com.example.utils.MySqlConnection;
import com.training.daoimpl.EmployeeDaoImpl;

/**
 * Servlet implementation class FindByBirthday
 */
@WebServlet("/findByBirthday")
public class FindByBirthday extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDaoImpl dao;   
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public FindByBirthday() throws SQLException {
        super();
        this.dao = new EmployeeDaoImpl(MySqlConnection.getMySqlConnection());
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dobStr = request.getParameter("dateOfBirth");
		try {
		    LocalDate dob = LocalDate.parse(dobStr);
		    Map<String, String> birthdayMap = dao.findBirthdayEmployees(dob);
		    request.setAttribute("map", birthdayMap);
		    request.setAttribute("title", "Employees Birthday");
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("homeforbirthdaysearch.jsp");
		dispatcher.forward(request, response);

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
