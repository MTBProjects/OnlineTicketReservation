/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Ticket;
import session.TicketFacadeLocal;
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
public class TicketStub {
    TicketFacadeLocal ticketFacade = lookupTicketFacadeLocal();

    private TicketFacadeLocal lookupTicketFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TicketFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/TicketFacade!session.TicketFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Ticket ticket) {
        ticketFacade.create(ticket);
    }

    public void edit(Ticket ticket) {
        ticketFacade.edit(ticket);
    }

    public void remove(Ticket ticket) {
        ticketFacade.remove(ticket);
    }

    public Ticket find(Object id) {
        return ticketFacade.find(id);
    }

    public List<Ticket> findAll() {
        return ticketFacade.findAll();
    }

    public List<Ticket> findRange(int[] range) {
        return ticketFacade.findRange(range);
    }

    public int count() {
        return ticketFacade.count();
    }
    
     public Ticket findById(int id) {
        return ticketFacade.findById(id);
    }
}
