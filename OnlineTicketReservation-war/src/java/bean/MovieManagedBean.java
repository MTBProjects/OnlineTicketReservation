/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Movie;
import entity.Showtimes;
import stub.MovieStub;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
@ManagedBean (name = "movieBean")
@RequestScoped
public class MovieManagedBean {

    private Movie entity;
    private String message;
    private MovieStub stub = new MovieStub();
    private List<Movie> movies = getAllMovie();
    private String name;

    public MovieManagedBean() {
        entity = new Movie();

    }

    public Movie getMovie() {
        FacesContext f = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) f.getExternalContext().getRequest();
        int value = Integer.parseInt(request.getParameter("movieid"));
        return stub.findById(value);
    }

    public List<Movie> getAllMovie() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    //Check duplicate
    public void isMovieExist() {
        boolean isExist = false;
        for (Movie m : getAllMovie()) {
            if (entity.getMovieName().equals(m.getMovieName())) {
                isExist = true;
            }
        }
        if (isExist) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "This movie has been created",
                    "Please check again"));
        }
    }
    
    //get Movie based on movieID
    public Movie getMovieInfo(int id) {
        entity = stub.findById(id);
        return entity;
    }

    //
    public String selectedMovie(int id) {
        entity = stub.find(id);
        return "editMovie";
    }

    public void deleteMovie(Movie movie) {
        try {
            stub.remove(movie);
            message = "Movie has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public String createMovie() {
        try {
            stub.create(entity);
            message = "New movie has been added";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return "/employee/movie/mainMovie";
    }

    public String updateMovie() {
        try {
            stub.edit(entity);
            message = "Updated";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return "/employee/movie/mainMovie?face-redirect=true";
    }

    public String findMovieSetup() {
        movies = findListName(entity.getMovieName());
        return "searchMovieResult";
    }

    public List<Movie> findListName(String name) {
        try {
            return stub.findListByName(name);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Movie findName(String name){
        try {
            return stub.findByName(name);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public List<Movie> findByName(String name) {
        try {
            return stub.findByKey(name);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }   

    public Movie getEntity() {
        return entity;
    }

    public void setEntity(Movie entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMovieId() {
        return entity.getMovieId();
    }

    public void setMovieId(Integer movieId) {
        entity.setMovieId(movieId);
    }

    public String getMovieName() {
        return entity.getMovieName();
    }

    public void setMovieName(String movieName) {
        entity.setMovieName(movieName);
    }

    public int getYear() {
        return entity.getYear();
    }

    public void setYear(int year) {
        entity.setYear(year);
    }

    public String getDirector() {
        return entity.getDirector();
    }

    public void setDirector(String director) {
        entity.setDirector(director);
    }

    public String getCast() {
        return entity.getCast();
    }

    public void setCast(String cast) {
        entity.setCast(cast);
    }

    public String getShowDatest() {
        return entity.getShowDatest();
    }
    
    public Date getShowDate() {
        return entity.getShowDate();
    }

    public void setShowDate(Date showDate) {
        entity.setShowDate(showDate);
    }

    public String getDescription() {
        return entity.getDescription();
    }

    public void setDescription(String description) {
        entity.setDescription(description);
    }

    public String getMovieType() {
        return entity.getMovieType();
    }

    public void setMovieType(String movieType) {
        entity.setMovieType(movieType);
    }

    public String getStatus() {
        return entity.getStatus();
    }

    public void setStatus(String status) {
        entity.setStatus(status);
    }

    public int getDuration() {
        return entity.getDuration();
    }

    public void setDuration(int duration) {
        entity.setDuration(duration);
    }

    public String getPoster() {
        return entity.getPoster();
    }

    public void setPoster(String poster) {
        entity.setPoster(poster);
    }

    public List<Showtimes> getShowtimesList() {
        return entity.getShowtimesList();
    }

    public void setShowtimesList(List<Showtimes> showtimesList) {
        entity.setShowtimesList(showtimesList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String findIdByName() {
        Movie mov = this.findName(this.name);
        int id = mov.getMovieId();
        return "choose_time.htxml?faces-redirect=true&includeViewParams=true&movieid="+id;
    }
}
