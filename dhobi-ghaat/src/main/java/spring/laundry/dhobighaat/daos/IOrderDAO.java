package spring.laundry.dhobighaat.daos;
import spring.laundry.dhobighaat.pojos.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDAO extends JpaRepository<Order, Integer> {

}
