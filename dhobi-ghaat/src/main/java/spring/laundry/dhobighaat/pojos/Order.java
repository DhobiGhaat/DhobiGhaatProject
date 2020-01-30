package spring.laundry.dhobighaat.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties(value = { "customers" })
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private double weight;
	
	private LocalDate orderDate;
	
	private LocalDate pickUpDate;
	
	private LocalDate deliveryDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private double bill;
	
	@ManyToOne
	@JoinColumn(name = "custId")
	private Customer customers;
	
	@ManyToOne
	@JoinColumn(name = "serviceId")
	private ServiceType plan;
	
	public Order() {
		
	}
	
	public Order(Integer orderId, double weight, LocalDate orderDate, LocalDate pickUpDate, LocalDate deliveryDate,
			OrderStatus status, double bill, Customer customers, ServiceType plan) {
		super();
		this.orderId = orderId;
		this.weight = weight;
		this.orderDate = orderDate;
		this.pickUpDate = pickUpDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.bill = bill;
		this.customers = customers;
		this.plan = plan;
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
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
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
