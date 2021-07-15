package com.doc_app.service;

import java.util.ArrayList;

import com.doc_app.bean.Appointment;
import com.doc_app.bean.Patient;

public interface PatientService {

	boolean patientRegister(Patient patient) throws Exception;
	int patientLogin(String pEmail,String pPassword) throws Exception;
	ArrayList<Appointment> view_appointments(int pid) throws Exception;
	boolean add_appointment(Appointment appointment)throws Exception;
	boolean cancel_appointments(int pid,int aid) throws Exception;
	
	
}
