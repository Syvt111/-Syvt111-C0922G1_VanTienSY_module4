package furama_resort.furama_resort_manager.DTO;

import furama_resort.furama_resort_manager.model.ContractDetail;
import furama_resort.furama_resort_manager.model.Customer;
import furama_resort.furama_resort_manager.model.Employee;
import furama_resort.furama_resort_manager.model.Facility;

import javax.persistence.*;
import java.util.Set;

public class ContractDTO {

    private int id;

    private String startDate;


    private String endDate;

    private double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;
    private double total;

    public ContractDTO(int id, String startDate, String endDate, double deposit, Employee employee, Customer customer, Facility facility, double total) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.total = total;
    }

    public ContractDTO(int id, String startDate, String endDate, double deposit, Employee employee, Customer customer,
                       Facility facility, Set<ContractDetail> contractDetailSet, double total) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.total = total;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ContractDTO() {
    }


    public ContractDTO(int id, String startDate, String endDate,
                    double deposit, Employee employee,
                    Customer customer, Facility facility,
                    Set<ContractDetail> contractDetailSet) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
