package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.DTO.ContractDTO;
import furama_resort.furama_resort_manager.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractService {
    Page<Contract> findContractById(int id, Pageable pageable);
    List<Contract> findAll();
    Contract findById(int id);
    void save(Contract contract);
    void delete(int id);
    Page<Contract> findAll(Pageable pageable);
    Double calculateTotal(@Param("contractId") int contractId);

    Page<ContractDTO> getAllContractDTO(Pageable pageable);
}
