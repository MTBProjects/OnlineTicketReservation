/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "OnlineTicketReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findCustomer(String email, String pass) {
        return em.createNamedQuery("Customer.findCustomer").setParameter("email", email).setParameter("password", pass).getResultList();
    }

    @Override
    public Customer findByEmail(String email) {
        return (Customer) em.createNamedQuery("Customer.findByEmail").setParameter("email", email).getSingleResult();
    }

}
