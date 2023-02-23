package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.AttachFacility;
import furama_resort.furama_resort_manager.repository.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepository.findById(id).get();
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public void delete(int id) {
        attachFacilityRepository.deleteById(id);
    }
}
