package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.Facility;
import furama_resort.furama_resort_manager.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> findCustomerByNameContaining(String name, Pageable pageable) {
        return facilityRepository.findCustomerByNameContaining(name, pageable);
    }

    @Override
    public Page<Facility> searchByNameAndFacilityType(String name, int facilityType, Pageable pageable) {
        return facilityRepository.search(name, facilityType, pageable);
    }

    @Override
    public Page<Facility> findByNameContainingAndFacilityType_Id(String name, int facilityType, Pageable pageable) {
        return facilityRepository.findByNameContainingAndFacilityType_Id(name,facilityType,pageable);
    }
}
