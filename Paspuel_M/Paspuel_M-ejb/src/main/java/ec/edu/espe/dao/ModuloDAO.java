/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-ejb
 * 
 * Creado: 17/12/2019 - 15:53:18
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.dao;

import ec.edu.espe.enums.EstadoActivoInactivoEnum;
import ec.edu.espe.model.Modulo;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Permite manejar las operaciones de insert, update, delete y select para la
 * entidad Modulo.
 *
 * @author Toro Jordan
 * @author Rodríguez Fernando
 */
@LocalBean
@Stateless
public class ModuloDAO extends AbstractDAO<Modulo> {

    public ModuloDAO() {
        super(Modulo.class);
    }

    /**
     * Metodo Finder que obtiene un listado de modulos en base al estado.
     *
     * @param estado El estado del modulo con el que se va a realizar la
     * busqueda.
     * @return Listado de modulos en base al estado.
     */
    public List<Modulo> findByEstado(EstadoActivoInactivoEnum estado) {
        return this.finder(
                "SELECT m FROM Modulo m WHERE m.codigo=?1",
                new Object[]{
                    estado
                }
        );
    }

    /**
     * Metodo Finder que obtiene un modulo en base al nombre.
     *
     * @param nombre El nombre del modulo que se va a buscar.
     * @return Un modulo en base al nombre.
     */
    public Modulo findByNombre(String nombre) {
        return this.finder(
                "SELECT m FROM Modulo m WHERE m.nombre = ?1",
                new Object[]{
                    nombre
                }
        ).get(0);
    }

}
