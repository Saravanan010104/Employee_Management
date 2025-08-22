package com.training.daoimpl;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Employee;
import com.training.ifaces.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao<Employee> {

	private Connection conn;

	public EmployeeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	String INSERT = "insert into employee_detail (employee_id, first_name, last_name, house_number, street, area, city, pin_code, email_address, phone_number, date_of_birth, wedding_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String FINDANNIVERSARY = "select first_name, phone_number from employee_detail where wedding_date = ?";
	String FINDALL = "select * from employee_detail";
	String FINDBYID = "select * from employee_detail where employee_id = ?";
	String DELETE = "delete from employee_detail where employee_id = ?";
	String UPDATE = "update employee_detail SET first_name=?, last_name=?, house_number=?, street=?, area=?, city=?, pin_code=?, email_address=?, phone_number=?, date_of_birth=?, wedding_date=? where employee_id = ?";
	String FINDBYFIRSTNAME = "select * from employee_detail where first_name = ?";
	String NAMEANDPHONENUMBER = "select first_name, phone_number from employee_detail";
	String DELETEBYNAME = "delete from employee_detail where first_name = ?";
	String FINDBYBIRTHDAY = "select first_name, email_address from employee_detail where date_of_birth = ?";
	String UPDATEEMAILANDPHONE = "update employee_detail SET email_address = ?, phone_number = ? where employee_id = ?";

	@Override
	public boolean add(Employee emp) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(INSERT);
		pstmt.setInt(1, emp.getEmployeeId());
		pstmt.setString(2, emp.getFirstName());
		pstmt.setString(3, emp.getLastName());
		pstmt.setString(4, emp.getHouseNumber());
		pstmt.setString(5, emp.getStreetName());
		pstmt.setString(6, emp.getArea());
		pstmt.setString(7, emp.getCity());
		pstmt.setInt(8, emp.getPinCode());
		pstmt.setString(9, emp.getEmailAddress());
		pstmt.setLong(10, emp.getPhoneNumber());
		pstmt.setDate(11, Date.valueOf(emp.getDateOfBirth()));
		pstmt.setDate(12, Date.valueOf(emp.getWeddingDate()));
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public Employee findById(int id) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(FINDBYID);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return mapper(rs);
		} else {
			return null;
		}

	}

	@Override
	public List<Employee> findAll() throws SQLException {
		List<Employee> list = new ArrayList<>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(FINDALL);
		while (rs.next()) {
			list.add(mapper(rs));
		}
		return list;
	}

	@Override
	public boolean delete(Employee emp) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(DELETE);
		pstmt.setInt(1, emp.getEmployeeId());
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public Employee update(Employee emp) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(UPDATE);
		pstmt.setString(1, emp.getFirstName());
		pstmt.setString(2, emp.getLastName());
		pstmt.setString(3, emp.getHouseNumber());
		pstmt.setString(4, emp.getStreetName());
		pstmt.setString(5, emp.getArea());
		pstmt.setString(6, emp.getCity());
		pstmt.setInt(7, emp.getPinCode());
		pstmt.setString(8, emp.getEmailAddress());
		pstmt.setLong(9, emp.getPhoneNumber());
		pstmt.setDate(10, Date.valueOf(emp.getDateOfBirth()));
		pstmt.setDate(11, Date.valueOf(emp.getWeddingDate()));
		pstmt.setInt(12, emp.getEmployeeId());
		int rows = pstmt.executeUpdate();
		if (rows == 1) {
			return findById(emp.getEmployeeId());
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> findByFirstName(String name) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(FINDBYFIRSTNAME);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		List<Employee> list = new ArrayList<>();
		while (rs.next()) {
			list.add(mapper(rs));
		}
		return list;
	}

//    Get the List of employees with FirstName and Phone Number
//    Map<>
	@Override
	public Map<String, Long> getFirstNameAndPhoneNumber() throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(NAMEANDPHONENUMBER);
		ResultSet rs = pstmt.executeQuery();

		Map<String, Long> nameAndPhonenumber = new HashMap<>();

		while (rs.next()) {
			String firstName = rs.getString("first_name");
			Long phoneNumber = rs.getLong("phone_number");
			nameAndPhonenumber.put(firstName, phoneNumber);
		}

		return nameAndPhonenumber;
	}

	@Override
	public boolean updateEmailAndPhone(int id, String email, long phone) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(UPDATEEMAILANDPHONE);
		pstmt.setString(1, email);
		pstmt.setLong(2, phone);
		pstmt.setInt(3, id);
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean deleteByFirstName(String name) throws SQLException {

		PreparedStatement pstmt = conn.prepareStatement(DELETEBYNAME);
		pstmt.setString(1, name);
		return pstmt.executeUpdate() >= 1;
	}

	@Override
	public Map<String, String> findBirthdayEmployees(LocalDate date) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(FINDBYBIRTHDAY);
		pstmt.setDate(1, Date.valueOf(date));
		ResultSet rs = pstmt.executeQuery();

		Map<String, String> birthdayMap = new HashMap<>();
		while (rs.next()) {
			String firstName = rs.getString("first_name");
			String email = rs.getString("email_address");
			birthdayMap.put(firstName, email);
		}

		return birthdayMap;
	}

	@Override
	public Map<String, Long> findAnniversaryEmployees(LocalDate date) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(FINDANNIVERSARY);
		pstmt.setDate(1, Date.valueOf(date));
		ResultSet rs = pstmt.executeQuery();

		Map<String, Long> map = new HashMap<>();
		while (rs.next()) {
			String name = rs.getString("first_name");
			Long phone = rs.getLong("phone_number");
			map.put(name, phone);
		}
		return map;
	}

	private Employee mapper(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getInt("employee_id"));
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setHouseNumber(rs.getString("house_number"));
		emp.setStreetName(rs.getString("street"));
		emp.setArea(rs.getString("area"));
		emp.setCity(rs.getString("city"));
		emp.setPinCode(rs.getInt("pin_code"));
		emp.setEmailAddress(rs.getString("email_address"));
		emp.setPhoneNumber(rs.getLong("phone_number"));
		emp.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
		emp.setWeddingDate(rs.getDate("wedding_date").toLocalDate());
		return emp;
	}

}
