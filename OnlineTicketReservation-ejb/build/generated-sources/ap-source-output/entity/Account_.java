package entity;

import entity.Role;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> genre;
    public static volatile SingularAttribute<Account, String> username;
    public static volatile SingularAttribute<Account, String> phone;
    public static volatile SingularAttribute<Account, Integer> accountId;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> address;
    public static volatile SingularAttribute<Account, String> status;
    public static volatile SingularAttribute<Account, Date> lastDay;
    public static volatile SingularAttribute<Account, Date> dob;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> fullname;
    public static volatile SingularAttribute<Account, Role> roleId;

}