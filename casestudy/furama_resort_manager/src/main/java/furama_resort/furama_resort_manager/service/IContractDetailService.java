package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.ContractDetail;
import furama_resort.furama_resort_manager.model.Customer;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();
    ContractDetail findById(int id);
    void save(ContractDetail contractDetail);
    void delete(int id);
}
