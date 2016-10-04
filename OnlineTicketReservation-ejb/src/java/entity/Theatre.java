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
@Table(name = "theatre", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theatre.findAll", query = "SELECT t FROM Theatre t"),
    @NamedQuery(name = "Theatre.findByTheatreId", query = "SELECT t FROM Theatre t WHERE t.theatreId = :theatreId"),
    @NamedQuery(name = "Theatre.findByTheatreName", query = "SELECT t FROM Theatre t WHERE t.theatreName = :theatreName"),
    @NamedQuery(name = "Theatre.findByTheatreAddress", query = "SELECT t FROM Theatre t WHERE t.theatreAddress = :theatreAddress"),
    @NamedQuery(name = "Theatre.findByScreenNo", query = "SELECT t FROM Theatre t WHERE t.screenNo = :screenNo")})
public class Theatre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "theatre_id", nullable = false)
    private Integer theatreId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "theatre_name", nullable = false, length = 45)
    private String theatreName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "theatre_address", nullable = false, length = 60)
    private String theatreAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "screen_no", nullable = false)
    private int screenNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatreId")
    private List<Screen> screenList;

    public Theatre() {
    }

    public Theatre(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public Theatre(Integer theatreId, String theatreName, String theatreAddress, int screenNo) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreAddress = theatreAddress;
        this.screenNo = screenNo;
    }

    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreAddress() {
        return theatreAddress;
    }

    public void setTheatreAddress(String theatreAddress) {
        this.theatreAddress = theatreAddress;
    }

    public int getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(int screenNo) {
        this.screenNo = screenNo;
    }

    @XmlTransient
    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theatreId != null ? theatreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theatre)) {
            return false;
        }
        Theatre other = (Theatre) object;
        if ((this.theatreId == null && other.theatreId != null) || (this.theatreId != null && !this.theatreId.equals(other.theatreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theatre[ theatreId=" + theatreId + " ]";
    }
    
}
