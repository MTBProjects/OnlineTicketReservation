/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Screen;
import session.ScreenFacadeLocal;
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
public class ScreenStub {
    ScreenFacadeLocal screenFacade = lookupScreenFacadeLocal();

    private ScreenFacadeLocal lookupScreenFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ScreenFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/ScreenFacade!session.ScreenFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Screen screen) {
        screenFacade.create(screen);
    }

    public void edit(Screen screen) {
        screenFacade.edit(screen);
    }

    public void remove(Screen screen) {
        screenFacade.remove(screen);
    }

    public Screen find(Object id) {
        return screenFacade.find(id);
    }

    public List<Screen> findAll() {
        return screenFacade.findAll();
    }

    public List<Screen> findRange(int[] range) {
        return screenFacade.findRange(range);
    }

    public int count() {
        return screenFacade.count();
    }

    public Screen findById(int id) {
        return screenFacade.findById(id);
    }
}
