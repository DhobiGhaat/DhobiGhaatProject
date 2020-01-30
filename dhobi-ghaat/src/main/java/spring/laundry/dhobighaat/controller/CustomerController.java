package spring.laundry.dhobighaat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.laundry.dhobighaat.pojos.Customer;
import spring.laundry.dhobighaat.services.ICustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	ICustomerService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> m1(@RequestBody Customer customer) {
		
		Customer temp = service.login(customer);

		if (temp != null) {
			return new ResponseEntity<Customer>(temp, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials", HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> m2(@RequestBody Customer customer) {
		
		if (service.register(customer)) {
			return new ResponseEntity<String>("Successful", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Email or Mobile No already exist", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listCust", method = RequestMethod.GET)
	public ResponseEntity<?> m3() {
		
		List<Customer> allCustomers = service.getAllCustomers();
		
		if (allCustomers.size()==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removeCust/{custId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> m3(@PathVariable Integer custId) {
		if (service.removeCustomer(custId)) {
			return new ResponseEntity<String>("Customer removed Successfully!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Customer removal failed!", HttpStatus.OK);
	}
}
