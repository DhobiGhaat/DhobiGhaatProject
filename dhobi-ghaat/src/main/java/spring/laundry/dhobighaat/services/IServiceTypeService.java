package spring.laundry.dhobighaat.services;

import java.util.List;

import spring.laundry.dhobighaat.pojos.ServiceType;

public interface IServiceTypeService {
   List<ServiceType> getAllService();
   boolean updateServiceById(Integer id,double price);
}
