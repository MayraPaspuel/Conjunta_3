/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-ejb
 * 
 * Creado: 15/12/2019 - 20:02:30
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.model;

import ec.edu.espe.enums.EstadoActivoInactivoEnum;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Almacena los diferentes estados que puede tener un modulo.
 *
 * @author Toro Jordan
 * @author Rodríguez Fernando
 */
@Entity
@Table(name = "SEG_MODULO")
public class Modulo implements Serializable {

    @Id
    @Column(name = "COD_MODULO", nullable = false, length = 16)
    private String codigo;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "ESTADO", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoActivoInactivoEnum estado;

    @OneToMany(mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<Funcionalidad> funcionalidades;

    public Modulo() {
    }

    public Modulo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EstadoActivoInactivoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoActivoInactivoEnum estado) {
        this.estado = estado;
    }

    public List<Funcionalidad> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Modulo other = (Modulo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegModulo{" + "codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", funcionalidades=" + funcionalidades + '}';
    }

}
