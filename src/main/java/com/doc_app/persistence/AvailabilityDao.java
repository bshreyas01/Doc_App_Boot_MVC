package com.doc_app.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.doc_app.bean.Availability;

public interface AvailabilityDao  {

	boolean setavailability(Availability availability) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
	ArrayList<Availability> viewAvailabilitybydid(int DoctorId)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	ArrayList<Availability> viewAvailability()
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	
	
}
