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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "screen", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Screen.findAll", query = "SELECT s FROM Screen s"),
    @NamedQuery(name = "Screen.findByScreenId", query = "SELECT s FROM Screen s WHERE s.screenId = :screenId"),
    @NamedQuery(name = "Screen.findByScreenName", query = "SELECT s FROM Screen s WHERE s.screenName = :screenName"),
    @NamedQuery(name = "Screen.findBySeatNum", query = "SELECT s FROM Screen s WHERE s.seatNum = :seatNum")})
public class Screen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "screen_id", nullable = false)
    private Integer screenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "screen_name", nullable = false, length = 45)
    private String screenName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat_num", nullable = false)
    private int seatNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screenId")
    private List<Showtimes> showtimesList;
    @JoinColumn(name = "theatre_id", referencedColumnName = "theatre_id", nullable = false)
    @ManyToOne(optional = false)
    private Theatre theatreId;

    public Screen() {
    }

    public Screen(Integer screenId) {
        this.screenId = screenId;
    }

    public Screen(Integer screenId, String screenName, int seatNum) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.seatNum = seatNum;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    @XmlTransient
    public List<Showtimes> getShowtimesList() {
        return showtimesList;
    }

    public void setShowtimesList(List<Showtimes> showtimesList) {
        this.showtimesList = showtimesList;
    }

    public Theatre getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Theatre theatreId) {
        this.theatreId = theatreId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (screenId != null ? screenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Screen)) {
            return false;
        }
        Screen other = (Screen) object;
        if ((this.screenId == null && other.screenId != null) || (this.screenId != null && !this.screenId.equals(other.screenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Screen[ screenId=" + screenId + " ]";
    }
    
}
