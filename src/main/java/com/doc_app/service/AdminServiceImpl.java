package com.doc_app.service;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc_app.bean.*;
import com.doc_app.persistence.*;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao admindao;

	public void setAdminDao(AdminDao admindao) {
		this.admindao = admindao;
	}
	
	
	
	@Autowired
	private AppointmentDao appointmentdao;

	public void setAppointmentdao(AppointmentDao appointmentdao) {
		this.appointmentdao = appointmentdao;
	}
	
	@Autowired
	private AvailabilityDao availabilitydao;

	
   
    
    public boolean adminLogin(int aID, String aPassword) throws Exception{
		Admin admin=admindao.getRecordByaID(aID);
		if((admin.getPassword()).equals(aPassword)) {
				return true;
		}
		else
			return false;
	}
    
    public ArrayList<Availability> adminavailabilities() throws ClassNotFoundException, SQLException, IOException{
        	ArrayList<Availability>availabilities=availabilitydao.viewAvailability();
        	return availabilities;
    }
    public ArrayList<Appointment> adminappointments() throws ClassNotFoundException, SQLException, IOException{
    	
    	ArrayList<Appointment>appointments=appointmentdao.viewallAppointments();

		return appointments;
    }
    
    
    public ArrayList<Appointment> view_appointments(int did) throws Exception{

		ArrayList<Appointment>appointments=new ArrayList<>();
		appointments=appointmentdao.viewAppointmentbydid(did);
		return appointments;

    }

    
    public boolean cancel_appointments(int aid) throws Exception{
			boolean check=appointmentdao.cancel_appointment(aid);
			if (check==true) {
				return true;
			}
			else {
				return false;
			}
	
	}
    
    public boolean modify_appointments(int aid,int did) throws Exception{
		System.out.println("Enter the doctor Id:");
			boolean check=appointmentdao.modify_appointment(aid,did);
			if (check==true) {
				return true;
			}
			else {
				return false;
			}
	
		}
    
    public ArrayList<Availability> availbydoc(int did) throws Exception {
    	ArrayList<Availability>availbydid= availabilitydao.viewAvailabilitybydid(did);
    	return availbydid;
    	
    }




	
    
    

    
//	public static void select_option(int did, int case_opt)throws Exception{
//		switch(case_opt) {
//		
//		case 1:view_appointments(did);break;
//		case 2:cancel_appointments(did);break;
//		case 3:modify_appointments(did);break;
//		default: System.out.println("**Successfully logged out..\n"); 
//		}
//	}



    
}
