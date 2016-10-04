/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Theatre;
import session.TheatreFacadeLocal;
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
public class TheatreStub {
    TheatreFacadeLocal theatreFacade = lookupTheatreFacadeLocal();

    private TheatreFacadeLocal lookupTheatreFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TheatreFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/TheatreFacade!session.TheatreFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Theatre theatre) {
        theatreFacade.create(theatre);
    }

    public void edit(Theatre theatre) {
        theatreFacade.edit(theatre);
    }

    public void remove(Theatre theatre) {
        theatreFacade.remove(theatre);
    }

    public Theatre find(Object id) {
        return theatreFacade.find(id);
    }

    public List<Theatre> findAll() {
        return theatreFacade.findAll();
    }

    public List<Theatre> findRange(int[] range) {
        return theatreFacade.findRange(range);
    }

    public int count() {
        return theatreFacade.count();
    }
    
}
