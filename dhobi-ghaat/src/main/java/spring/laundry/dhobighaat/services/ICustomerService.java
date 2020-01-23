package spring.laundry.dhobighaat.services;

import java.util.List;

import spring.laundry.dhobighaat.pojos.Customer;

public interface ICustomerService {
	
	public Customer login(Customer customer);
	public boolean register(Customer customer);
	public List<Customer> getAllCustomers();
}
