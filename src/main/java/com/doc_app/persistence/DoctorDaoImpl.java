package com.doc_app.persistence;
import java.io.IOException;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doc_app.bean.*;
import com.doc_app.helper.RowMapperDoctor;

@Repository
public class DoctorDaoImpl implements DoctorDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean signupdoctor(Doctor d1) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException {
		int rows = jdbcTemplate.update("INSERT into DoctorTable values(?,?,?,?,?,?,?)",
		d1.getDid(),
		d1.getdName(),
		d1.getdGender(),
		d1.getdAge(),
		d1.getdMobile(),
		d1.getdEmail(),
		d1.getdPassword());

		if (rows > 0)
			return true;
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public Doctor getRecordBydID(int id)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
				
		Doctor doc = new Doctor();
		Object ob[]= {id};
		doc=jdbcTemplate.queryForObject("select * from DoctorTable where DoctorId=(?)", ob,new RowMapperDoctor());

		return doc;
	}

}