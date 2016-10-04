/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Showtimes;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface ShowtimesFacadeLocal {

    void create(Showtimes showtimes);

    void edit(Showtimes showtimes);

    void remove(Showtimes showtimes);

    Showtimes find(Object id);

    List<Showtimes> findAll();

    List<Showtimes> findRange(int[] range);
    
    public List<Showtimes> findByDate(Date date);
    
    public Showtimes findById(int id);

    int count();
    
}
