package spring.laundry.dhobighaat.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.laundry.dhobighaat.pojos.ServiceType;

public interface IServiceTypeDAO extends JpaRepository<ServiceType, Integer> {

}
