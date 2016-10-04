/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Screen;
import entity.Theatre;
import stub.TheatreStub;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class TheatreManagedBean {
    private Theatre entity;
    private String message;
    private TheatreStub stub = new TheatreStub();
    
    public TheatreManagedBean() {
        entity = new Theatre();
    }
    
    public List<Theatre> getAllTheatre() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteTheatre(Theatre theatre) {
        try {
            stub.remove(theatre);
            message = "Theatre has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public void createTheatre() {
        try {
            stub.create(entity);
            message = "New Theatre has been added";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public String editTheatreSetup(int id) {
        try {
            entity = stub.find(id);
            return "editTheatre";
        } catch (Exception e) {
            message = e.getMessage();
            return null;
        }
    }

    public String updateTheatre() {
        try {
            stub.edit(entity);
        } catch (Exception e) {

        }
        return "index";
    }

    public Theatre getEntity() {
        return entity;
    }

    public void setEntity(Theatre entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTheatreId() {
        return entity.getTheatreId();
    }

    public void setTheatreId(Integer theatreId) {
        entity.setTheatreId(theatreId);
    }

    public String getTheatreName() {
        return entity.getTheatreName();
    }

    public void setTheatreName(String theatreName) {
        entity.setTheatreName(theatreName);
    }

    public String getTheatreAddress() {
        return entity.getTheatreAddress();
    }

    public void setTheatreAddress(String theatreAddress) {
        entity.setTheatreAddress(theatreAddress);
    }

    public int getScreenNo() {
        return entity.getScreenNo();
    }

    public void setScreenNo(int screenNo) {
        entity.setScreenNo(screenNo);
    }

    public List<Screen> getScreenList() {
        return entity.getScreenList();
    }

    public void setScreenList(List<Screen> screenList) {
        entity.setScreenList(screenList);
    }
    
    
}
