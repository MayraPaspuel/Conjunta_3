/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-ejb
 * 
 * Creado: 15/12/2019 - 12:41:21
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */


package ec.edu.espe.enums;

/**
 *
 * 
 *
 * @author Toro Jordan
 */
public enum EstadoActivoInactivoEnum {
    /** Representa al valor Activo. */
    ACT("Activo"),
    /** Representa al valor Inactivo. */
    INA("Inactivo");    
    
    /**
     * Propiedad que contiene el texto asociado del elemento.
     */
    private final String text;

    private EstadoActivoInactivoEnum(String text) {
        this.text = text;
    }

    /**
     * Retorna el texto asociadado al elemento de la enumeraci\u00F3n.
     *
     * @return Texto asociado al elemento de la enumeraci\u00F3n.
     */
    public String getText() {
        return this.text;
    }
}
