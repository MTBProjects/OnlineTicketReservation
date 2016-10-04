/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Theatre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class TheatreFacade extends AbstractFacade<Theatre> implements TheatreFacadeLocal {
    @PersistenceContext(unitName = "OnlineTicketReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TheatreFacade() {
        super(Theatre.class);
    }
    
}
