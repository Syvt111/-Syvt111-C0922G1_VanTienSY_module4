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
    ICustomerRepository customerRepository;

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
    public void edit(int id) {

    }

    @Override
    public Page<Customer> findCustomerByNameAndEmailAndCustomerTypeContaining(String name, String email, String customerType, Pageable pageable) {
        return customerRepository.search(name,email,customerType,pageable);
    }


}
