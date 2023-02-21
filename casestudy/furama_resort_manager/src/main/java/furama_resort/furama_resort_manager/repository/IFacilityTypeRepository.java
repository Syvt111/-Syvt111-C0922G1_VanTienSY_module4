package furama_resort.furama_resort_manager.repository;

import furama_resort.furama_resort_manager.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
}
