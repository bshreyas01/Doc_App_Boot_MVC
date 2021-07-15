package com.doc_app.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.doc_app.bean.Appointment;

public interface AppointmentDao  {

	ArrayList<Appointment> viewAppointmentbydid(int DoctorId)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	boolean cancel_appointment(int aID) 
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	ArrayList<Appointment> viewAppointmentbypid(int patientID)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	boolean add_appointment(Appointment a1) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
	ArrayList<Appointment> viewallAppointments()
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	boolean modify_appointment(int appointmentId,int docid) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
}
