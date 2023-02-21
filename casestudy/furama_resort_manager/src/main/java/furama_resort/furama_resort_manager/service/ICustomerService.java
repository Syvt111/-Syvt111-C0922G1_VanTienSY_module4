package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void delete(int id);
    Page<Customer> findCustomerByNameAndEmailAndCustomerTypeContaining(String name, String email, int customerType, Pageable pageable);
    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType_Id(String name,String email,int customerType,Pageable pageable);
    Page<Customer>findByNameContainingAndEmailContaining(String name, String email,Pageable pageable);
}
