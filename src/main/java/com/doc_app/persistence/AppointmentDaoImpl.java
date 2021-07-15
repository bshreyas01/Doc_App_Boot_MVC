package com.doc_app.persistence;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doc_app.bean.*;
import com.doc_app.helper.RowMapperAppointment;


@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@SuppressWarnings("deprecation")
	public ArrayList<Appointment> viewAppointmentbydid(int DoctorId)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		
		ArrayList<Appointment>appointments=new ArrayList<>();

		Object ob[]= {DoctorId};
		appointments=(ArrayList<Appointment>) jdbcTemplate.query("Select * from AppointmentTable WHERE DoctorId=?",ob,new RowMapperAppointment());
		return appointments;
	}
	
	public boolean cancel_appointment(int aID) 
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		int i=jdbcTemplate.update("Delete from AppointmentTable where aid=?",aID);
		if(i>0) {
			return true;
		}
		else return false;
	}
	
	@SuppressWarnings("deprecation")
	public ArrayList<Appointment> viewAppointmentbypid(int patientID)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		
		ArrayList<Appointment>appointments=new ArrayList<>();

		Object ob[]= {patientID};
		appointments=(ArrayList<Appointment>) jdbcTemplate.query("Select * from AppointmentTable WHERE patientID=?",ob,new RowMapperAppointment());

		return appointments;
	}
	
	public boolean add_appointment(Appointment a1) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException {
		int rows=jdbcTemplate.update("INSERT INTO AppointmentTable(PatientId, DoctorId, aDate, aTime) VALUES(?,?,?,?)",
		a1.getPatientID()
		, a1.getDoctorId()
		,java.sql.Date.valueOf(a1.getaDate())
		, java.sql.Time.valueOf(a1.getaTime()));
		
		if (rows > 0)
			return true;
		return false;
	}
	
	public ArrayList<Appointment> viewallAppointments()
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		
		ArrayList<Appointment>appointments=new ArrayList<>();

		appointments=(ArrayList<Appointment>) jdbcTemplate.query("Select * from AppointmentTable order by aDate, aTime",new RowMapperAppointment());

		return appointments;
	}
	
	public boolean modify_appointment(int appointmentId,int docid) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException {
		int rows=jdbcTemplate.update("UPDATE AppointmentTable SET DoctorId=? where aId=?",
    	docid, appointmentId);
		if (rows > 0)
			return true;
		return false;
	}
	
	

}


