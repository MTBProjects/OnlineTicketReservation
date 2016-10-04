/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Theatre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface TheatreFacadeLocal {

    void create(Theatre theatre);

    void edit(Theatre theatre);

    void remove(Theatre theatre);

    Theatre find(Object id);

    List<Theatre> findAll();

    List<Theatre> findRange(int[] range);

    int count();
    
}
