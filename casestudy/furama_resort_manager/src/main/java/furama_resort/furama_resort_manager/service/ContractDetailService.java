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
        return contractDetailRepository.findById(id).get();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);

    }

    @Override
    public void delete(int id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public  List<ContractDetail> findContractDetailByContract_Id(int id) {
        return contractDetailRepository.findContractDetailByContract_Id(id);
    }


}
