/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Seat;
import java.util.ArrayList;
import java.util.List;
import stub.SeatStub;

/**
 *
 * @author PC
 */
public class SeatMap {
    String name;
    int id;
    List<SeatMap> lstSeatMap = new ArrayList<>();

    public SeatMap() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public SeatMap(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public List<SeatMap> createSeatMap(){
        SeatStub stub = new SeatStub();
        List<Seat> lst = stub.findAll();
        for (int i = 0; i < lst.size(); i++) {
            lstSeatMap.add( new SeatMap(i,lst.get(i).getSeatRow()+lst.get(i).getSeatNum()));
        }
        return lstSeatMap;
    }
    
    public int findId(String name){
        int id = -1;
        for (int i = 0; i < lstSeatMap.size(); i++) {
            if(lstSeatMap.get(i).getName().equals(name)){
                id = i;
            }
        }
        return id;
    }
}
