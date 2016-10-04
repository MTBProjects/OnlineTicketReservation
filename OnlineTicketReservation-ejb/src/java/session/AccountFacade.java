/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

    @PersistenceContext(unitName = "OnlineTicketReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public List<Account> findAccount(String email, String pass) {
        return em.createNamedQuery("Account.findAccount").setParameter("email", email).setParameter("password", pass).getResultList();
    }

    @Override
    public Account findByEmail(String email) {
        return (Account) em.createNamedQuery("Account.findByEmail").setParameter("email", email).getSingleResult();

    }

    @Override
    public Account findByUsername(String name) {
        return (Account) em.createNamedQuery("Account.findByUsername").setParameter("username", name).getSingleResult();
    }

    @Override
    public List<Account> findListAccount(String user, String pass) {
        return em.createNamedQuery("Account.findAccount").setParameter("username", user).setParameter("password", pass).getResultList();
    }

    @Override
    public Account findSingleAccount(String name, String pass) {
        return (Account) em.createNamedQuery("Account.findAccount").setParameter("username", name).setParameter("password", pass).getSingleResult();
    }

}
