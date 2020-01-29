package ec.edu.espe.model;

import ec.edu.espe.model.HijoPK;
import ec.edu.espe.model.Padre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-28T20:19:16")
@StaticMetamodel(Hijo.class)
public class Hijo_ { 

    public static volatile SingularAttribute<Hijo, Padre> padre;
    public static volatile SingularAttribute<Hijo, HijoPK> pk;
    public static volatile SingularAttribute<Hijo, String> nombre;

}