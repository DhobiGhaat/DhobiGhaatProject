package spring.laundry.dhobighaat.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cust_address")
@JsonIgnoreProperties(value = { "customer" })
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	private String houseNo;
	private String society;
	private String city;
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name = "custId")
	private Customer customer;
	
	public Address() {
		
	}
	
	public Address(Integer addressId, String houseNo, String society, String city, String pincode, Customer customer) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.society = society;
		this.city = city;
		this.pincode = pincode;
		this.customer = customer;
	}

	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getSociety() {
		return society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
