package com.doc_app.service;

import java.util.ArrayList;

import com.doc_app.bean.Appointment;
import com.doc_app.bean.Availability;
import com.doc_app.bean.Doctor;

public interface DoctorService {
	
	boolean doctorRegister(Doctor d1) throws Exception;
	int doctorLogin(int dID, String dPassword) throws Exception;
	ArrayList<Appointment> view_appointments(int did) throws Exception;
	boolean set_availability(Availability availability) throws Exception;
	boolean cancel_appointments(int did,int aid) throws Exception;
	
	
	
}
