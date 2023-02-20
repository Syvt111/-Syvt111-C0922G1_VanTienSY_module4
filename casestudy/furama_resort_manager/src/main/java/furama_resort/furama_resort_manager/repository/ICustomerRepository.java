package furama_resort.furama_resort_manager.repository;

import furama_resort.furama_resort_manager.model.Customer;
import furama_resort.furama_resort_manager.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer>findCustomerByNameContaining(String name, Pageable pageable);

}
