package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.Customer;
import furama_resort.furama_resort_manager.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findCustomerByNameAndEmailAndCustomerTypeContaining(String name, String email, int customerType, Pageable pageable) {
        return customerRepository.search(name,email,customerType,pageable);
    }

    @Override
    public Page<Customer> findByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, int customerType,Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContainingAndCustomerType_Id(name,email,customerType,pageable);
    }

    @Override
    public Page<Customer> findByNameContainingAndEmailContaining(String name, String email,Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContaining(name,email,pageable);
    }


}
