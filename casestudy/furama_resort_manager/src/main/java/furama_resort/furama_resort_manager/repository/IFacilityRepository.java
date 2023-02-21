package furama_resort.furama_resort_manager.repository;

import furama_resort.furama_resort_manager.model.Customer;
import furama_resort.furama_resort_manager.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findCustomerByNameContaining(String name, Pageable pageable);

    @Query(value = "select * from Facility where name like concat('%',:name,'%') and facility_type_id" +
            " = :facilityType", nativeQuery = true)
    Page<Facility> search(@Param("name") String name, @Param("facilityType") int facilityType, Pageable pageable);

    Page<Facility>findByNameContainingAndFacilityType_Id(String name, int facilityType, Pageable pageable);

}
