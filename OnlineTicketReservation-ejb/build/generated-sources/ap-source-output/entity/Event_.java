package entity;

import entity.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Integer> eventId;
    public static volatile SingularAttribute<Event, Date> endDay;
    public static volatile ListAttribute<Event, Ticket> ticketList;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, Date> startDay;
    public static volatile SingularAttribute<Event, String> eventTitle;

}