package spring.laundry.dhobighaat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import spring.laundry.dhobighaat.daos.ICustomerDAO;
import spring.laundry.dhobighaat.pojos.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDAO dao;

	/*
	 * public List<Customer> getAllCust() {
	 * 
	 * String jpql = "select c from Customer c"; return
	 * mgr.unwrap(Session.class).createQuery(jpql, Customer.class).getResultList();
	 * }
	 */

	@Override
	public Customer authenticate(Customer customer) {

		Customer temp = new Customer();
		temp.setEmail(customer.getEmail());
		temp.setPassword(customer.getPassword());
		
		System.out.println(temp);
		
		Example<Customer> examplecust = Example.of(temp);
		
		Optional<Customer> optional = dao.findOne(examplecust);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean register(Customer customer) {
		
		try {
			dao.save(customer);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}