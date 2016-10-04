/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "ticket", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTicketId", query = "SELECT t FROM Ticket t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "Ticket.findByStatus", query = "SELECT t FROM Ticket t WHERE t.status = :status"),
    @NamedQuery(name = "Ticket.findByCreateDay", query = "SELECT t FROM Ticket t WHERE t.createDay = :createDay"),
    @NamedQuery(name = "Ticket.findByTotal", query = "SELECT t FROM Ticket t WHERE t.total = :total")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id", nullable = false)
    private Integer ticketId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status", nullable = false, length = 45)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_day", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total", nullable = false)
    private double total;
    @JoinColumn(name = "showtimes_id", referencedColumnName = "showtimes_id", nullable = false)
    @ManyToOne(optional = false)
    private Showtimes showtimesId;
    @JoinColumn(name = "seat_reserved_id", referencedColumnName = "seat_reserved_id")
    @ManyToOne
    private SeatReserved seatReservedId;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne
    private Event eventId;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerId;

    public Ticket() {
    }

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(Integer ticketId, String status, Date createDay, double total) {
        this.ticketId = ticketId;
        this.status = status;
        this.createDay = createDay;
        this.total = total;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Showtimes getShowtimesId() {
        return showtimesId;
    }

    public void setShowtimesId(Showtimes showtimesId) {
        this.showtimesId = showtimesId;
    }

    public SeatReserved getSeatReservedId() {
        return seatReservedId;
    }

    public void setSeatReservedId(SeatReserved seatReservedId) {
        this.seatReservedId = seatReservedId;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ticket[ ticketId=" + ticketId + " ]";
    }
    
}
