package entity;

import entity.Seat;
import entity.Showtimes;
import entity.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(SeatReserved.class)
public class SeatReserved_ { 

    public static volatile SingularAttribute<SeatReserved, Integer> ticketId;
    public static volatile ListAttribute<SeatReserved, Ticket> ticketList;
    public static volatile SingularAttribute<SeatReserved, Integer> seatReservedId;
    public static volatile SingularAttribute<SeatReserved, Seat> seatId;
    public static volatile SingularAttribute<SeatReserved, Showtimes> showtimesId;

}