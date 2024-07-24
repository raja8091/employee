package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployee() {
		return employeeDAO.getEmployee();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeeDAO.saveCustomer(theEmployee);
		
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		return employeeDAO.getEmployee(theId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		employeeDAO.deleteEmployee(theId);
		
	}

}
