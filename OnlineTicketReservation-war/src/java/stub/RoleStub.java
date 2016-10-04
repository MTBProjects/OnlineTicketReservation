/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Role;
import session.RoleFacadeLocal;
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
public class RoleStub {
    RoleFacadeLocal roleFacade = lookupRoleFacadeLocal();

    private RoleFacadeLocal lookupRoleFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (RoleFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/RoleFacade!session.RoleFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Role role) {
        roleFacade.create(role);
    }

    public void edit(Role role) {
        roleFacade.edit(role);
    }

    public void remove(Role role) {
        roleFacade.remove(role);
    }

    public Role find(Object id) {
        return roleFacade.find(id);
    }

    public List<Role> findAll() {
        return roleFacade.findAll();
    }

    public List<Role> findRange(int[] range) {
        return roleFacade.findRange(range);
    }

    public int count() {
        return roleFacade.count();
    }
    
}
