/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.services;

import ec.edu.espe.dao.FuncionalidadDAO;
import ec.edu.espe.dao.ModuloDAO;
import ec.edu.espe.enums.EstadoActivoInactivoEnum;
import ec.edu.espe.model.Funcionalidad;
import ec.edu.espe.model.Modulo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author mayra
 */
@Stateless
@LocalBean
public class Service {
    @EJB
    private FuncionalidadDAO daoFuncionalidad;

    /**
     * Obtiene un listado de Funcionalidades.
     *
     * @return Listado Funcionalidads en base al estado.
     */
    public List<Funcionalidad> obtenerTodosFuncionalidad() {
        return daoFuncionalidad.findAll();
    }

    /**
     * Obtiene un Funcionalidad en base a la clave primaria.
     *
     * @param codigo El código con el que se va a realizar la busqueda.
     * @return Funcionalidad en base al código.
     */
    public Funcionalidad obtenerPorPKFuncionalidad(Integer codigo) {
        return daoFuncionalidad.find(codigo);
    }

    /**
     * Obtiene un listado de Funcionalidades en base al código del modulo.
     *
     * @param codModulo Código del modulo que se va a buscar.
     *
     * @return Listado Funcionalidades en base al codigo del modulo.
     */
    public List<Funcionalidad> obtenerPorEstadoFuncionalidad(String codModulo) {
        return daoFuncionalidad.findByCodModulo(codModulo);
    }
    

    /**
     * Obtiene un Funcionalidad en base a un nombre.
     *
     * @param nombre Nombre del modulo al cual se busca.
     *
     * @return Un modulo que coincida con el nombre.
     */
    public Funcionalidad obtenerPorNombreFuncionalidad(String nombre) {
        return daoFuncionalidad.findByNombre(nombre);
    }

    /**
     * Crea un nuevo Funcionalidad.
     *
     * @param modulo Nombre del modulo al cual se busca.
     */
    public void createFuncionalidad(Funcionalidad modulo) {
        if (modulo.getModulo().getCodigo().isEmpty()) {
            throw new UnsupportedOperationException("La funcionalidad debe estar asociada a un modulo.");
        }
        if (modulo.getNombre().isEmpty() || modulo.getUrlPrincipal().isEmpty()) {
            if (modulo.getNombre().isEmpty()) {
                throw new UnsupportedOperationException("El nombre de la funcionalidad no puede ir vacio.");
            }
            if (modulo.getUrlPrincipal().isEmpty()) {
                throw new UnsupportedOperationException("La URL de la funcionalidad no puede ir vacia.");
            }
        }

        daoFuncionalidad.create(modulo);
    }

    /**
     * Actualiza un nuevo Funcionalidad.
     *
     * @param modulo Nombre del modulo al cual se busca.
     */
    public void updateFuncionalidad(Funcionalidad modulo) {
        if (modulo.getCodigo() == null) {
            throw new UnsupportedOperationException("Para actualizar la funcionalidad debe poseer un codigo por el cual buscar.");
        }

        if (modulo.getNombre().isEmpty() || modulo.getUrlPrincipal().isEmpty() || modulo.getModulo().getCodigo().isEmpty()) {
            if (modulo.getNombre().isEmpty()) {
                throw new UnsupportedOperationException("El nombre de la funcionalidad no puede ir vacio.");
            }
            if (modulo.getUrlPrincipal().isEmpty()) {
                throw new UnsupportedOperationException("La URL de la funcionalidad no puede ir vacia.");
            }
            if (modulo.getModulo().getCodigo().isEmpty()) {
                throw new UnsupportedOperationException("La funcionalidad debe estar asociada a un modulo.");
            }
        }

        daoFuncionalidad.edit(modulo);
    }
    
    /**
     * MODULO
     *
     * */
    @EJB
    private ModuloDAO daoModulo;

    /**
     * Obtiene un listado de Modulos.
     *
     * @return Listado Modulos en base al estado.
     */
    public List<Modulo> obtenerTodosModulos() {
        return daoModulo.findAll();
    }

    /**
     * Obtiene un Modulo en base a la clave primaria.
     *
     * @param codigo El código del modulo con el que se va a realizar la
     * busqueda.
     * @return Modulo en base al código.
     */
    public Modulo obtenerPorPKModulo(String codigo) {
        return daoModulo.find(codigo);
    }

    /**
     * Obtiene un listado de Modulos en base al estado.
     *
     * @param estado Estado de los modulos que se van a buscar.
     *
     * @return Listado Modulos en base al estado.
     */
    public List<Modulo> obtenerPorEstadoModulo(EstadoActivoInactivoEnum estado) {
        return daoModulo.findByEstado(estado);
    }

    /**
     * Obtiene un Modulo en base a un nombre.
     *
     * @param nombre Nombre del modulo al cual se busca.
     *
     * @return Un modulo que coincida con el nombre.
     */
    public Modulo obtenerPorNombreModulo(String nombre) {
        return daoModulo.findByNombre(nombre);
    }

    /**
     * Crea un nuevo Modulo.
     *
     * @param modulo Nombre del modulo al cual se busca.
     */
    public void createModulo(Modulo modulo) {
        if (modulo.getCodigo().isEmpty()) {
            throw new UnsupportedOperationException("El modulo no se puede crear con un código vacio.");
        }
        if (modulo.getEstado() == null || modulo.getNombre().isEmpty()) {
            if (modulo.getNombre().isEmpty()) {
                throw new UnsupportedOperationException("El nombre del modulo no puede ir vacio.");
            }
            if (modulo.getEstado() == null) {
                throw new UnsupportedOperationException("El estado del modulo no se puede ir vacio.");
            }
        }

        daoModulo.create(modulo);
    }

    /**
     * Actualiza un nuevo Modulo.
     *
     * @param modulo Nombre del modulo al cual se busca.
     */
    public void updateModulo(Modulo modulo) {
        if (modulo.getCodigo().isEmpty()) {
            throw new UnsupportedOperationException("El modulo no se puede actualizar con un código vacio.");
        }
        if (modulo.getEstado() == null || modulo.getNombre().isEmpty()) {
            if (modulo.getNombre().isEmpty()) {
                throw new UnsupportedOperationException("El nombre del modulo no puede ir vacio.");
            }
            if (modulo.getEstado() == null) {
                throw new UnsupportedOperationException("El estado del modulo no se puede ir vacio.");
            }
        }

        daoModulo.edit(modulo);
    }
    
}
