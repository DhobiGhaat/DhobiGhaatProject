package spring.laundry.dhobighaat.services;
import java.util.List;

import spring.laundry.dhobighaat.pojos.*;

public interface IOrderService {

	boolean createOrder(Order order,int id,int sid);
	List<Order> getAllOrder();
	List<Order> getOrderByStatus(OrderStatus status);
	Order getOrderByID(Integer id);
	List<Order> getOrderByCustomerID(Integer id);
	boolean updateOrderByStatus(String status,Integer id);
}
