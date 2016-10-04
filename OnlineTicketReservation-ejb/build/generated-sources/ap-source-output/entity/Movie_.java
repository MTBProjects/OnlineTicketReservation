package entity;

import entity.Showtimes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> movieName;
    public static volatile SingularAttribute<Movie, Integer> duration;
    public static volatile SingularAttribute<Movie, Integer> movieId;
    public static volatile SingularAttribute<Movie, String> cast;
    public static volatile SingularAttribute<Movie, String> status;
    public static volatile SingularAttribute<Movie, String> description;
    public static volatile SingularAttribute<Movie, String> movieType;
    public static volatile ListAttribute<Movie, Showtimes> showtimesList;
    public static volatile SingularAttribute<Movie, String> poster;
    public static volatile SingularAttribute<Movie, Integer> year;
    public static volatile SingularAttribute<Movie, Date> showDate;
    public static volatile SingularAttribute<Movie, String> director;

}