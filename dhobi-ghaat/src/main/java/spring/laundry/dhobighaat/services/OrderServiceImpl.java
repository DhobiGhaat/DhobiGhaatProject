package spring.laundry.dhobighaat.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.laundry.dhobighaat.daos.IOrderDAO;
import spring.laundry.dhobighaat.pojos.Customer;
import spring.laundry.dhobighaat.pojos.Order;
import spring.laundry.dhobighaat.pojos.OrderStatus;
import spring.laundry.dhobighaat.pojos.ServiceType;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@PersistenceContext
	private EntityManager mgr;
	@Autowired
	private IOrderDAO dao;
	
	
	@Override
	public boolean createOrder(Order order,int id,int sid)
	{
		// TODO Auto-generated method stub
		Customer customer=null;
		ServiceType st=null;
		//String jpql;
		try 
		{
			customer=mgr.unwrap(Session.class).get(Customer.class, id);
			//jpql="select s from ServiceType s where service:=ser";
			//st=mgr.unwrap(Session.class).createQuery(jpql,ServiceType.class).setParameter("ser",plan ).getSingleResult();
			st=mgr.unwrap(Session.class).get(ServiceType.class, sid);
			order.setCustomers(customer);
			order.setPlan(st);
			dao.save(order);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<Order> getAllOrder() 
	{
		String jpql = "select o from Order o";
		return mgr.unwrap(Session.class).
				createQuery(jpql, Order.class).getResultList();
	}

	@Override
	public List<Order> getOrderByStatus(OrderStatus status) 
	{
		//List<Order> orders=null;
		
		try 
		{
			String jpql ="SELECT o FROM Order as o WHERE o.status = :status";
//			final Query query = mgr.createQuery("SELECT o FROM Order as o WHERE o.status = :status");
//	        query.setParameter("status", status);
//	        orders=(List)query.getResultList();
	        //return orders;
			return mgr.unwrap(Session.class).createQuery(jpql,Order.class).setParameter("status",status).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Order getOrderByID(Integer id) 
	{
		// TODO Auto-generated method stub
		Order order=null;
		try 
		{
			order=mgr.unwrap(Session.class).get(Order.class, id);
			return order; 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Order> getOrderByCustomerID(Integer id) {
		String jpql="select o from Order o where o.customers=:cust";
		Customer customer=null;
		try
		{
			customer=mgr.unwrap(Session.class).get(Customer.class, id);
			return mgr.unwrap(Session.class).createQuery(jpql, Order.class).setParameter("cust", customer).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean updateOrderByStatus(String status,Integer id)
	{
		// TODO Auto-generated method stub
		Order order=null;
		try
		{
			order=mgr.unwrap(Session.class).get(Order.class, id);
			order.setStatus(OrderStatus.valueOf(status.toUpperCase()));
			dao.save(order);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	

}
