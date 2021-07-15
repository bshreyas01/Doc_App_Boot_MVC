package com.doc_app.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doc_app.bean.Appointment;



public class RowMapperAppointment implements RowMapper<Appointment> {

	@Override
	public Appointment mapRow(ResultSet r1, int rowNum) throws SQLException {
		Appointment appointment=new Appointment();
		appointment.setaID(r1.getInt("aID"));
		appointment.setaDate(r1.getString("aDate"));
		appointment.setaTime(r1.getString("aTime"));
		appointment.setDoctorId(r1.getInt("DoctorId"));
		appointment.setPatientID(r1.getInt("PatientID"));		
		return appointment;
	}

}
