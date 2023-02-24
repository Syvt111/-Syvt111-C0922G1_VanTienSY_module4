package furama_resort.furama_resort_manager.repository;

import furama_resort.furama_resort_manager.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    List<ContractDetail> findContractDetailByContract_Id(int id);
}
