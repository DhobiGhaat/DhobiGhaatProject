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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.laundry.dhobighaat.pojos.Order;
import spring.laundry.dhobighaat.pojos.OrderStatus;
import spring.laundry.dhobighaat.services.IOrderService;

@RestController
@CrossOrigin
public class OrderController 
{
	@Autowired
	private IOrderService service;
	
	@RequestMapping(value= "/getallorder",method =RequestMethod.GET)
	public ResponseEntity<?> getOrder()
	{
		List<Order> orders=null;
		try 
		{
			orders=service.getAllOrder();
			return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}
	
	@RequestMapping(value= "/createorder/{id}",method=RequestMethod.POST)
	public ResponseEntity<?> createOrder(@RequestBody Order order,@PathVariable Integer id,@RequestParam String serviceType,@RequestParam String status)
	{
		try
		{
			if(service.createOrder(order,id,serviceType,status))
			{
			   return new ResponseEntity<String>("Order Successfully added",HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}
	
	@RequestMapping(value= "/getorderbystatus",method =RequestMethod.GET)
	public ResponseEntity<?> getOrderByStatus(@RequestParam String status)
	{
		List<Order> orders=null;
		try 
		{
			orders=service.getOrderByStatus(OrderStatus.valueOf(status.toUpperCase())); 
			return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}

	@RequestMapping(value= "/getorderbycustid",method =RequestMethod.GET)
	public  ResponseEntity<?> getOrderByCustomerId(@RequestParam int id)
	{
		 List<Order> order=null;
		 try
		 {
			 order=service.getOrderByCustomerID(id);
			 return new ResponseEntity<List<Order>>(order,HttpStatus.OK); 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}
	
	@RequestMapping(value= "/updateOrderByStatus",method =RequestMethod.PUT)
	public  ResponseEntity<?> updateOrderStatus(@RequestBody Order order)
	{	
		try 
		{
			if(service.updateOrderByStatus(order))
			{
				return new ResponseEntity<String>("Successfully updated",HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}
	
	@RequestMapping(value= "getorderbyid/{id}",method =RequestMethod.GET)
	public ResponseEntity<?> getOrderById(@PathVariable int id)
	{
		Order order=null;
		try 
		{
			order=service.getOrderByID(id);
			return new ResponseEntity<Order>(order,HttpStatus.OK); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return new ResponseEntity<String>("Authentication Failed: Invalid Credentials",HttpStatus.OK);
	}
}
