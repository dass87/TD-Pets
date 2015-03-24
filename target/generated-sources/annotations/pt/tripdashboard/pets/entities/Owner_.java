package pt.tripdashboard.pets.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pt.tripdashboard.pets.entities.Organization;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-23T17:16:21")
@StaticMetamodel(Owner.class)
public class Owner_ { 

    public static volatile SingularAttribute<Owner, String> password;
    public static volatile CollectionAttribute<Owner, Organization> organization;
    public static volatile SingularAttribute<Owner, String> name;
    public static volatile SingularAttribute<Owner, Long> id;
    public static volatile SingularAttribute<Owner, String> email;

}