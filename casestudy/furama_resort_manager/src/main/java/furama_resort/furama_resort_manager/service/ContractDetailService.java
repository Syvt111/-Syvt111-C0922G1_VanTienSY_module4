package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.ContractDetail;
import furama_resort.furama_resort_manager.model.Customer;
import furama_resort.furama_resort_manager.repository.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(int id) {
        return null;
    }

    @Override
    public void save(ContractDetail contractDetail) {

    }

    @Override
    public void delete(int id) {

    }


}
