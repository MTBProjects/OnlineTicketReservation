/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Customer;
import session.CustomerFacadeLocal;
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
public class CustomerStub {
    CustomerFacadeLocal customerFacade = lookupCustomerFacadeLocal();

    private CustomerFacadeLocal lookupCustomerFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomerFacadeLocal) c.lookup("java:global/OnlineTicketReservation/OnlineTicketReservation-ejb/CustomerFacade!session.CustomerFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Customer customer) {
        customerFacade.create(customer);
    }

    public void edit(Customer customer) {
        customerFacade.edit(customer);
    }

    public void remove(Customer customer) {
        customerFacade.remove(customer);
    }

    public Customer find(Object id) {
        return customerFacade.find(id);
    }

    public List<Customer> findAll() {
        return customerFacade.findAll();
    }

    public List<Customer> findRange(int[] range) {
        return customerFacade.findRange(range);
    }

    public int count() {
        return customerFacade.count();
    }
    
    public List<Customer> findCustomer(String email, String pass) {
        return customerFacade.findCustomer(email,pass);
    }
    
    public Customer findByEmail(String email){
        return customerFacade.findByEmail(email);
    }
}
