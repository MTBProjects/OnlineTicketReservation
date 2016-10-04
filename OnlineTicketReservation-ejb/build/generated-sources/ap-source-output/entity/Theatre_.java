package entity;

import entity.Screen;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Theatre.class)
public class Theatre_ { 

    public static volatile SingularAttribute<Theatre, Integer> screenNo;
    public static volatile ListAttribute<Theatre, Screen> screenList;
    public static volatile SingularAttribute<Theatre, Integer> theatreId;
    public static volatile SingularAttribute<Theatre, String> theatreName;
    public static volatile SingularAttribute<Theatre, String> theatreAddress;

}