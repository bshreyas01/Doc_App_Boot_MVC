package com.doc_app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.ArrayList;
//import java.util.Collection;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.doc_app.*;
//import com.doc_app.service.*;
import org.springframework.web.servlet.ModelAndView;

import com.doc_app.service.AdminService;
import com.doc_app.service.DoctorService;
import com.doc_app.service.PatientService;


@Controller
public class DocAppController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	
	
//	@RequestMapping("/")
//	public ModelAndView openingPageController() {
//		return new ModelAndView("index");
//	}
	
	@RequestMapping("/")
	public String openingPageController() {
		return "index";
	}
	
	
	@RequestMapping("/doctor")
	public String doctordashboard() {
		return "doctorDashboard";
	}
	
	@RequestMapping("/doctorsSignin")
	public String doctorsSignin() {
		return "doctorsSignin";
	}

	@RequestMapping("/loginCheck")
	public ModelAndView checkLoginController(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		String dID=request.getParameter("did");
		String dPassword=request.getParameter("pwd");
		String message=null;
		try {
			if((doctorService.doctorLogin(Integer.parseInt(dID),dPassword))!=-1)
				{mv.setViewName("doctorsSignedin");
				return mv;}
			else
				message="Login Failed !";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.addObject("msg", message);
		mv.setViewName("output");
		
		return mv;
	}
	/*
	@RequestMapping("/inputForEmpSearch")
	public String getEmpIDForSearchPage() {
		return "inputEmpIdForSearch";
	}
	
	@RequestMapping("/getpayslipinp")
	public String getEmpIDPayslip() {
		return "inputgetpayslip";
	}
	
	@RequestMapping("/searchEmp")
	public ModelAndView searchEmpController(@RequestParam("empId") String id) {
		Employee employee=null;
		try {
			employee=employeeService.findEmployee(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(employee!=null) {
			return new ModelAndView("displayEmployee", "employee", employee);
		}
		return new ModelAndView("output", "message", "Employee with id "+id+" doesnot exist");
	}
	
	@RequestMapping("/payslip")
	public ModelAndView getpayslip(@RequestParam("empId") String id) {
		EmployeePaySlip employeePaySlip=null;
		try {
			employeePaySlip=employeeService.getPaySlip(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(employeePaySlip!=null) {
			return new ModelAndView("displaypayslip", "employeePaySlip", employeePaySlip);
		}
		return new ModelAndView("output", "message", "Employee with id "+id+" doesnot exist");
	}

	@RequestMapping("/insertEmployeePage")
	public ModelAndView insertEmpPageController() {
		return new ModelAndView("inputEmpDetails", "emp", new Employee());
	}
	
	@RequestMapping("/insertEmp")
	public ModelAndView insertEmployeeController(@ModelAttribute("emp") Employee emp ) {
		try {
			if(employeeService.saveEmployee(emp))
				return new ModelAndView("output", "message", "Employee Saved Successfully!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new ModelAndView("output", "message", "Saving Employee Failed!");
	
	}
	
	@RequestMapping("/deleteEmployeePage")
	public String deleteEmployeePageController() {
		return "inputEmpForDelete";
	}
	
	@RequestMapping("/deleteEmp")
	public ModelAndView deleteEmployeeController(@RequestParam("empId") String id) {
		try {
			if(employeeService.removeEmployee(Integer.parseInt(id))) {
				return new ModelAndView("output","message","Employee with ID "+id+" deleted Successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("output","message","Employee with ID "+id+" deletion Failed!");
		
	}
	
	@RequestMapping("/getAllEmps")
	public ModelAndView getAllEmployeesController() {
		Collection<Employee> employees=null;
		try {
			employees=employeeService.getAllEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("displayAllEmployeesWithoutScriplets", "employees", employees);
	}*/
}
