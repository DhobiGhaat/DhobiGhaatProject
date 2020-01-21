package spring.laundry.dhobighaat.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ServiceType {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer serviceID;
	
	private Double priceList;
	
	@Enumerated(EnumType.STRING)
	private TypeOfService service ;
	
	@OneToMany(mappedBy = "plan",cascade = CascadeType.ALL)
	private List<Order> order = new ArrayList<Order>();
	
	public ServiceType() {
		
	}

	public ServiceType(Integer serviceID, Double priceList) {
		super();
		this.serviceID = serviceID;
		this.priceList = priceList;
	}
	
	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	public Double getPriceList() {
		return priceList;
	}

	public void setPriceList(Double priceList) {
		this.priceList = priceList;
	}
	
	public TypeOfService getService() {
		return service;
	}

	public void setService(TypeOfService service) {
		this.service = service;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}	
}
