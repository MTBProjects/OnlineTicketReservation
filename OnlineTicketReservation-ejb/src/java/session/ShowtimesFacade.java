/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Showtimes;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class ShowtimesFacade extends AbstractFacade<Showtimes> implements ShowtimesFacadeLocal {

    @PersistenceContext(unitName = "OnlineTicketReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShowtimesFacade() {
        super(Showtimes.class);
    }

    @Override
    public List<Showtimes> findByDate(Date date) {
        return em.createNamedQuery("Showtimes.findByDate").setParameter("date", date).getResultList();
    }

    @Override
    public Showtimes findById(int id) {
        return (Showtimes) em.createNamedQuery("Showtimes.findByShowtimesId").setParameter("showtimesId", id).getSingleResult();
    }
}
