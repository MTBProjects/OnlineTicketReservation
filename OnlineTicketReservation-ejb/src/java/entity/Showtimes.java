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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "showtimes", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Showtimes.findAll", query = "SELECT s FROM Showtimes s"),
    @NamedQuery(name = "Showtimes.findByShowtimesId", query = "SELECT s FROM Showtimes s WHERE s.showtimesId = :showtimesId"),
    @NamedQuery(name = "Showtimes.findByDate", query = "SELECT s FROM Showtimes s WHERE s.date = :date"),
    @NamedQuery(name = "Showtimes.findByTime", query = "SELECT s FROM Showtimes s WHERE s.time = :time")})
public class Showtimes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "showtimes_id", nullable = false)
    private Integer showtimesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false)
    @ManyToOne(optional = false)
    private Screen screenId;
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false)
    @ManyToOne(optional = false)
    private Movie movieId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showtimesId")
    private List<SeatReserved> seatReservedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showtimesId")
    private List<Ticket> ticketList;

    public Showtimes() {
    }

    public Showtimes(Integer showtimesId) {
        this.showtimesId = showtimesId;
    }

    public Showtimes(Integer showtimesId, Date date) {
        this.showtimesId = showtimesId;
        this.date = date;
    }

    public Integer getShowtimesId() {
        return showtimesId;
    }

    public void setShowtimesId(Integer showtimesId) {
        this.showtimesId = showtimesId;
    }

    public Date getDate() {
        return date;
    }
    
    public String getDatest() {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return date;
    }

    public String getTimest() {
        return new SimpleDateFormat("HH:mm").format(time);
    }
        
    public void setTime(Date time) {
        this.time = time;
    }

    public Screen getScreenId() {
        return screenId;
    }

    public void setScreenId(Screen screenId) {
        this.screenId = screenId;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    @XmlTransient
    public List<SeatReserved> getSeatReservedList() {
        return seatReservedList;
    }

    public void setSeatReservedList(List<SeatReserved> seatReservedList) {
        this.seatReservedList = seatReservedList;
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
        hash += (showtimesId != null ? showtimesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showtimes)) {
            return false;
        }
        Showtimes other = (Showtimes) object;
        if ((this.showtimesId == null && other.showtimesId != null) || (this.showtimesId != null && !this.showtimesId.equals(other.showtimesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Showtimes[ showtimesId=" + showtimesId + " ]";
    }
    
}
