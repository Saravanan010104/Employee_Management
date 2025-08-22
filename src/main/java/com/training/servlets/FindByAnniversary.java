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
 * Servlet implementation class FindByAnniversary
 */
@WebServlet("/findbyanniversary")
public class FindByAnniversary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDaoImpl dao;   
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public FindByAnniversary() throws SQLException {
        super();
        this.dao = new EmployeeDaoImpl(MySqlConnection.getMySqlConnection());
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub/
		String dateStr = request.getParameter("weddingDate");
		
		try {
			LocalDate wedDate = LocalDate.parse(dateStr);
			Map<String, Long> anniversaryMap = dao.findAnniversaryEmployees(wedDate);
	        request.setAttribute("map", anniversaryMap);
	        request.setAttribute("title", "Anniversary Details");

	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    RequestDispatcher dispatcher = request.getRequestDispatcher("homeforanniversarysearch.jsp");
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
