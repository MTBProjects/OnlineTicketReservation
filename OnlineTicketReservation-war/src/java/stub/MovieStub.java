/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Movie;
import session.MovieFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class MovieStub {

    MovieFacadeLocal movieFacade = lookupMovieFacadeLocal();

    private MovieFacadeLocal lookupMovieFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (MovieFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/MovieFacade!session.MovieFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Movie movie) {
        movieFacade.create(movie);
    }

    public void edit(Movie movie) {
        movieFacade.edit(movie);
    }

    public void remove(Movie movie) {
        movieFacade.remove(movie);
    }

    public Movie find(Object id) {
        return movieFacade.find(id);
    }

    public List<Movie> findAll() {
        return movieFacade.findAll();
    }

    public List<Movie> findRange(int[] range) {
        return movieFacade.findRange(range);
    }

    public List<Movie> findListByName(String name) {
        return movieFacade.findListByName(name);
    }

    public Movie findByName(String name) {
        return movieFacade.findByName(name);
    }
    
    public List<Movie> findByStatus(String status) {
        return movieFacade.findByStatus(status);
    }
    
    public Movie findById (int id){
        return movieFacade.findById(id);
    }
    
    public int count() {
        return movieFacade.count();
    }
    
    public List<Movie> findByKey(String name) {
        return movieFacade.findByKey("%" + name + "%");
    }

}
