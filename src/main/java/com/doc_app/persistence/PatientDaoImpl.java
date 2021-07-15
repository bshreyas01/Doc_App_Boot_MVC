package com.doc_app.persistence;
import java.io.IOException;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doc_app.bean.*;
import com.doc_app.helper.RowMapperPatient;

@Repository
public class PatientDaoImpl implements PatientDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public boolean signuppatient(Patient p1) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException {
		int rows=jdbcTemplate.update("INSERT INTO PatientTable(PatientName, PatientGender, PatientAge, PatientMobile, PatientEmail, PatientPassword) VALUES(?,?,?,?,?,?)",
		p1.getpName(),
		p1.getpGender(),
		p1.getpAge(),
		p1.getpMobile(),
		p1.getpEmail(),
		p1.getpPassword());
		if (rows > 0)
			return true;
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public Patient getpatRecordByID(String email)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		

		Patient pat = new Patient();
		Object ob[]= {email};
		pat=jdbcTemplate.queryForObject("select * from PatientTable where PatientEmail=(?)",ob,new RowMapperPatient());
		return pat;
	}

}