package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();
    Facility findById(int id);
    void save(Facility facility);
    void delete(int id);
    Page<Facility> findCustomerByNameContaining(String name, Pageable pageable);
    Page<Facility> searchByNameAndFacilityType(String name,int facilityType, Pageable pageable);
    Page<Facility>findByNameContainingAndFacilityType_Id(String name, int facilityType, Pageable pageable);

}
