package ec.edu.espe.model;

import ec.edu.espe.enums.EstadoActivoInactivoEnum;
import ec.edu.espe.model.Funcionalidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-28T21:21:18")
@StaticMetamodel(Modulo.class)
public class Modulo_ { 

    public static volatile SingularAttribute<Modulo, String> codigo;
    public static volatile SingularAttribute<Modulo, EstadoActivoInactivoEnum> estado;
    public static volatile SingularAttribute<Modulo, String> nombre;
    public static volatile ListAttribute<Modulo, Funcionalidad> funcionalidades;

}