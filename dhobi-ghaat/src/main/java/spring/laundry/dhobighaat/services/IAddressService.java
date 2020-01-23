package spring.laundry.dhobighaat.services;

import java.util.List;

import spring.laundry.dhobighaat.pojos.Address;

public interface IAddressService {

	public boolean addAddress(Address address, Integer custId);
	public List<Address> getAddressByCustId(Integer custId);
	public boolean removeAddress(Integer id);
}
