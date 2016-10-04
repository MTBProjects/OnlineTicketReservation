/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Movie;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import service.MovieService;

/**
 *
 * @author PC
 */
@ManagedBean
@ViewScoped
public class movie_list_view implements Serializable {

    private List<Movie> showing;
    private List<Movie> comingSoon;

    @ManagedProperty("#{movieService}")
    private MovieService service;

    @PostConstruct
    public void init() {
        showing = service.createShowingList();
        comingSoon = service.createComingSoonList();
    }

    public List<Movie> getShowing() {
        return showing;
    }

    public List<Movie> getComingSoon() {
        return comingSoon;
    }

    public void setService(MovieService service) {
        this.service = service;
    }

}
