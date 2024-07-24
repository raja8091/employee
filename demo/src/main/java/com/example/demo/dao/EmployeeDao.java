package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployee();

	public void saveCustomer(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

}
