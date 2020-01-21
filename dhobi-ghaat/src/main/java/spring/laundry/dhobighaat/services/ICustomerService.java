package spring.laundry.dhobighaat.services;

import spring.laundry.dhobighaat.pojos.Customer;

public interface ICustomerService {
	
	public Customer authenticate(Customer customer);
	public boolean register(Customer customer);
}
