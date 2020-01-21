package spring.laundry.dhobighaat.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.laundry.dhobighaat.pojos.Customer;

@Repository
public interface ICustomerDAO extends JpaRepository<Customer, Integer>{

}
