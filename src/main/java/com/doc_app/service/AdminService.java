package com.doc_app.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.doc_app.bean.Appointment;
import com.doc_app.bean.Availability;

public interface AdminService {
	boolean adminLogin(int aID, String aPassword) throws Exception;
	ArrayList<Availability> adminavailabilities() throws ClassNotFoundException, SQLException, IOException;
	ArrayList<Appointment> adminappointments() throws ClassNotFoundException, SQLException, IOException;
	ArrayList<Appointment> view_appointments(int did) throws Exception;
	boolean cancel_appointments(int aid) throws Exception;
	boolean modify_appointments(int aid,int did) throws Exception;
	ArrayList<Availability> availbydoc(int did) throws Exception;
}
