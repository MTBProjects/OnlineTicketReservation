/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "event", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Event.findByEventTitle", query = "SELECT e FROM Event e WHERE e.eventTitle = :eventTitle"),
    @NamedQuery(name = "Event.findByDescription", query = "SELECT e FROM Event e WHERE e.description = :description"),
    @NamedQuery(name = "Event.findByStartDay", query = "SELECT e FROM Event e WHERE e.startDay = :startDay"),
    @NamedQuery(name = "Event.findByEndDay", query = "SELECT e FROM Event e WHERE e.endDay = :endDay")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id", nullable = false)
    private Integer eventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "event_title", nullable = false, length = 60)
    private String eventTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_day", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_day", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDay;
    @OneToMany(mappedBy = "eventId")
    private List<Ticket> ticketList;

    public Event() {
    }

    public Event(Integer eventId) {
        this.eventId = eventId;
    }

    public Event(Integer eventId, String eventTitle, String description, Date startDay, Date endDay) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.description = description;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDay() {
        return startDay;
    }
    
    public String getStartDaySt(){
        return new SimpleDateFormat("dd/MM/yyyy").format(startDay);
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }
    
    public String getEndDaySt(){
        return new SimpleDateFormat("dd/MM/yyyy").format(endDay);
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
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
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Event[ eventId=" + eventId + " ]";
    }
    
}
