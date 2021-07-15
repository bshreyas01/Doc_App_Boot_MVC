package com.doc_app.persistence;

import java.io.IOException;
import java.sql.SQLException;

import com.doc_app.bean.Doctor;

public interface DoctorDao  {

	boolean signupdoctor(Doctor d1) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
	Doctor getRecordBydID(int id)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	
}
