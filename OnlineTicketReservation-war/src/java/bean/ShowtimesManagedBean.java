/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Movie;
import entity.Screen;
import entity.Showtimes;
import entity.Ticket;
import stub.ShowtimesStub;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "showtimeBean")
@SessionScoped
public class ShowtimesManagedBean implements Serializable {

    private Showtimes entity;
    private String message;
    private ShowtimesStub stub = new ShowtimesStub();
    List<String> lst = new ArrayList<String>();
    private List<String> availableTime;
    private Date date;
    private String day;
    private String stime;
    private int id;

    public ShowtimesManagedBean() {
        entity = new Showtimes();
        FacesContext f = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) f.getExternalContext().getRequest();
        if (request.getParameter("movieid") != null) {
            id = Integer.parseInt(request.getParameter("movieid"));
        }
    }

    @PostConstruct
    public void init() {
        availableTime = new ArrayList<String>();
        availableTime.add("09:30:00");
        availableTime.add("10:30:00");
        availableTime.add("11:30:00");
        availableTime.add("12:30:00");
        availableTime.add("13:30:00");
        availableTime.add("14:30:00");
        availableTime.add("15:30:00");
        availableTime.add("16:30:00");
        availableTime.add("17:30:00");
        availableTime.add("18:30:00");
        availableTime.add("19:30:00");
        availableTime.add("20:30:00");
        availableTime.add("21:30:00");
        availableTime.add("22:30:00");
    }

    private void reset() {
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            session.invalidate();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Showtimes> getAllShowtimes() {
        try {
            return stub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteShowtimes(Showtimes st) {
        try {
            stub.remove(st);
            message = "Showtimes has been deleted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public void createShowtimes() {
        try {
            stub.create(entity);
            FacesMessage mess = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Successful create",
                    "Close pop-up to continue");
            RequestContext.getCurrentInstance().showMessageInDialog(mess);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
    }

    public String editShowtimesSetup(int id) {
        try {
            entity = stub.find(id);
            return "editShowtimes";
        } catch (Exception e) {
            message = e.getMessage();
            return null;
        }
    }

    public String selectedShowtime(int id) {
        entity = stub.find(id);
        return "editShowtime";
    }

    public String updateShowtimes() {
        try {
            stub.edit(entity);
        } catch (Exception e) {

        }
        return "mainShowtime?faces-redirect=true";
    }

    public Showtimes getEntity() {
        return entity;
    }

    public void setEntity(Showtimes entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getShowtimesId() {
        return entity.getShowtimesId();
    }

    public void setShowtimesId(Integer showtimesId) {
        entity.setShowtimesId(showtimesId);
    }

    public String getTime() {
        return entity.getTimest();
    }

    public void setTime(Date time) {
        entity.setTime(time);
    }

    public List<Ticket> getTicketList() {
        return entity.getTicketList();
    }

    public void setTicketList(List<Ticket> ticketList) {
        entity.setTicketList(ticketList);
    }

    public Movie getMovieId() {
        return entity.getMovieId();
    }

    public void setMovieId(Movie movieId) {
        entity.setMovieId(movieId);
    }

    public Screen getScreenId() {
        return entity.getScreenId();
    }

    public void setScreenId(Screen screenId) {
        entity.setScreenId(screenId);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(List<String> availableTime) {
        this.availableTime = availableTime;
    }

    public List<String> getDateList() {

        lst.clear();
        List<Showtimes> temp = this.getAllShowtimes();
        Date curdate = new Date();
        for (Showtimes temp1 : temp) {
            if ((!lst.contains(temp1.getDatest())) && (temp1.getMovieId().getMovieId() == id)) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date stDate;
                Date stTime;
                try {
                    stDate = df.parse(temp1.getDatest() + " 23:59:59");
                    if (stDate.compareTo(curdate) > 0) {
                        stTime = df.parse(temp1.getDatest() + " " + temp1.getTimest() + ":00");
                        if (stTime.compareTo(curdate) > 0) {
                            lst.add(temp1.getDatest());
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ShowtimesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        Collections.sort(lst);
        return lst;
    }

    public List<String> getTimeList(String date) {

        List<String> lst2 = new ArrayList<String>();
        List<Showtimes> listSt = stub.findAll();
        List<Showtimes> list = new ArrayList<>();
        for (int i = 0; i < listSt.size(); i++) {
            String sdate = listSt.get(i).getDatest();
            if (sdate.equals(date)) {
                if (!list.contains(sdate)) {
                    list.add(listSt.get(i));
                }
            }
        }

        Date curdate = new Date();
        for (Showtimes list1 : list) {
            if (list1.getMovieId().getMovieId() == id) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date stDate;
                try {
                    stDate = df.parse(date + " " + list1.getTimest() + ":00");
                    if (stDate.compareTo(curdate) > 0) {
                        lst2.add(list1.getTimest());
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ShowtimesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        Collections.sort(lst2);
        return lst2;
    }

    public String submit() {
        int stId = 0;
        List<Showtimes> stLst = this.getAllShowtimes();
        for (Showtimes stLst1 : stLst) {
            if (stLst1.getMovieId().getMovieId() == id && stLst1.getTimest().equals(stime)) {
                stId = stLst1.getShowtimesId();
            }
        }
//        try {
//            reset();
//        } catch (NullPointerException ex) {
//            throw ex;
//        }
        return "choose_seat?faces-redirect=true&includeViewParams=true&stid=" + stId;
    }
}
