package entity;

import entity.Account;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T06:25:49")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile ListAttribute<Role, Account> accountList;
    public static volatile SingularAttribute<Role, String> roleType;
    public static volatile SingularAttribute<Role, Integer> roleId;

}