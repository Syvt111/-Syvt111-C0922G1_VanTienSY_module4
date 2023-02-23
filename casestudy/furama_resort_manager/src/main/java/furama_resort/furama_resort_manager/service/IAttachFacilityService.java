package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.AttachFacility;
import furama_resort.furama_resort_manager.model.Facility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();
    AttachFacility findById(int id);
    void save(AttachFacility attachFacility);
    void delete(int id);
}
