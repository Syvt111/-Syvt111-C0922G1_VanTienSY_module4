package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.CustomerType;
import furama_resort.furama_resort_manager.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findByID(int id) {
        return customerTypeRepository.findById(id).get();
    }
}
