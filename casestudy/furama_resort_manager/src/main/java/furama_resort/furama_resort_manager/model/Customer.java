package furama_resort.furama_resort_manager.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    @Column(columnDefinition = "date")
    private String date_of_birth;
    private byte gender ;
    private String id_card ;
    private String phone_number;
    private String email;
    private String address;

}
