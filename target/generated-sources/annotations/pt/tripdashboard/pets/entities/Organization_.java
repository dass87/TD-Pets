package pt.tripdashboard.pets.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pt.tripdashboard.pets.entities.Owner;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-24T11:48:24")
@StaticMetamodel(Organization.class)
public class Organization_ { 

    public static volatile CollectionAttribute<Organization, Owner> owner;
    public static volatile SingularAttribute<Organization, String> name;
    public static volatile SingularAttribute<Organization, String> logo;
    public static volatile SingularAttribute<Organization, Long> id;

}