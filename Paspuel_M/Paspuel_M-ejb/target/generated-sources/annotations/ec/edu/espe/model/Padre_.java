package ec.edu.espe.model;

import ec.edu.espe.enums.EstadoCivilPadreEnums;
import ec.edu.espe.model.Hijo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-28T20:19:16")
@StaticMetamodel(Padre.class)
public class Padre_ { 

    public static volatile SingularAttribute<Padre, Integer> codigo;
    public static volatile SingularAttribute<Padre, EstadoCivilPadreEnums> estadoCivil;
    public static volatile ListAttribute<Padre, Hijo> listaAdmAula;
    public static volatile SingularAttribute<Padre, String> nombre;

}