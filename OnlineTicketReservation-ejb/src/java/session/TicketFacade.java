/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Ticket;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class TicketFacade extends AbstractFacade<Ticket> implements TicketFacadeLocal {
    @PersistenceContext(unitName = "OnlineTicketReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketFacade() {
        super(Ticket.class);
    }

    @Override
    public Ticket findById(int id) {
        return (Ticket) em.createNamedQuery("Ticket.findByTicketId").setParameter("ticketId", id).getSingleResult();
    }
    
}
