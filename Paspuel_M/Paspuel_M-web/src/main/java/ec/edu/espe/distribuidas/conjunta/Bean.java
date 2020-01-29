/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.conjunta;

import ec.edu.espe.enums.EstadoActivoInactivoEnum;
import ec.edu.espe.model.Funcionalidad;
import ec.edu.espe.model.Modulo;
import ec.edu.espe.services.Service;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mayra
 */
@Named
@ViewScoped
public class Bean implements Serializable{
    
    @Inject
    private Service service;
    
    private static final Logger LOG = Logger.getLogger(Bean.class.getName());
    private List<Modulo> modulos;
    private Modulo modulo;
    private EstadoActivoInactivoEnum estado;
    private Modulo moduloSeleccionado;
    private boolean enFuncionalidad;
    private Funcionalidad funcionalidad;
    private List<Funcionalidad> funcionalidades;
    private Funcionalidad funcSeleccionado;
    
    @PostConstruct
    public void inicio(){
        modulo=new Modulo();
        modulos=service.obtenerTodosModulos();
        enFuncionalidad=true;
    }

    public String Funcionalidad(){
        modulo=moduloSeleccionado;
        funcionalidades=service.obtenerPorEstadoFuncionalidad(modulo.getCodigo());
        return "#";
    }
    
    public Funcionalidad getFuncSeleccionado() {
        return funcSeleccionado;
    }

    public void setFuncSeleccionado(Funcionalidad funcSeleccionado) {
        this.funcSeleccionado = funcSeleccionado;
    }
    
    
    public List<Funcionalidad> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    public boolean isEnFuncionalidad() {
        return enFuncionalidad;
    }

    public void setEnFuncionalidad(boolean enFuncionalidad) {
        this.enFuncionalidad = enFuncionalidad;
    }
    
    public Modulo getModuloSeleccionado() {
        return moduloSeleccionado;
    }

    public void setModuloSeleccionado(Modulo moduloSeleccionado) {
        this.moduloSeleccionado = moduloSeleccionado;
    }

    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public EstadoActivoInactivoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoActivoInactivoEnum estado) {
        this.estado = estado;
    }
}
