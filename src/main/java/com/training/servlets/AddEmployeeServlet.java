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

import com.training.daoimpl.EmployeeDaoImpl;
import com.example.demo.entity.Employee;
import com.example.utils.MySqlConnection;
import com.training.ifaces.Dao;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/addEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao<Employee> dao;   
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() throws SQLException {
        super();
        this.dao = new EmployeeDaoImpl(MySqlConnection.getMySqlConnection());
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
        
        Employee emp = new Employee(employeeId, firstName, lastName, houseNumber, streetName,
                area, city, pinCode, emailAddress, phoneNumber, dateOfBirth, weddingDate);
        
       
		try {
			boolean result;
			result = dao.add(emp);
			if(result) {
				request.setAttribute("result","Employee Added Successfully");
			}
			else {
				request.setAttribute("result","Employee not Added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
//		doGet(request, response);
	}

}
