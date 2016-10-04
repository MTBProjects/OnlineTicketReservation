/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Event;
import entity.Ticket;
import stub.EventStub;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean (name = "eventBean")
@RequestScoped
public class EventManagedBean {

    private Event entity;
    private String message;
    private EventStub stub = new EventStub();

    public EventManagedBean() {
        entity = new Event();
    }

    public List<Event> getAllEvent() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteEvent(Event event) {
        try {
            stub.remove(event);
            message = "Event has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public String createEvent() {
        try {
            stub.create(entity);
            message = "New event has been added";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return "mainEvent";
    }
    
    public String selectedEvent(int id) {
        try {
            entity = stub.find(id);
            return "editEvent";
        } catch (Exception e) {
            message = e.getMessage();
            return null;
        }
    }

    public String updateEvent() {
        try {
            stub.edit(entity);
        } catch (Exception e) {

        }
        return "index";
    }

    public Event getEntity() {
        return entity;
    }

    public void setEntity(Event entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getEventId() {
        return entity.getEventId();
    }

    public void setEventId(Integer eventId) {
        entity.setEventId(eventId);
    }

    public String getEventTitle() {
        return entity.getEventTitle();
    }

    public void setEventTitle(String eventTitle) {
        entity.setEventTitle(eventTitle);
    }

    public String getDescription() {
        return entity.getDescription();
    }

    public void setDescription(String description) {
        entity.setDescription(description);
    }

    public Date getStartDay() {
        return entity.getStartDay();
    }

    public void setStartDay(Date startDay) {
        entity.setStartDay(startDay);
    }

    public Date getEndDay() {
        return entity.getEndDay();
    }

    public void setEndDay(Date endDay) {
        entity.setEndDay(endDay);
    }

    public List<Ticket> getTicketList() {
        return entity.getTicketList();
    }

    public void setTicketList(List<Ticket> ticketList) {
        entity.setTicketList(ticketList);
    }

}
