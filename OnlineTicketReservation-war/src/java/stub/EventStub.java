/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Event;
import session.EventFacadeLocal;
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
public class EventStub {
    EventFacadeLocal eventFacade = lookupEventFacadeLocal();

    private EventFacadeLocal lookupEventFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (EventFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/EventFacade!session.EventFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Event event) {
        eventFacade.create(event);
    }

    public void edit(Event event) {
        eventFacade.edit(event);
    }

    public void remove(Event event) {
        eventFacade.remove(event);
    }

    public Event find(Object id) {
        return eventFacade.find(id);
    }

    public List<Event> findAll() {
        return eventFacade.findAll();
    }

    public List<Event> findRange(int[] range) {
        return eventFacade.findRange(range);
    }

    public int count() {
        return eventFacade.count();
    }
    
    
}
