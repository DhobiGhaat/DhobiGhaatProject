package spring.laundry.dhobighaat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.laundry.dhobighaat.pojos.ServiceType;
import spring.laundry.dhobighaat.services.IServiceTypeService;

@RestController
@CrossOrigin
public class ServiceTypeController {
	
	@Autowired
	private IServiceTypeService service;
	
	@RequestMapping(value= "/getallservice",method =RequestMethod.GET)
	public ResponseEntity<?> getallService()
	{
		List<ServiceType> services =null;
		try 
		{
			services=service.getAllService();
			return new ResponseEntity<List<ServiceType>>(services,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}
	@RequestMapping(value= "/updateservice/{id}",method =RequestMethod.PUT)
	public ResponseEntity<?> updateServicebyId(@PathVariable int id,@RequestParam double price)
	{
		try 
		{
			if(service.updateServiceById(id, price))
			{
				return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}
	
}
	
	
	

