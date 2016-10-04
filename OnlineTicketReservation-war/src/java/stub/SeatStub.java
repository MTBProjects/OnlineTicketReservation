/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Seat;
import session.SeatFacadeLocal;
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
public class SeatStub {
    SeatFacadeLocal seatFacade = lookupSeatFacadeLocal();

    private SeatFacadeLocal lookupSeatFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (SeatFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/SeatFacade!session.SeatFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Seat seat) {
        seatFacade.create(seat);
    }

    public void edit(Seat seat) {
        seatFacade.edit(seat);
    }

    public void remove(Seat seat) {
        seatFacade.remove(seat);
    }

    public Seat find(Object id) {
        return seatFacade.find(id);
    }

    public List<Seat> findAll() {
        return seatFacade.findAll();
    }

    public List<Seat> findRange(int[] range) {
        return seatFacade.findRange(range);
    }
    
    public Seat findById(int id){
        return seatFacade.findById(id);
    }

    public int count() {
        return seatFacade.count();
    }
    
    
}
