package furama_resort.furama_resort_manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class FacilityType {
    @Id
    private int id;

    @Column(columnDefinition = "varchar(45)")
    private String name;

    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilitySet;

    public FacilityType() {
    }

    public FacilityType(int id, String name, Set<Facility> facilitySet) {
        this.id = id;
        this.name = name;
        this.facilitySet = facilitySet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }
}
