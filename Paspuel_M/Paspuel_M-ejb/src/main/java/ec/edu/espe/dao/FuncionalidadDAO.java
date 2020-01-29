/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-ejb
 * 
 * Creado: 17/12/2019 - 15:53:35
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.dao;

import ec.edu.espe.model.Funcionalidad;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Permite manejar las operaciones de insert, update, delete y select para la
 * entidad Funcionalidad.
 *
 * @author Toro Jordan
 * @author Rodríguez Fernando
 */
@LocalBean
@Stateless
public class FuncionalidadDAO extends AbstractDAO<Funcionalidad> {

    public FuncionalidadDAO() {
        super(Funcionalidad.class);
    }

    /**
     * Metodo Finder que obtiene un listado de funcionalidades en base al código
     * del Modulo.
     *
     * @param codModulo El código del modulo con el que se va a realizar la
     * busqueda.
     * @return Listado de funcionalidades en base al modulo.
     */
    public List<Funcionalidad> findByCodModulo(String codModulo) {
        return this.finder(
                "SELECT f FROM Funcionalidad f WHERE f.modulo.codigo = ?1",
                new Object[]{
                    codModulo
                }
        );
    }

    /**
     * Metodo Finder que obtiene una funcionalidad en base al nombre.
     *
     * @param nombre El nombre de la funcionalidad que se va a buscar.
     * @return Una funcionalidad en base al nombre.
     */
    public Funcionalidad findByNombre(String nombre) {
        return this.finder(
                "SELECT f FROM Funcionalidad f WHERE f.nombre = ?1",
                new Object[]{
                    nombre
                }
        ).get(0);
    }

}
