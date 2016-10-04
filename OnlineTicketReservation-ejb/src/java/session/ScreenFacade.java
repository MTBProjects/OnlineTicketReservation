/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Screen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class ScreenFacade extends AbstractFacade<Screen> implements ScreenFacadeLocal {
    @PersistenceContext(unitName = "OnlineTicketReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ScreenFacade() {
        super(Screen.class);
    }

    @Override
    public Screen findById(int id) {
        return (Screen) em.createNamedQuery("Screen.findByScreenId").setParameter("screenId", id).getSingleResult();
    }
    
}
