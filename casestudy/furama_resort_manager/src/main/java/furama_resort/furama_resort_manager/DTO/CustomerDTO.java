package furama_resort.furama_resort_manager.DTO;

import furama_resort.furama_resort_manager.model.Contract;
import furama_resort.furama_resort_manager.model.CustomerType;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDTO {

    private int id;

    @NotBlank(message = "Must be not blank ")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$", message = "Must capitalize the beginning of each letter")
    private String name;

    @NotEmpty(message = "Must be not empty")
    @NotNull(message = "Must be not empty ")
    private String dayOfBirth;
    private boolean gender;

    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "Incorrect format (9 or 12 numbers)")
    @NotNull(message = "Must be not empty ")
    private String idCard;
    //    @Pattern(regexp = "^((090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|(\\(84\\)\\+91[0-9]{7}))$", message = "Incorrect format (090, 091, (84)+90, (84)+91)")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Incorrect format (09, 03, 08)")
    @NotNull(message = "Must be not empty ")
    private String phoneNumber;

    @Pattern(regexp = "^[\\w.+\\-]+@gmail\\.com$", message = "Incorrect format (@gmail.com)")
    @NotNull(message = "Must be not empty ")
    private String email;

    @NotEmpty(message = "Must be not empty")
    @NotNull(message = "Must be not empty ")
    private String address;

    private CustomerType customerType;
    private Set<Contract> contractSet;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, CustomerType customerType, String name, String dayOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address, Set<Contract> contractSet) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.contractSet = contractSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

}
