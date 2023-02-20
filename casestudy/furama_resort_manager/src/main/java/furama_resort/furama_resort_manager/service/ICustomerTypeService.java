package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
