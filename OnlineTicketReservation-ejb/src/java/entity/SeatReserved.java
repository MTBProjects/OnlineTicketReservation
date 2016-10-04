/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "seat_reserved", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeatReserved.findAll", query = "SELECT s FROM SeatReserved s"),
    @NamedQuery(name = "SeatReserved.findBySeatReservedId", query = "SELECT s FROM SeatReserved s WHERE s.seatReservedId = :seatReservedId"),
    @NamedQuery(name = "SeatReserved.findByTicketId", query = "SELECT s FROM SeatReserved s WHERE s.ticketId = :ticketId")})
public class SeatReserved implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seat_reserved_id", nullable = false)
    private Integer seatReservedId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticket_id", nullable = false)
    private int ticketId;
    @JoinColumn(name = "showtimes_id", referencedColumnName = "showtimes_id", nullable = false)
    @ManyToOne(optional = false)
    private Showtimes showtimesId;
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id", nullable = false)
    @ManyToOne(optional = false)
    private Seat seatId;
    @OneToMany(mappedBy = "seatReservedId")
    private List<Ticket> ticketList;

    public SeatReserved() {
    }

    public SeatReserved(Integer seatReservedId) {
        this.seatReservedId = seatReservedId;
    }

    public SeatReserved(Integer seatReservedId, int ticketId) {
        this.seatReservedId = seatReservedId;
        this.ticketId = ticketId;
    }

    public Integer getSeatReservedId() {
        return seatReservedId;
    }

    public void setSeatReservedId(Integer seatReservedId) {
        this.seatReservedId = seatReservedId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Showtimes getShowtimesId() {
        return showtimesId;
    }

    public void setShowtimesId(Showtimes showtimesId) {
        this.showtimesId = showtimesId;
    }

    public Seat getSeatId() {
        return seatId;
    }

    public void setSeatId(Seat seatId) {
        this.seatId = seatId;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatReservedId != null ? seatReservedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeatReserved)) {
            return false;
        }
        SeatReserved other = (SeatReserved) object;
        if ((this.seatReservedId == null && other.seatReservedId != null) || (this.seatReservedId != null && !this.seatReservedId.equals(other.seatReservedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SeatReserved[ seatReservedId=" + seatReservedId + " ]";
    }
    
}
