package pt.tripdashboard.pets.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pt.tripdashboard.pets.entities.Organization;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-23T17:16:21")
@StaticMetamodel(Pet.class)
public class Pet_ { 

    public static volatile SingularAttribute<Pet, String> species;
    public static volatile SingularAttribute<Pet, String> drugs;
    public static volatile SingularAttribute<Pet, String> sex;
    public static volatile SingularAttribute<Pet, Organization> organization;
    public static volatile SingularAttribute<Pet, String> name;
    public static volatile SingularAttribute<Pet, Long> id;
    public static volatile SingularAttribute<Pet, Boolean> sterilized;
    public static volatile SingularAttribute<Pet, Integer> age;
    public static volatile SingularAttribute<Pet, String> breed;
    public static volatile SingularAttribute<Pet, String> picture;

}