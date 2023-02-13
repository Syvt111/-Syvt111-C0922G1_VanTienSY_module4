package furama_resort.furama_resort_manager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date_of_birth;
    private String id_card;
    private double salary;
    private String phone_number;
    private String email;
    private String address;
    private String username ;
}
