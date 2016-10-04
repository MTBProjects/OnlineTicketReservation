/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Event;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import service.EventService;

/**
 *
 * @author PC
 */
@ManagedBean
@ViewScoped
public class event_list_view implements Serializable {

    private List<Event> ev;

    @ManagedProperty("#{eventService}")
    private EventService service;

    public List<Event> getEv() {
        return ev;
    }

    public EventService getService() {
        return service;
    }

    
}
