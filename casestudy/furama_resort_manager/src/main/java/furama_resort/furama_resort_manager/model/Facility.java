package furama_resort.furama_resort_manager.model;

import javax.persistence.*;

@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private int are ;
    private double cost ;
    private int max_people ;
    private String standard_room ;
    private String description_other_convenience ;
    private double pool_are ;
    private int number_of_floor ;

    @Column(columnDefinition = "text")
    private String facility_free;
}
