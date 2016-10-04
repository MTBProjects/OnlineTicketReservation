/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Seat;
import entity.SeatReserved;
import stub.SeatStub;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import service.SeatList;
import stub.SeatReservedStub;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class SeatManagedBean {

    private Seat entity;
    private String message;
    private SeatStub stubS = new SeatStub();
    private SeatReservedStub stubSR = new SeatReservedStub();
    private List<SeatList> sA = new ArrayList<>();
    private List<SeatList> sB = new ArrayList<>();
    private List<SeatList> sC = new ArrayList<>();
    private List<SeatList> sD = new ArrayList<>();
    private List<SeatList> sE = new ArrayList<>();
    private List<SeatList> sF = new ArrayList<>();
    private List<SeatList> sG = new ArrayList<>();
    private List<SeatList> sI = new ArrayList<>();
    private List<SeatList> sJ = new ArrayList<>();
    private List<SeatList> sK = new ArrayList<>();
    private List<SeatList> sL = new ArrayList<>();
    private final List<Seat> seat = stubS.findAll();
    private List<SeatReserved> seatR = stubSR.findAll();
    private List<String> seatRS = new ArrayList<>();
    private int status;
    private int stId;
    int id;

    public SeatManagedBean() {
        FacesContext f = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) f.getExternalContext().getRequest();
        if (request.getParameter("stid") != null) {
            id = Integer.parseInt(request.getParameter("stid"));
        }
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("stid", id);
        stId = id;

        for (SeatReserved seatR1 : seatR) {
            if (seatR1.getShowtimesId().getShowtimesId() == id) {
                seatRS.add(seatR1.getSeatId().getSeatRow() + seatR1.getSeatId().getSeatNum());
            }
        }
        for (Seat seat1 : seat) {
            if (seatRS.size() > 0) {
                String name = seat1.getSeatRow() + seat1.getSeatNum();
                status = 0;
                for (String seatRS1 : seatRS) {
                    if (seatRS1.equalsIgnoreCase(name)) {
                        status = 1;
                    }
                }
                switch (seat1.getSeatRow()) {
                    case "A":
                        sA.add(new SeatList(name, status));
                        break;
                    case "B":
                        sB.add(new SeatList(name, status));
                        break;
                    case "C":
                        sC.add(new SeatList(name, status));
                        break;
                    case "D":
                        sD.add(new SeatList(name, status));
                        break;
                    case "E":
                        sE.add(new SeatList(name, status));
                        break;
                    case "F":
                        sF.add(new SeatList(name, status));
                        break;
                    case "G":
                        sG.add(new SeatList(name, status));
                        break;
                    case "I":
                        sI.add(new SeatList(name, status));
                        break;
                    case "J":
                        sJ.add(new SeatList(name, status));
                        break;
                    case "K":
                        sK.add(new SeatList(name, status));
                        break;
                    case "L":
                        sL.add(new SeatList(name, status));
                        break;
                }
            } else {
                String name = seat1.getSeatRow() + seat1.getSeatNum();
                switch (seat1.getSeatRow()) {
                    case "A":
                        sA.add(new SeatList(name, status));
                        break;
                    case "B":
                        sB.add(new SeatList(name, status));
                        break;
                    case "C":
                        sC.add(new SeatList(name, status));
                        break;
                    case "D":
                        sD.add(new SeatList(name, status));
                        break;
                    case "E":
                        sE.add(new SeatList(name, status));
                        break;
                    case "F":
                        sF.add(new SeatList(name, status));
                        break;
                    case "G":
                        sG.add(new SeatList(name, status));
                        break;
                    case "I":
                        sI.add(new SeatList(name, status));
                        break;
                    case "J":
                        sJ.add(new SeatList(name, status));
                        break;
                    case "K":
                        sK.add(new SeatList(name, status));
                        break;
                    case "L":
                        sL.add(new SeatList(name, status));
                        break;
                }
            }
        }
    }

    public List<Seat> getAllSeats() {
        try {
            return stubS.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteSeat(Seat seat) {
        try {
            stubS.remove(seat);
            message = "Seat has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public void createSeat() {
        try {
            stubS.create(entity);
            message = "New seat has been added";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public String editSeatSetup(int id) {
        try {
            entity = stubS.find(id);
            return "editSeat";
        } catch (Exception e) {
            message = e.getMessage();
            return null;
        }
    }

    public String updateSeat() {
        try {
            stubS.edit(entity);
        } catch (Exception e) {

        }
        return "index";
    }

    public Seat getEntity() {
        return entity;
    }

    public void setEntity(Seat entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSeatId() {
        return entity.getSeatId();
    }

    public void setSeatId(Integer seatId) {
        entity.setSeatId(seatId);
    }

    public int getSeatNum() {
        return entity.getSeatNum();
    }

    public void setSeatNum(int seatNum) {
        entity.setSeatNum(seatNum);
    }

    public String getSeatRow() {
        return entity.getSeatRow();
    }

    public void setSeatRow(String seatRow) {
        entity.setSeatRow(seatRow);
    }

    public int getPrice() {
        return entity.getPrice();
    }

    public void setPrice(int price) {
        entity.setPrice(price);
    }

    public List<SeatReserved> getSeatReservedList() {
        return entity.getSeatReservedList();
    }

    public void setSeatReservedList(List<SeatReserved> seatReservedList) {
        entity.setSeatReservedList(seatReservedList);
    }

    public SeatStub getStub() {
        return stubS;
    }

    public SeatStub getStubS() {
        return stubS;
    }

    public void setStubS(SeatStub stubS) {
        this.stubS = stubS;
    }

    public SeatReservedStub getStubSR() {
        return stubSR;
    }

    public void setStubSR(SeatReservedStub stubSR) {
        this.stubSR = stubSR;
    }

    public List<SeatReserved> getSeatR() {
        return seatR;
    }

    public void setSeatR(List<SeatReserved> seatR) {
        this.seatR = seatR;
    }

    public List<String> getSeatRS() {
        return seatRS;
    }

    public void setSeatRS(List<String> seatRS) {
        this.seatRS = seatRS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SeatList> getsA() {
        return sA;
    }

    public void setsA(List<SeatList> sA) {
        this.sA = sA;
    }

    public List<SeatList> getsB() {
        return sB;
    }

    public void setsB(List<SeatList> sB) {
        this.sB = sB;
    }

    public List<SeatList> getsC() {
        return sC;
    }

    public void setsC(List<SeatList> sC) {
        this.sC = sC;
    }

    public List<SeatList> getsD() {
        return sD;
    }

    public void setsD(List<SeatList> sD) {
        this.sD = sD;
    }

    public List<SeatList> getsE() {
        return sE;
    }

    public void setsE(List<SeatList> sE) {
        this.sE = sE;
    }

    public List<SeatList> getsF() {
        return sF;
    }

    public void setsF(List<SeatList> sF) {
        this.sF = sF;
    }

    public List<SeatList> getsG() {
        return sG;
    }

    public void setsG(List<SeatList> sG) {
        this.sG = sG;
    }

    public List<SeatList> getsI() {
        return sI;
    }

    public void setsI(List<SeatList> sI) {
        this.sI = sI;
    }

    public List<SeatList> getsJ() {
        return sJ;
    }

    public void setsJ(List<SeatList> sJ) {
        this.sJ = sJ;
    }

    public List<SeatList> getsK() {
        return sK;
    }

    public void setsK(List<SeatList> sK) {
        this.sK = sK;
    }

    public List<SeatList> getsL() {
        return sL;
    }

    public void setsL(List<SeatList> sL) {
        this.sL = sL;
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public int getIdAgain() {
        FacesContext f = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) f.getExternalContext().getRequest();
        id = Integer.parseInt(request.getParameter("stid"));
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("stid", id);
        return id;
    }
}
