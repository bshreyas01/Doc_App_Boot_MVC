package com.doc_app.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc_app.bean.Appointment;

import com.doc_app.bean.Patient;
import com.doc_app.persistence.AppointmentDao;
import com.doc_app.persistence.PatientDao;

@Service
public class PatientServiceImpl implements PatientService {
	

	
	@Autowired
	private PatientDao patientdao;

	public void setPatientdao(PatientDao patientdao) {
		this.patientdao = patientdao;
	}
	
	@Autowired
	private AppointmentDao appointmentdao;

	public void setAppointmentdao(AppointmentDao appointmentdao) {
		this.appointmentdao = appointmentdao;
	}
	


	static Scanner sc=new Scanner(System.in);

    public boolean patientRegister(Patient patient) throws Exception {
		boolean check=patientdao.signuppatient(patient);
		if(check==true) {
			return false;}
		else {
			return true;
		}
	}
    
    
    public int patientLogin(String pEmail,String pPassword) throws Exception{

		Patient patient=patientdao.getpatRecordByID(pEmail);

		if((patient.getpPassword()).equals(pPassword)) {
			return patient.getPid();
		}
		else {
			return -1;
		}
	}
      
    
    public ArrayList<Appointment> view_appointments(int pid) throws Exception{

		ArrayList<Appointment>appointments=new ArrayList<>();
		appointments=appointmentdao.viewAppointmentbypid(pid);
		return appointments;

    }
    
    public boolean add_appointment(Appointment appointment)throws Exception{

		
		boolean check=appointmentdao.add_appointment(appointment);
		if(check==true) {
			return true;}
		else {
			return false;
		}
    }
    
    public boolean cancel_appointments(int pid,int aid) throws Exception{
		ArrayList<Appointment>appointments=new ArrayList<>();
		ArrayList<Integer>aplist=new ArrayList<>();
		appointments=appointmentdao.viewAppointmentbypid(pid);
		for(Appointment appointment:appointments) {
			aplist.add(appointment.getaID());
		}

		if (aplist.contains(aid)) {
			boolean check=appointmentdao.cancel_appointment(aid);
			if (check) {
				return true;			}
			else {return false;			}
		}
		else {return false;		}
	}
    

}
