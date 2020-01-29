/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-ejb
 * 
 * Creado: 15/12/2019 - 20:06:26
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Almacena las diferentes funcionalidades que maneja el sistema.
 *
 * @author Toro Jordan
 * @author Rodríguez Fernando
 */
@Entity
@Table(name = "SEG_FUNCIONALIDAD")
public class Funcionalidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_FUNCIONALIDAD", nullable = false)
    private Integer codigo;

    @Column(name = "URL_PRINCIPAL", nullable = false, length = 200)
    private String urlPrincipal;

    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 500)
    private String descripcion;

    // FK_COD_MODULO
    @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO")
    @ManyToOne
    private Modulo modulo;
    
    public Funcionalidad() {
    }

    public Funcionalidad(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getUrlPrincipal() {
        return urlPrincipal;
    }

    public void setUrlPrincipal(String urlPrincipal) {
        this.urlPrincipal = urlPrincipal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionalidad other = (Funcionalidad) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegFuncionalidad{" + "codigo=" + codigo + ", urlPrincipal=" + urlPrincipal + ", nombre=" + nombre + ", descripcion=" + descripcion + ", modulo=" + modulo + '}';
    }

}
