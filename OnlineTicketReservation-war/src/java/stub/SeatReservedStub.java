/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.SeatReserved;
import session.SeatReservedFacadeLocal;
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
public class SeatReservedStub {
    SeatReservedFacadeLocal seatReservedFacade = lookupSeatReservedFacadeLocal();

    private SeatReservedFacadeLocal lookupSeatReservedFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (SeatReservedFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/SeatReservedFacade!session.SeatReservedFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(SeatReserved seatReserved) {
        seatReservedFacade.create(seatReserved);
    }

    public void edit(SeatReserved seatReserved) {
        seatReservedFacade.edit(seatReserved);
    }

    public void remove(SeatReserved seatReserved) {
        seatReservedFacade.remove(seatReserved);
    }

    public SeatReserved find(Object id) {
        return seatReservedFacade.find(id);
    }

    public List<SeatReserved> findAll() {
        return seatReservedFacade.findAll();
    }

    public List<SeatReserved> findRange(int[] range) {
        return seatReservedFacade.findRange(range);
    }

    public int count() {
        return seatReservedFacade.count();
    }
    
    
}
