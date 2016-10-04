/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Customer;
import entity.Event;
import entity.Seat;
import entity.SeatReserved;
import entity.Showtimes;
import entity.Ticket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import stub.TicketStub;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import service.SeatMap;
import stub.CustomerStub;
import stub.SeatReservedStub;
import stub.SeatStub;
import stub.ShowtimesStub;

/**
 *
 * @author Admin
 */
@ManagedBean (name = "ticketBean")
@RequestScoped
public class TicketManagedBean {

    private Ticket entity;
    private String message;
    private TicketStub stub = new TicketStub();
    private int id;
    private String cost, sits;
    private List<String> lstSeat = new ArrayList();
    SeatReservedStub seat = new SeatReservedStub();
    Date curdate;
    private SeatReservedManagedBean seatRsBean = new SeatReservedManagedBean();
    private SeatReservedStub seatRsStub;
    private String seatNumber;
    private List<SeatReserved> listOfSeat;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public TicketManagedBean() {
        entity = new Ticket();

    }

    public List<Ticket> getAllTickets() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteTicket(Ticket tk) {
        try {
            stub.remove(tk);
            message = "Ticket has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }
    
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        listOfSeat = seatRsBean.getAllSeatReserved();
        StringBuilder builder = new StringBuilder();

        for (SeatReserved seatRs : listOfSeat) {
            if (seatRs.getTicketId() == entity.getTicketId()) {
                builder.append(seatRs.getSeatId().getSeatRow()
                        + seatRs.getSeatId().getSeatNum() + " ");
            }
        }
        seatNumber = builder.toString();
        this.seatNumber = seatNumber;
    }

    public void cancelTicket(Ticket tk) {
        listOfSeat = seatRsBean.getAllSeatReserved();
        SeatReservedStub seatStub = new SeatReservedStub();
        Ticket ticket = stub.findById(tk.getTicketId());
        
        ticket.setStatus("Cancelled");
        stub.edit(ticket);
        for (SeatReserved seatRs : listOfSeat) {
            if (tk.getTicketId() == seatRs.getTicketId()) {
                seatStub.remove(seatRs);
            }
        }

    }

    public void getInfo() {
        FacesContext f = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) f.getExternalContext().getRequest();
        id = (int) request.getSession().getAttribute("stid");

//        request.getSession().removeAttribute("stid");

        cost = request.getParameter("choosen-cost");
        sits = request.getParameter("choosen-sits");
        sits = sits.trim();
        sits = sits.replaceAll(" ", "");
        StringTokenizer tok = new StringTokenizer(sits);
        do {
            String temp = tok.nextToken(",");
            if (!lstSeat.contains(temp)) {
                lstSeat.add(temp);
            }
        } while (tok.hasMoreTokens());
        for (int i = 0; i < lstSeat.size(); i++) {
            lstSeat.get(i);
        }
    }

    public String createTicket() {
        getInfo();
        ShowtimesStub stStub = new ShowtimesStub();
        Showtimes st = stStub.findById(id);

        LoginSessionBean bean = new LoginSessionBean();
        CustomerStub cStub = new CustomerStub();
        Customer cus = cStub.findByEmail(bean.getEmail());

        entity.setShowtimesId(st);
        entity.setStatus("saled");
        entity.setCustomerId(cus);
        entity.setTotal(Double.parseDouble(cost));
        stub.create(entity);

        for (int i = 0; i < lstSeat.size(); i++) {

            SeatMap sm = new SeatMap();
            List<SeatMap> lstSm = sm.createSeatMap();
            SeatStub sStub = new SeatStub();
            Seat s = new Seat();
            int sId = sm.findId(lstSeat.get(i));
            if (sId >= 0) {
                sId += 1;
                s = sStub.findById(sId);
            }

            SeatReserved ett = new SeatReserved();
            ett.setShowtimesId(st);
            ett.setSeatId(s);
            ett.setTicketId(entity.getTicketId());
            seat.create(ett);
        }
        return "ticket_info";
    }

    public Ticket getEntity() {
        return entity;
    }

    public void setEntity(Ticket entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTicketId() {
        return entity.getTicketId();
    }

    public void setTicketId(Integer ticketId) {
        entity.setTicketId(ticketId);
    }

    public String getStatus() {
        return entity.getStatus();
    }

    public void setStatus(String status) {
        entity.setStatus(status);
    }

    public Date getCreateDay() {
        return entity.getCreateDay();
    }

    public void setCreateDay(Date createDay) {
        entity.setCreateDay(createDay);
    }

    public double getTotal() {
        return entity.getTotal();
    }

    public void setTotal(double total) {
        entity.setTotal(total);
    }

    public Customer getCustomerId() {
        return entity.getCustomerId();
    }

    public void setCustomerId(Customer customerId) {
        entity.setCustomerId(customerId);
    }

    public Event getEventId() {
        return entity.getEventId();
    }

    public void setEventId(Event eventId) {
        entity.setEventId(eventId);
    }

    public SeatReserved getSeatReservedId() {
        return entity.getSeatReservedId();
    }

    public void setSeatReservedId(SeatReserved seatReservedId) {
        entity.setSeatReservedId(seatReservedId);
    }

    public Showtimes getShowtimesId() {
        return entity.getShowtimesId();
    }

    public void setShowtimesId(Showtimes showtimesId) {
        entity.setShowtimesId(showtimesId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSits() {
        return sits;
    }

    public void setSits(String sits) {
        this.sits = sits;
    }

    public TicketStub getStub() {
        return stub;
    }

    public void setStub(TicketStub stub) {
        this.stub = stub;
    }

    public List<String> getLstSeat() {
        return lstSeat;
    }

    public void setLstSeat(List<String> lstSeat) {
        this.lstSeat = lstSeat;
    }

    public String getCurdate() {
        return df.format(new Date());
    }

    public void setCurdate(Date curdate) {
        this.curdate = curdate;
    }

    public List<String> getSeatList() {
        SeatReservedStub stub = new SeatReservedStub();
        List<SeatReserved> list = stub.findAll();
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTicketId() == this.entity.getTicketId()) {
                lst.add(list.get(i).getSeatId().getSeatRow() + list.get(i).getSeatId().getSeatNum());
            }
        }
        return lst;
    }
}
