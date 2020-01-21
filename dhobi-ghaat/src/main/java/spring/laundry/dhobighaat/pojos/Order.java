package spring.laundry.dhobighaat.pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private double weight;
	
	private LocalDate pickUpDate;
	
	private LocalDate deliveryDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private double bill;
	
	@ManyToOne
	private Customer customers;
	
	@ManyToOne
	private ServiceType plan;
	
	public Order() {
		
	}
	public Order(Integer orderId, double weight, LocalDate pickUpDate, LocalDate deliveryDate, double bill) {
		super();
		this.orderId = orderId;
		this.weight = weight;
		this.pickUpDate = pickUpDate;
		this.deliveryDate = deliveryDate;
		this.bill = bill;
	}
	
	public Customer getCustomers() {
		return customers;
	}
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
	public ServiceType getPlan() {
		return plan;
	}
	public void setPlan(ServiceType plan) {
		this.plan = plan;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public LocalDate getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(LocalDate pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
}
