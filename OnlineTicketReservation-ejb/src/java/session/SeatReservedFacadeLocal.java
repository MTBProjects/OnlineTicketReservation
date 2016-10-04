/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.SeatReserved;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface SeatReservedFacadeLocal {

    void create(SeatReserved seatReserved);

    void edit(SeatReserved seatReserved);

    void remove(SeatReserved seatReserved);

    SeatReserved find(Object id);

    List<SeatReserved> findAll();

    List<SeatReserved> findRange(int[] range);

    int count();
    
}
