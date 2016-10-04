package entity;

import entity.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> genre;
    public static volatile SingularAttribute<Customer, String> customerName;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, Integer> customerId;
    public static volatile SingularAttribute<Customer, Date> createday;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, String> status;
    public static volatile ListAttribute<Customer, Ticket> ticketList;
    public static volatile SingularAttribute<Customer, Date> lastDay;
    public static volatile SingularAttribute<Customer, Date> dob;
    public static volatile SingularAttribute<Customer, String> passport;
    public static volatile SingularAttribute<Customer, String> password;

}