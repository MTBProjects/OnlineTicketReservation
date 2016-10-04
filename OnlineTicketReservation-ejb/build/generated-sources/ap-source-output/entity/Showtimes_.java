package entity;

import entity.Movie;
import entity.Screen;
import entity.SeatReserved;
import entity.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Showtimes.class)
public class Showtimes_ { 

    public static volatile SingularAttribute<Showtimes, Screen> screenId;
    public static volatile SingularAttribute<Showtimes, Date> time;
    public static volatile SingularAttribute<Showtimes, Movie> movieId;
    public static volatile ListAttribute<Showtimes, SeatReserved> seatReservedList;
    public static volatile ListAttribute<Showtimes, Ticket> ticketList;
    public static volatile SingularAttribute<Showtimes, Integer> showtimesId;
    public static volatile SingularAttribute<Showtimes, Date> date;

}