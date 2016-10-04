package entity;

import entity.SeatReserved;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Seat.class)
public class Seat_ { 

    public static volatile SingularAttribute<Seat, Integer> price;
    public static volatile ListAttribute<Seat, SeatReserved> seatReservedList;
    public static volatile SingularAttribute<Seat, String> seatRow;
    public static volatile SingularAttribute<Seat, Integer> seatId;
    public static volatile SingularAttribute<Seat, Integer> seatNum;

}