package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployee() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Employee> theQuery = currentSession.createQuery("from Employee order by lastName", Employee.class);

		// execute query and get result list
		List<Employee> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Employee theEmployee) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	public Employee getEmployee(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Employee theEmployee = currentSession.get(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery("delete from Employee where id=:employeeId");
				theQuery.setParameter("customerId", theId);
				
				theQuery.executeUpdate();	
		
	}

}
