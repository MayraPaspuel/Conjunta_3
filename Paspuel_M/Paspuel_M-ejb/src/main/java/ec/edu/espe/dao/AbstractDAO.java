/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: ticketsca
 * 
 * Creado: 22/11/2019 - 2:56:04
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * Clase AbstractDAO. Clase abstracta para definir los métodos para manejo de
 * las operaciones en la base de datos.
 *
 * @author Jordan Toro
 * @param <T>
 */
public abstract class AbstractDAO<T> {

    private Class<T> entityClass;

    @PersistenceContext(unitName = "jdbc_practica3")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        this.em.persist(entity);
    }

    public void edit(T entity) {
        this.em.merge(entity);
    }

    public void remove(T entity) {
        this.em.remove(this.em.merge(entity));
    }

    public T find(Object id) {
        return this.em.find(this.entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = this.em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(this.entityClass));
        return this.em.createQuery(cq).getResultList();
    }

    /**
     * Permite obtener un listado de objetos del tipo {@code <T>} en base al
     * seteo de parametros enviados al mismo.
     *
     * @param query Es una cadena en lenguaje JPQL, para indicar los criterios
     * en los cuales se va a buscar.
     * @param parameters Son los valores que se van a setear en el query enviado
     * como parámetro; estos parámetros deben estar ordenados segun el orden que
     * se establecio en el parámetro query.
     *
     * @return Un listado de objetos del tipo {@code List<T>}.
     */
    public List<T> finder(String query, Object[] parameters) {
        Query q = this.em.createQuery(query, this.entityClass);

        for (int i = 0; i < parameters.length; i++) {
            q.setParameter(i + 1, parameters[i]);
        }

        return q.getResultList();
    }
}