package entity;

import entity.Showtimes;
import entity.Theatre;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Screen.class)
public class Screen_ { 

    public static volatile SingularAttribute<Screen, Integer> screenId;
    public static volatile ListAttribute<Screen, Showtimes> showtimesList;
    public static volatile SingularAttribute<Screen, String> screenName;
    public static volatile SingularAttribute<Screen, Theatre> theatreId;
    public static volatile SingularAttribute<Screen, Integer> seatNum;

}