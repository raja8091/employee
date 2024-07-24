package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	// need to inject our customer service
		@Autowired
		private EmployeeService employeeService;
		
		@GetMapping("/list")
		public String listEmployee(Model theModel) {
			
			// get customers from the service
			List<Employee> theEmployee = employeeService.getEmployee();
					
			// add the customers to the model
			theModel.addAttribute("employee", theEmployee);
			
			return "list-employee";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			Employee theEmployee = new Employee();
			
			theModel.addAttribute("customer", theEmployee);
			
			return "employee-form";
		}
		
		@PostMapping("/saveCustomer")
		public String saveCustomer(@ModelAttribute("customer") Employee theEmployee) {
			
			// save the customer using our service
			employeeService.saveEmployee(theEmployee);	
			
			return "redirect:/customer/list";
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("customerId") int theId,
										Model theModel) {
			
			// get the customer from our service
			Employee theEmployee = employeeService.getEmployee(theId);	
			
			// set customer as a model attribute to pre-populate the form
			theModel.addAttribute("employee", theEmployee);
			
			// send over to our form		
			return "employee-form";
		}
		
		@GetMapping("/delete")
		public String deleteEmployee(@RequestParam("employeeid") int theId) {
			
			// delete the customer
			employeeService.deleteEmployee(theId);
			
			return "redirect:/employee/list";
		}

}
