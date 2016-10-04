/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Movie;
import stub.MovieStub;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author PC
 */
@ManagedBean (name= "movieService")
@ApplicationScoped
public class MovieService {

    String status;
    public List<Movie> createShowingList() {
        status = "showing";
        MovieStub stub = new MovieStub();
        return stub.findByStatus(status);
    }
    
    public List<Movie> createComingSoonList() {
        status = "comingsoon";
        MovieStub stub = new MovieStub();
        return stub.findByStatus(status);
    }
    
}
