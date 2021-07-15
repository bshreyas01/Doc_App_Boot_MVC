package com.doc_app.persistence;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doc_app.bean.*;
import com.doc_app.helper.RowMapperAvailability;

@Repository
public class AvailabilityDaoImpl implements AvailabilityDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	public boolean setavailability(Availability availability) throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		int r1=jdbcTemplate.update("INSERT into AvailabilityTable values(?,?,?,?)",
		java.sql.Date.valueOf(availability.getDoctorDate())
		,java.sql.Time.valueOf(availability.getInTime())
		,java.sql.Time.valueOf(availability.getOutTime())
		,availability.getDoctorId());

		if(r1>0) {
			return true;
		}
		else
			return false;
		
	}
	
	public ArrayList<Availability> viewAvailabilitybydid(int DoctorId)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		
		ArrayList<Availability>availabilities=new ArrayList<>();
		availabilities=(ArrayList<Availability>) jdbcTemplate.query("select * from AvailabilityTable where DoctorId = " + DoctorId +  " order by DoctorDate, InTime",new RowMapperAvailability());
		
		return availabilities;
	}
	
	public ArrayList<Availability> viewAvailability()
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		
		ArrayList<Availability>availabilities=new ArrayList<>();
		availabilities=(ArrayList<Availability>) jdbcTemplate.query("select * from AvailabilityTable order by DoctorDate, InTime",new RowMapperAvailability());

		return availabilities;
	}
}
