package spring.laundry.dhobighaat.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.laundry.dhobighaat.daos.IServiceTypeDAO;
import spring.laundry.dhobighaat.pojos.ServiceType;
@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
	
	@Autowired
	private IServiceTypeDAO dao;
	
	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public List<ServiceType> getAllService() {
		// TODO Auto-generated method stub
		List<ServiceType> services=null;
		String jpql=null;
		try 
		{
			jpql="SELECT s FROM ServiceType as s";
			services=mgr.unwrap(Session.class).createQuery(jpql,ServiceType.class).getResultList();
			return services;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean updateServiceById(Integer id,double price) 
	{
		// TODO Auto-generated method stub
		ServiceType service=null;
		try 
		{
			service=mgr.unwrap(Session.class).get(ServiceType.class,id);
			service.setPrice(price);
			dao.save(service);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

}
