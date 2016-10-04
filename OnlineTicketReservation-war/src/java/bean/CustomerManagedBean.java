/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Customer;
import entity.Ticket;
import java.text.SimpleDateFormat;
import stub.CustomerStub;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Admin
 */ 
@ManagedBean (name = "customerBean")
@RequestScoped
public class CustomerManagedBean {

    private Customer entity;
    private String message;
    private CustomerStub stub = new CustomerStub();
    private Date currentDate = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private String storeUsername;

    public CustomerManagedBean() {
        entity = new Customer();
    }

    @PostConstruct
    public void init() {
        entity.setStatus("Active");
        entity.setCreateday(currentDate);
        entity.setLastDay(currentDate);
    }

    public void checkDuplicateEmail() {
        boolean isExist = false;
        for (Customer cust : getAllCustomer()) {
            if (entity.getEmail().equals(cust.getEmail())) {
                isExist = true;
            }
        }
        if (isExist) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "This email is already registered",
                    "Please use a different email for registering"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "This email is available", "You can use it to register"));
        }
    }

    public List<Customer> getAllCustomer() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteCustomer(Customer customer) {
        try {
            stub.remove(customer);
            message = "Customer has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public String createCustomer() {
        System.out.println("1: " + entity.getPassport());
        System.out.println("2: " + entity.getPassword());
        System.out.println("3: " + entity.getAddress());
        System.out.println("4: " + entity.getCustomerId());
        System.out.println("5: " + entity.getPhone());
        System.out.println("6: " + entity.getStatus());
        System.out.println("7: " + entity.getGenre());
        System.out.println("1: " + entity.getDob());
        System.out.println("1: " + entity.getLastDay());
//            stub.create(entity);
        return "main?faces-redirect=true";
    }

    public String selectedCustomer(int id) {
        entity = stub.find(id);
        return "editCustomer";
    }

    public String updateCustomer() {
        try {
            stub.edit(entity);
        } catch (Exception e) {

        }
        return "mainCustomer?faces-redirect=true";
    }

    public Customer getEntity() {
        return entity;
    }

    public void setEntity(Customer entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCustomerId() {
        return entity.getCustomerId();
    }

    public void setCustomerId(Integer customerId) {
        entity.setCustomerId(customerId);
    }

    public String getCustomerName() {
        return entity.getCustomerName();
    }

    public void setCustomerName(String customerName) {
        entity.setCustomerName(customerName);
    }

    public String getPassword() {
        return entity.getPassword();
    }

    public void setPassword(String password) {
        entity.setPassword(password);
    }

    public String getEmail() {
        return entity.getEmail();
    }

    public void setEmail(String email) {
        entity.setEmail(email);
    }

    public String getAddress() {
        return entity.getAddress();
    }

    public void setAddress(String address) {
        entity.setAddress(address);
    }

    public String getPhone() {
        return entity.getPhone();
    }

    public void setPhone(String phone) {
        entity.setPhone(phone);
    }

    public Date getDob() {
        return entity.getDob();
    }

    public void setDob(Date dob) {
        entity.setDob(dob);
    }

    public String getGenre() {
        return entity.getGenre();
    }

    public void setGenre(String genre) {
        entity.setGenre(genre);
    }

    public Date getCreateday() {
        return entity.getCreateday();
    }

    public void setCreateday(Date createday) {
        entity.setCreateday(createday);
    }

    public String getPassport() {
        return entity.getPassport();
    }

    public void setPassport(String passport) {
        entity.setPassport(passport);
    }

    public Date getLastDay() {
        return entity.getLastDay();
    }

    public void setLastDay(Date lastDay) {
        entity.setLastDay(lastDay);
    }

    public String getStatus() {
        return entity.getStatus();
    }

    public void setStatus(String status) {
        entity.setStatus(status);
    }

    public List<Ticket> getTicketList() {
        return entity.getTicketList();
    }

    public void setTicketList(List<Ticket> ticketList) {
        entity.setTicketList(ticketList);
    }

    public String getStoreUsername() {
        return entity.getEmail();
    }

    public void setStoreUsername(String storeUsername) {
        this.storeUsername = storeUsername;
    }
}
