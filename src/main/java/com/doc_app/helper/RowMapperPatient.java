package com.doc_app.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doc_app.bean.Patient;



public class RowMapperPatient implements RowMapper<Patient> {

	@Override
	public Patient mapRow(ResultSet resultset, int rowNum) throws SQLException {
		Patient pat = new Patient();
		pat.setpName(resultset.getString("PatientName"));
		pat.setPid(resultset.getInt("PatientID"));
		pat.setpGender(resultset.getString("PatientGender"));
		pat.setpAge(resultset.getInt("PatientAge"));
		pat.setpMobile(resultset.getString("PatientMobile"));
		pat.setpEmail(resultset.getString("PatientEmail"));
		pat.setpPassword(resultset.	getString("PatientPassword"));
		
		return pat;
	}

}
