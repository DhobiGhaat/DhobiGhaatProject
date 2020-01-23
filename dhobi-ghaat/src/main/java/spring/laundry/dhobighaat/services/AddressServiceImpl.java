package spring.laundry.dhobighaat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.laundry.dhobighaat.daos.IAddressDAO;
import spring.laundry.dhobighaat.daos.ICustomerDAO;
import spring.laundry.dhobighaat.pojos.Address;
import spring.laundry.dhobighaat.pojos.Customer;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressDAO addrdao;

	@Autowired
	private ICustomerDAO custDao;

	@Override
	public boolean addAddress(Address address, Integer custId) {

		Customer temp = new Customer();
		temp.setCustomerId(custId);

		Example<Customer> examplecust = Example.of(temp);

		Optional<Customer> optional = custDao.findOne(examplecust);

		if (optional.isPresent()) {
			address.setCustomer(optional.get());
			try {
				addrdao.save(address);
				return true;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return false;
	}

	@Override
	public List<Address> getAddressByCustId(Integer custId) {

		Customer temp = new Customer();
		temp.setCustomerId(custId);

		Example<Customer> examplecust = Example.of(temp);

		Optional<Customer> optional = custDao.findOne(examplecust);

		if (optional.isPresent()) {
			try {
				return addrdao.findAllAddress(optional.get());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}

	@Override
	public boolean removeAddress(Integer id) {

		Optional<Address> optional = addrdao.findById(id);
		
		if (optional.isPresent()) {
			Customer temp = optional.get().getCustomer();
			temp.removeaddress(optional.get());
			addrdao.deleteById(id);
			return true;
		}
		return false;
	}

}
