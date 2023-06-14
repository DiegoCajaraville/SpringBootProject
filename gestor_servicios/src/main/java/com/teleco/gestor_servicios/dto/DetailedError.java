package com.teleco.gestor_servicios.dto;

import java.util.Date;

public class DetailedError {

    private Date timestamp;
    private String mensaje;
    private String detalles;

    /**
     * @param timestamp
     * @param mensaje
     * @param detalles
     */
    public DetailedError(Date timestamp, String mensaje, String detalles) {
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }
    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }
    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    
    
}
