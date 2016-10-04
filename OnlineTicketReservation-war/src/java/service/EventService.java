/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Event;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import stub.EventStub;

/**
 *
 * @author PC
 */
@ManagedBean (name = "eventService")
@ApplicationScoped
public class EventService {

    public List<Event> createEventList() {
        EventStub stub = new EventStub();
        return stub.findAll();
    }
    
}
