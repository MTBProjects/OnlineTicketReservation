/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Account;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface AccountFacadeLocal {

    void create(Account account);

    void edit(Account account);

    void remove(Account account);

    Account find(Object id);

    List<Account> findAll();

    List<Account> findRange(int[] range);

    int count();

    public List<Account> findAccount(String email, String pass);

    public Account findByEmail(String email);

    public Account findByUsername(String name);

    public List<Account> findListAccount(String name, String pass);

    public Account findSingleAccount(String name, String pass);
    
}
