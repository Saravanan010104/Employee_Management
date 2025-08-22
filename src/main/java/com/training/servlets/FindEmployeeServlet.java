package com.training.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.training.daoimpl.EmployeeDaoImpl;
import com.example.demo.entity.Employee;
import com.example.utils.MySqlConnection;


/**
 * Servlet implementation class FindEmployeeServlet
 */
@WebServlet("/findEmployee")
public class FindEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDaoImpl dao;  
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public FindEmployeeServlet() throws SQLException {
        super();
        this.dao = new EmployeeDaoImpl(MySqlConnection.getMySqlConnection());
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstName = request.getParameter("firstName");

		try {
			List<Employee> employees = dao.findByFirstName(firstName);
			request.setAttribute("list", employees);
			request.setAttribute("title", "Employee Details");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
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
