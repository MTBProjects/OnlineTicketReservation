/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class MovieFacade extends AbstractFacade<Movie> implements MovieFacadeLocal {
    @PersistenceContext(unitName = "OnlineTicketReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovieFacade() {
        super(Movie.class);
    }
    
    @Override
    public List<Movie> findListByName(String name) {
        return em.createNamedQuery("Movie.findByMovieName").setParameter("movieName", name).getResultList();
    }
    
    @Override
    public Movie findByName(String name) {
        return (Movie)em.createNamedQuery("Movie.findByMovieName").setParameter("movieName", name).getSingleResult();
    }

    @Override
    public List<Movie> findByStatus(String status) {
        return em.createNamedQuery("Movie.findByStatus").setParameter("status", status).getResultList();

    }

    @Override
    public Movie findById(int id) {
        return (Movie) em.createNamedQuery("Movie.findByMovieId").setParameter("movieId", id).getSingleResult();
    }

    @Override
    public List<Movie> findByKey(String name) {
        return em.createNamedQuery("Movie.findByKeyword").setParameter("keyword", name).getResultList();
    }
}
