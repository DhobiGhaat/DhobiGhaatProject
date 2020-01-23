package spring.laundry.dhobighaat.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.laundry.dhobighaat.pojos.Address;
import spring.laundry.dhobighaat.pojos.Customer;

@Repository
public interface IAddressDAO extends JpaRepository<Address, Integer>{

	@Query("select a from Address a where a.customer= ?1")
	List<Address> findAllAddress(Customer customer);
	
}
