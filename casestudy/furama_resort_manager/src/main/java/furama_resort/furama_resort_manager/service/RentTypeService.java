package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.RentType;
import furama_resort.furama_resort_manager.repository.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService{
    @Autowired
    IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
