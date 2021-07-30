package com.model.amit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.amit.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute a query and get the result
		List<Customer> customer = theQuery.getResultList();

		// get the result
		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer data
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, theId);

		currentSession.delete(theCustomer);
	}

}
