package com.doc_app.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doc_app.bean.Doctor;



public class RowMapperDoctor implements RowMapper<Doctor> {

	@Override
	public Doctor mapRow(ResultSet resultset, int rowNum) throws SQLException {
		Doctor doc = new Doctor();

		doc.setDid(resultset.getInt("DoctorId"));
		doc.setdName(resultset.getString("DoctorName"));
		doc.setdGender(resultset.getString("DoctorGender"));
		doc.setdAge(resultset.getInt("DoctorAge"));
		doc.setdMobile(resultset.getString("DoctorMobile"));
		doc.setdEmail(resultset.getString("DoctorEmail"));
		doc.setdPassword(resultset.getString("DoctorPassword"));
		
		return doc;
	}

}
