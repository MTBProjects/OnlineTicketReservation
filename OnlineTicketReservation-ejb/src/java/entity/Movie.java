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
import javax.persistence.Lob;
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
@Table(name = "movie", catalog = "online_ticket_booking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieId", query = "SELECT m FROM Movie m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "Movie.findByMovieName", query = "SELECT m FROM Movie m WHERE m.movieName = :movieName"),
    @NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year = :year"),
    @NamedQuery(name = "Movie.findByDirector", query = "SELECT m FROM Movie m WHERE m.director = :director"),
    @NamedQuery(name = "Movie.findByCast", query = "SELECT m FROM Movie m WHERE m.cast = :cast"),
    @NamedQuery(name = "Movie.findByShowDate", query = "SELECT m FROM Movie m WHERE m.showDate = :showDate"),
    @NamedQuery(name = "Movie.findByMovieType", query = "SELECT m FROM Movie m WHERE m.movieType = :movieType"),
    @NamedQuery(name = "Movie.findByStatus", query = "SELECT m FROM Movie m WHERE m.status = :status"),
    @NamedQuery(name = "Movie.findByDuration", query = "SELECT m FROM Movie m WHERE m.duration = :duration"),
    @NamedQuery(name = "Movie.findByKeyword", query = "SELECT m FROM Movie m WHERE m.movieName LIKE :keyword"),
    @NamedQuery(name = "Movie.findByPoster", query = "SELECT m FROM Movie m WHERE m.poster = :poster")})
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "movie_name", nullable = false, length = 60)
    private String movieName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year", nullable = false)
    private int year;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "director", nullable = false, length = 45)
    private String director;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cast", nullable = false, length = 60)
    private String cast;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date showDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "description", nullable = false, length = 16777215)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "movie_type", nullable = false, length = 45)
    private String movieType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status", nullable = false, length = 45)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration", nullable = false)
    private int duration;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "poster", nullable = false, length = 255)
    private String poster;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieId")
    private List<Showtimes> showtimesList;

    public Movie() {
    }

    public Movie(Integer movieId) {
        this.movieId = movieId;
    }

    public Movie(Integer movieId, String movieName, int year, String director, String cast, Date showDate, String description, String movieType, String status, int duration, String poster) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.year = year;
        this.director = director;
        this.cast = cast;
        this.showDate = showDate;
        this.description = description;
        this.movieType = movieType;
        this.status = status;
        this.duration = duration;
        this.poster = poster;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getShowDatest() {
        return new SimpleDateFormat("dd/MM/yyyy").format(showDate);
    }
    
    public Date getShowDate() {
        return showDate ;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @XmlTransient
    public List<Showtimes> getShowtimesList() {
        return showtimesList;
    }

    public void setShowtimesList(List<Showtimes> showtimesList) {
        this.showtimesList = showtimesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movie[ movieId=" + movieId + " ]";
    }
    
}
