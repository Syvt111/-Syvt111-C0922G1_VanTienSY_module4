package furama_resort.furama_resort_manager.service;

import furama_resort.furama_resort_manager.model.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();
    Facility findById();
    void save(Facility facility);
    void delete(int id);
    void edit(int id);
}
