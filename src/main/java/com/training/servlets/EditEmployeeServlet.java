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
import java.util.List;

import com.training.daoimpl.EmployeeDaoImpl;

import com.example.demo.entity.Employee;
import com.example.utils.MySqlConnection;
import com.training.ifaces.Dao;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao<Employee> dao;   
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() throws SQLException {
        super();
        this.dao = new EmployeeDaoImpl(MySqlConnection.getMySqlConnection());
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Employee emp = dao.findById(id);
			request.setAttribute("emp", emp); 
//			if(emp!=null) {
//				request.setAttribute("emp", emp); 
//			}
//			else {
//				request.setAttribute(); 
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		dispatcher.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String houseNumber = request.getParameter("houseNumber");
		String streetName = request.getParameter("streetName");
		String area = request.getParameter("area");
		String city = request.getParameter("city");
		int pinCode = Integer.parseInt(request.getParameter("pinCode"));
		String emailAddress = request.getParameter("emailAddress");
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
		LocalDate weddingDate = LocalDate.parse(request.getParameter("weddingDate"));

		try {
			Employee edited = dao.update(new Employee(employeeId, firstName, lastName, houseNumber, streetName, area, city,
					pinCode, emailAddress, phoneNumber, dateOfBirth, weddingDate));
			request.setAttribute("list", List.of(edited));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("result", "One Employee edited");

		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
//		doGet(request, response);
	}

}
