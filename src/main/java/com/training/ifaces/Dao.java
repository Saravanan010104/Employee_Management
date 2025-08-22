package com.training.ifaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	
	boolean add(T t) throws SQLException;

	T update(T t) throws SQLException;

	boolean delete(T t) throws SQLException;

	T findById(int key) throws SQLException;

	List<T> findAll() throws SQLException;
}
