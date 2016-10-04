package entity;

import entity.Customer;
import entity.Event;
import entity.SeatReserved;
import entity.Showtimes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Double> total;
    public static volatile SingularAttribute<Ticket, Integer> ticketId;
    public static volatile SingularAttribute<Ticket, Customer> customerId;
    public static volatile SingularAttribute<Ticket, Event> eventId;
    public static volatile SingularAttribute<Ticket, String> status;
    public static volatile SingularAttribute<Ticket, SeatReserved> seatReservedId;
    public static volatile SingularAttribute<Ticket, Showtimes> showtimesId;
    public static volatile SingularAttribute<Ticket, Date> createDay;

}