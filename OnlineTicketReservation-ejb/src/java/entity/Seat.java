/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "seat", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s"),
    @NamedQuery(name = "Seat.findBySeatId", query = "SELECT s FROM Seat s WHERE s.seatId = :seatId"),
    @NamedQuery(name = "Seat.findBySeatNum", query = "SELECT s FROM Seat s WHERE s.seatNum = :seatNum"),
    @NamedQuery(name = "Seat.findBySeatRow", query = "SELECT s FROM Seat s WHERE s.seatRow = :seatRow"),
    @NamedQuery(name = "Seat.findByPrice", query = "SELECT s FROM Seat s WHERE s.price = :price")})
public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seat_id", nullable = false)
    private Integer seatId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat_num", nullable = false)
    private int seatNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "seat_row", nullable = false, length = 10)
    private String seatRow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private int price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seatId")
    private List<SeatReserved> seatReservedList;

    public Seat() {
    }

    public Seat(Integer seatId) {
        this.seatId = seatId;
    }

    public Seat(Integer seatId, int seatNum, String seatRow, int price) {
        this.seatId = seatId;
        this.seatNum = seatNum;
        this.seatRow = seatRow;
        this.price = price;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @XmlTransient
    public List<SeatReserved> getSeatReservedList() {
        return seatReservedList;
    }

    public void setSeatReservedList(List<SeatReserved> seatReservedList) {
        this.seatReservedList = seatReservedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatId != null ? seatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.seatId == null && other.seatId != null) || (this.seatId != null && !this.seatId.equals(other.seatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Seat[ seatId=" + seatId + " ]";
    }
    
}
