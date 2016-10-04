/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Showtimes;
import session.ShowtimesFacadeLocal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ShowtimesStub {

    ShowtimesFacadeLocal showtimesFacade = lookupShowtimesFacadeLocal();

    private ShowtimesFacadeLocal lookupShowtimesFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ShowtimesFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/ShowtimesFacade!session.ShowtimesFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Showtimes showtimes) {
        showtimesFacade.create(showtimes);
    }

    public void edit(Showtimes showtimes) {
        showtimesFacade.edit(showtimes);
    }

    public void remove(Showtimes showtimes) {
        showtimesFacade.remove(showtimes);
    }

    public Showtimes find(Object id) {
        return showtimesFacade.find(id);
    }

    public List<Showtimes> findAll() {
        return showtimesFacade.findAll();
    }

    public List<Showtimes> findRange(int[] range) {
        return showtimesFacade.findRange(range);
    }

    
    public Showtimes findById(int id){
        return showtimesFacade.findById(id);
    }
    
    public int count() {
        return showtimesFacade.count();
    }
}
