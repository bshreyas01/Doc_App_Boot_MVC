package com.doc_app.persistence;

import java.io.IOException;
import java.sql.SQLException;

import com.doc_app.bean.Patient;

public interface PatientDao  {

	boolean signuppatient(Patient p1) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
	Patient getpatRecordByID(String email)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	
}
