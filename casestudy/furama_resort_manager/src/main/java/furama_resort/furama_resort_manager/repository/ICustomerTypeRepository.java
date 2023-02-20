package furama_resort.furama_resort_manager.repository;

import furama_resort.furama_resort_manager.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {

}
