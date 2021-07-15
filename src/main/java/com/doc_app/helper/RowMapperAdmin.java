package com.doc_app.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doc_app.bean.Admin;



public class RowMapperAdmin implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet resultset, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setAdminId(resultset.getInt("AdminID"));
		admin.setAdminName(resultset.getString("AdminName"));
		admin.setContactNumber(resultset.getString("ContactNumber"));
		admin.setEmail(resultset.getString("Email"));
		admin.setPassword(resultset.getString("Password"));
		return admin;
	}

}
