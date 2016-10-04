/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Screen;
import entity.SeatReserved;
import entity.Showtimes;
import entity.Theatre;
import stub.ScreenStub;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean (name = "scrBean")
@RequestScoped
public class ScreenManagedBean {

    private Screen entity;
    private String message;
    private ScreenStub stub = new ScreenStub();

    public ScreenManagedBean() {
        entity = new Screen();
    }
    
    public List<Screen> getAllScreen() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Screen findById(int id) {
        entity = stub.findById(id);
        return entity;
    }

    public void delete(Screen screen) {
        try {
            stub.remove(screen);
            message = "Screen has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public void create() {
        try {
            stub.create(entity);
            message = "New screen has been added";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public String editScreenSetup(int id) {
        try {
            entity = stub.find(id);
            return "editScreen";
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

    public Screen getEntity() {
        return entity;
    }

    public void setEntity(Screen entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getScreenId() {
        return entity.getScreenId();
    }

    public void setScreenId(Integer screenId) {
        entity.setScreenId(screenId);
    }

    public String getScreenName() {
        return entity.getScreenName();
    }

    public void setScreenName(String screenName) {
        entity.setScreenName(screenName);
    }

    public int getSeatNum() {
        return entity.getSeatNum();
    }

    public void setSeatNum(int seatNum) {
        entity.setSeatNum(seatNum);
    }

    public ScreenStub getStub() {
        return stub;
    }

    public void setStub(ScreenStub stub) {
        this.stub = stub;
    }

    public Theatre getTheatreId() {
        return entity.getTheatreId();
    }

    public void setTheatreId(Theatre theatreId) {
        entity.setTheatreId(theatreId);
    }

    public List<Showtimes> getShowtimesList() {
        return entity.getShowtimesList();
    }

    public void setShowtimesList(List<Showtimes> showtimesList) {
        entity.setShowtimesList(showtimesList);
    }

}
