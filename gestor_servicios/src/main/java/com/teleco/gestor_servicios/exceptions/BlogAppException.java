package com.teleco.gestor_servicios.exceptions;

import org.springframework.http.HttpStatus;

public class BlogAppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;
    private String mensaje;

    public BlogAppException(HttpStatus status, String mensaje) {
        super();
        this.status = status;
        this.mensaje = mensaje;
    }

    public BlogAppException(HttpStatus status, String mensaje, String mensaje1) {
        super();
        this.status = status;
        this.mensaje = mensaje;
        this.mensaje = mensaje1;
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
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

}
