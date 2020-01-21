package spring.laundry.dhobighaat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.laundry.dhobighaat.pojos.Customer;
import spring.laundry.dhobighaat.services.ICustomerService;

@RestController
public class CustomerController {

	@Autowired
	ICustomerService service;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<?> m1(@RequestBody Customer customer)
	{
		Customer temp = service.authenticate(customer);
		System.out.println(temp);
		
		if(temp != null)
		{
			return new ResponseEntity<Customer>(temp,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}
}
