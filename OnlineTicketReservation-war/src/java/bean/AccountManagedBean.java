/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Account;
import entity.Role;
import stub.AccountStub;
import java.util.Date;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean (name = "accBean")
@RequestScoped
public class AccountManagedBean {

    private Account entity;
    private String message;
    private String pass, dbPassword;
    private String name, dbName;
    private String storeUsername;
    private AccountStub stub = new AccountStub();

    public AccountManagedBean() {
        entity = new Account();
    }
    
    public void addLastDate(){
        entity.setLastDay(new Date());
        stub.edit(entity);
    }

    public List<Account> getAllAccount() {
        try {
            System.out.println("Username: " + entity.getUsername());
            System.out.println("Pass: " + entity.getPassword());
            System.out.println("Fullname: " + entity.getFullname());
            System.out.println("Genre: " + entity.getGenre());
            System.out.println("Email: " + entity.getEmail());
            System.out.println("Address: " + entity.getAddress());
            System.out.println("Phone: " + entity.getPhone());
            System.out.println("DOB: " + entity.getDob());
            System.out.println("Status: " + entity.getStatus());
            System.out.println("Last Day: " + entity.getLastDay());
            System.out.println("Role: " + entity.getRoleId());
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteAccount(Account acc) {
        try {
            stub.remove(acc);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public void createAccount() {
        try {
            stub.create(entity);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }
    
    public Account findByName(String name) {
        entity = stub.findByUsername(name);
        return entity;
    }
    
    public String selectedAccount(int id) {
        entity = stub.find(id);
        return "editStaff";
    }
    
    public String editAccountSetup(int id) {
            entity = stub.find(id);
            return "editStaff";
    }

    public String updateAccount() {
        try {
            stub.edit(entity);
        } catch (Exception e) {

        }
        return "mainStaff?faces-redirect=true";
    }

    public Account getEntity() {
        return entity;
    }

    public void setEntity(Account entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAccountId() {
        return entity.getAccountId();
    }

    public void setAccountId(Integer accountId) {
        entity.setAccountId(accountId);
    }

    public String getUsername() {
        return entity.getUsername();
    }

    public void setUsername(String username) {
        entity.setUsername(username);
    }

    public String getPassword() {
        return entity.getPassword();
    }

    public void setPassword(String password) {
        entity.setPassword(password);
    }

    public String getFullname() {
        return entity.getFullname();
    }

    public void setFullname(String fullname) {
        entity.setFullname(fullname);
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

    public Role getRoleId() {
        return entity.getRoleId();
    }

    public void setRoleId(Role roleId) {
        entity.setRoleId(roleId);
    }

    public String getStoreUsername() {
        return entity.getUsername();
    }

    public void setStoreUsername(String storeUsername) {
        this.storeUsername = storeUsername;
    }

    
}
