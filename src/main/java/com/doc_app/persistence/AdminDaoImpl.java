package com.doc_app.persistence;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doc_app.bean.*;
import com.doc_app.helper.RowMapperAdmin;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@SuppressWarnings("deprecation")
	public Admin getRecordByaID(int id)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		Admin admin = new Admin();
		Object ob[]= {id};
		admin=jdbcTemplate.queryForObject("select * from admintable where AdminID=(?)", ob,new RowMapperAdmin());
		return admin;
	}

}
