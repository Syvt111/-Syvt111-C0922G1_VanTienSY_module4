package furama_resort.furama_resort_manager.repository;

import furama_resort.furama_resort_manager.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findContractById(int id, Pageable pageable);

    @Override
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select (ifnull(f.cost,0) + ifnull(sum( af.cost * cd.quantity),0)) as total from `contract` c " +
            "left join `contract_detail` cd on c.id = cd.id left join `attach_facility` af on af.id = cd.id left join " +
            "`facility` f on c.id = f.id where c.id = :contractId group by c.id", nativeQuery = true)
    Double calculateTotal(@Param("contractId") int contractId);


}
