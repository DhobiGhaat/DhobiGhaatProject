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
import spring.laundry.dhobighaat.pojos.TypeOfService;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@PersistenceContext
	private EntityManager mgr;
	@Autowired
	private IOrderDAO dao;
	
	
	@Override
	public boolean createOrder(Order order,int id,String serviceType,String status)
	{
		Customer customer=null;
		ServiceType st=null;
		String jpql;
		try 
		{
			TypeOfService temp = TypeOfService.valueOf(serviceType.toUpperCase());
			customer=mgr.unwrap(Session.class).get(Customer.class, id);
			jpql="SELECT s FROM ServiceType as s WHERE s.service=:service";
			st=mgr.unwrap(Session.class).createQuery(jpql,ServiceType.class).setParameter("service",temp).getSingleResult();
			//st=mgr.unwrap(Session.class).get(ServiceType.class, sid);
			order.setCustomers(customer);
			order.setPlan(st);
			order.setBill(order.getWeight()*st.getPrice());
			order.setStatus(OrderStatus.valueOf(status.toUpperCase()));
			order.setDeliveryDate(order.getPickUpDate().plusDays(3));
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
	public boolean updateOrderByStatus(Order order)
	{
		// TODO Auto-generated method stub
		Order temp=null;
		OrderStatus status;
		int id;	
		try
		{	
			id=order.getOrderId();
			status=order.getStatus();
			temp=mgr.unwrap(Session.class).get(Order.class, id);
			temp.setStatus(status);
			dao.save(temp);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}
