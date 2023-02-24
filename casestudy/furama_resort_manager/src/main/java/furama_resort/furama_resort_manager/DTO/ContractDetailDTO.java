package furama_resort.furama_resort_manager.DTO;

import furama_resort.furama_resort_manager.model.AttachFacility;
import furama_resort.furama_resort_manager.model.Contract;

import javax.persistence.*;


public class ContractDetailDTO {


    private int id;

    private Contract contract;

    private AttachFacility attachFacility;

    private int quantity;
    private double total ;

    public ContractDetailDTO(int id, Contract contract, AttachFacility attachFacility, int quantity, double total) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
        this.total = total;
    }

    public ContractDetailDTO() {
    }

    public ContractDetailDTO(int id, Contract contract, AttachFacility attachFacility, int quantity) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMoney(){
        return quantity*attachFacility.getCost();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
