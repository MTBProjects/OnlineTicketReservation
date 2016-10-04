/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Account;
import session.AccountFacadeLocal;
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
public class AccountStub {
    AccountFacadeLocal accountFacade = lookupAccountFacadeLocal();

    private AccountFacadeLocal lookupAccountFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (AccountFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/AccountFacade!session.AccountFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Account account) {
        accountFacade.create(account);
    }

    public void edit(Account account) {
        accountFacade.edit(account);
    }

    public void remove(Account account) {
        accountFacade.remove(account);
    }

    public Account find(Object id) {
        return accountFacade.find(id);
    }
    
    public Account findByUsername(String name) {
        return accountFacade.findByUsername(name);
    }

    public List<Account> findAll() {
        return accountFacade.findAll();
    }

    public List<Account> findRange(int[] range) {
        return accountFacade.findRange(range);
    }
    
    public List<Account> findListAccount(String name, String pass) {
        return accountFacade.findListAccount(name, pass);

    }

    public Account findSingleAccount(String name, String pass) {
        return accountFacade.findSingleAccount(name, pass);
    }
    
    public Account findByEmail(String email){
        return accountFacade.findByEmail(email);
    }

    public int count() {
        return accountFacade.count();
    }

}
