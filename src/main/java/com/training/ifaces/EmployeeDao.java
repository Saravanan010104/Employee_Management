package com.training.ifaces;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmployeeDao<T> extends Dao<T> {

	List<T> findByFirstName(String name) throws SQLException;

	Map<String, Long> getFirstNameAndPhoneNumber() throws SQLException;

	boolean deleteByFirstName(String name) throws SQLException;

	Map<String, String> findBirthdayEmployees(LocalDate date) throws SQLException;

	Map<String, Long> findAnniversaryEmployees(LocalDate date) throws SQLException;

	boolean updateEmailAndPhone(int id, String email, long phone) throws SQLException;
	
}
