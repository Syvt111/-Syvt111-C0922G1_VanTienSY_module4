package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.DTO.ContractDTO;
import furama_resort.furama_resort_manager.model.Contract;
import furama_resort.furama_resort_manager.repository.IContractRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findContractById(int id, Pageable pageable) {
        return contractRepository.findContractById(id, pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void delete(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Double calculateTotal(int contractId) {
        return contractRepository.calculateTotal(contractId);
    }

    @Override
    public Page<ContractDTO> getAllContractDTO(Pageable pageable) {
        Page<Contract> contractPage = contractRepository.findAll(pageable);
        List<Contract> contractList = contractPage.getContent();
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        List<ContractDTO> contractDTOList = new ArrayList<>();
        for (Contract con : contractList
        ) {
            ContractDTO contractDTO = new ContractDTO();
            BeanUtils.copyProperties(con,contractDTO);
            contractDTO.setTotal(contractRepository.calculateTotal(con.getId()));
            contractDTOList.add(contractDTO);
        }
        Page<ContractDTO> contractDTOPage = new PageImpl<>(contractDTOList,pageable1,contractPage.getTotalElements());

        return contractDTOPage;
    }

}
