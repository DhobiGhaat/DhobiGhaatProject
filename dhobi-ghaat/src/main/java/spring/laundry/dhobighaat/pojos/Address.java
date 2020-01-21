package spring.laundry.dhobighaat.pojos;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String houseNo;
	private String society;
	private String city;
	private String pincode;
	public Address() {
		
	}
	public Address(String houseNo, String society, String city, String pincode) {
		
		this.houseNo = houseNo;
		this.society = society;
		this.city = city;
		this.pincode = pincode;
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
	
}
