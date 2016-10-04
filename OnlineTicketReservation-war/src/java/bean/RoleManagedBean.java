/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Account;
import entity.Role;
import stub.RoleStub;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean (name = "roleBean")
@RequestScoped
public class RoleManagedBean {
    private Role entity;
    private String message;
    private RoleStub stub = new RoleStub();
    
    public RoleManagedBean() {
        entity = new Role();
    }
    
    public List<Role> getAllRole() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void delete(Role role) {
        try {
            stub.remove(role);
            message = "Role has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public void create() {
        try {
            stub.create(entity);
            message = "New role has been added";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }
    
    public Role getRole(int id){
        entity = stub.find(id);
        return entity;
    }

    public String editSetup(int id) {
        try {
            entity = stub.find(id);
            return "editRole";
        } catch (Exception e) {
            message = e.getMessage();
            return null;
        }
    }

    public String update() {
        try {
            stub.edit(entity);
        } catch (Exception e) {

        }
        return "index";
    }

    public Integer getRoleId() {
        return entity.getRoleId();
    }

    public void setRoleId(Integer roleId) {
        entity.setRoleId(roleId);
    }

    public String getRoleType() {
        return entity.getRoleType();
    }

    public void setRoleType(String roleType) {
        entity.setRoleType(roleType);
    }

    public List<Account> getAccountList() {
        return entity.getAccountList();
    }

    public void setAccountList(List<Account> accountList) {
        entity.setAccountList(accountList);
    }

    public Role getEntity() {
        return entity;
    }

    public void setEntity(Role entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
