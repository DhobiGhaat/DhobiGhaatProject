package spring.laundry.dhobighaat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.laundry.dhobighaat.pojos.Address;
import spring.laundry.dhobighaat.services.IAddressService;

@RestController
@CrossOrigin
public class AddressController {

	@Autowired
	IAddressService service;
	
	@RequestMapping(value = "/addressadd", method = RequestMethod.POST)
	public ResponseEntity<?> m1(@RequestBody Address address,@RequestParam Integer custId) {
		if (service.addAddress(address,custId)) {
			return new ResponseEntity<String>("Address added Successfully!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Address addition failed!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addresslist", method = RequestMethod.POST)
	public ResponseEntity<?> m2(@RequestParam Integer custId) {
		
		List<Address> addr = null;
		
		try {
			addr = service.getAddressByCustId(custId);
			return new ResponseEntity<List<Address>>(addr, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("No Addess available!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addressRemoval", method = RequestMethod.DELETE)
	public ResponseEntity<?> m3(@RequestParam Integer addrId) {
		if (service.removeAddress(addrId)) {
			return new ResponseEntity<String>("Address removed Successfully!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Address removal failed!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addressUpdate", method = RequestMethod.PUT)
	public ResponseEntity<?> m4(@RequestBody Address address) {
		if (service.updateAddress(address)) {
			return new ResponseEntity<String>("Address updated Successfully!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Address update Failed!", HttpStatus.OK);
	}
}
