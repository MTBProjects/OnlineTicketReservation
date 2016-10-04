/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Seat;
import entity.SeatReserved;
import entity.Ticket;
import stub.SeatReservedStub;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class SeatReservedManagedBean {
    private SeatReserved entity;
    private String message;
    private SeatReservedStub stub = new SeatReservedStub();
    
    public SeatReservedManagedBean() {
        entity = new SeatReserved();
    }
    
        public List<SeatReserved> getAllSeatReserved() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void createSeatReserved() {
        try {
            stub.create(entity);
            message = "New seat has been reserved";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }
    
    public void deleteSeatReserved(SeatReserved sr) {
        stub.remove(sr);
    }

    public String updateSeatReserved() {
        try {
            stub.edit(entity);
        } catch (Exception e) {

        }
        return "index";
    }

    public SeatReserved getEntity() {
        return entity;
    }

    public void setEntity(SeatReserved entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSeatReservedId() {
        return entity.getSeatReservedId();
    }

    public void setSeatReservedId(Integer seatReservedId) {
        entity.setSeatReservedId(seatReservedId);
    }

    public SeatReservedStub getStub() {
        return stub;
    }

    public void setStub(SeatReservedStub stub) {
        this.stub = stub;
    }

    public Seat getSeatId() {
        return entity.getSeatId();
    }

    public void setSeatId(Seat seatId) {
        entity.setSeatId(seatId);
    }

    public int getTicketId() {
        return entity.getTicketId();
    }

    public void setTicketId(int ticketId) {
        entity.setTicketId(ticketId);
    }

    public List<Ticket> getTicketList() {
        return entity.getTicketList();
    }

    public void setTicketList(List<Ticket> ticketList) {
        entity.setTicketList(ticketList);
    }
    
    
}
