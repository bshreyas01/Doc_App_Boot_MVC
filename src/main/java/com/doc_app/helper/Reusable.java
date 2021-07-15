package com.doc_app.helper;

import java.util.ArrayList;

import com.doc_app.bean.Appointment;
import com.doc_app.bean.Availability;
import com.doc_app.persistence.AppointmentDaoImpl;
import com.doc_app.persistence.AvailabilityDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Reusable {
	static Scanner sc=new Scanner(System.in);
    public static void view_all_appointments() throws Exception{
		System.out.println("The appointments are:");
		System.out.println("\n+--------------+----------+---------+----------+---------+");
		System.out.println("|Appointment_Id|Doctor_Id|Patient_Id|Date      |Time     |");
		System.out.println("+--------------+----------+---------+----------+---------+");
		AppointmentDaoImpl appointmentdao=new AppointmentDaoImpl();
		ArrayList<Appointment>appointments=new ArrayList<>();
		appointments=appointmentdao.viewallAppointments();
		for(Appointment appointment:appointments) {
			System.out.println("|"+appointment.getaID()+"             |"+appointment.getDoctorId()+ "         |"+appointment.getPatientID()+ "      |"+appointment.getaDate()+"|"+appointment.getaTime()+" |");
			System.out.println("+--------------+----------+---------+----------+---------+\n");
		}
    }
    
public static void viewallavailabilities() throws ClassNotFoundException, SQLException, IOException {
	AvailabilityDaoImpl availabilitydao=new AvailabilityDaoImpl();
	ArrayList<Availability>availabilities=availabilitydao.viewAvailability();
	System.out.println("\n+---------+-----------+---------+--------+");
	System.out.println("|Doctor id"+"|"+"Date"+ "       |"+"In Time"+ "  |"+"Out Time|");
	System.out.println("+---------+-----------+---------+--------+");
	for(Availability availability:availabilities) {
	
		System.out.println("|"+availability.getDoctorId()+"      |"+availability.getDoctorDate()+ " |"+availability.getInTime()+ " |"+availability.getOutTime()+"|");
		System.out.println("+---------+-----------+---------+--------+\n");
	}
	
}
    
    public static void set_availability(int did) throws Exception{
    	
		System.out.println("\nEnter the Availability_Date(YYYY-MM-DD) and inTime(HH:MM:SS) and OutTime:");
//		String dname = doccname;
		String date=sc.next();
		String iT=sc.next();
		String oT=sc.next();
		AvailabilityDaoImpl availabilitydao=new AvailabilityDaoImpl();
//		Availability availability=new Availability(date, iT, oT, did);
		Availability availability=new Availability();
		availability.setDoctorDate(date);
		availability.setDoctorId(did);
		availability.setInTime(iT);
		availability.setOutTime(oT);
		boolean check=availabilitydao.setavailability(availability);
		if(check==true)
			System.out.println("--> Successfully added your availability. <--\n");
		else {
			System.out.println("Could not add!");
		}
    }
}
