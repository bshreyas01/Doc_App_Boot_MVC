package com.doc_app.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doc_app.bean.Availability;



public class RowMapperAvailability implements RowMapper<Availability> {

	@Override
	public Availability mapRow(ResultSet r1, int rowNum) throws SQLException {
		Availability availability=new Availability();
		availability.setDoctorId(r1.getInt("DoctorId"));
		availability.setDoctorDate(r1.getString("DoctorDate"));
		availability.setInTime(r1.getString("InTime"));
		availability.setOutTime(r1.getString("OutTime"));
		return availability;
	}

}
