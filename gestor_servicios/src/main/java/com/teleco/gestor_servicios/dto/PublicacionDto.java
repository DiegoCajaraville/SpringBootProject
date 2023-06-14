package com.teleco.gestor_servicios.dto;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.teleco.gestor_servicios.entities.Comentario;

public class PublicacionDto {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "El titulo de la publicacion debería tener al menos 2 caracteres")
    private String titulo;

    @NotEmpty
    @Size(min = 10, message = "La descripcion de la publicacion debería tener al menos 10 caracteres")
    private String descripcion;

    @NotEmpty
    private String contenido;
    private Set<Comentario> comentarios;

    /**
     * 
     */
    public PublicacionDto() {
    }

    /**
     * @param id
     * @param titulo
     * @param descripcion
     * @param contenido
     */
    public PublicacionDto(Long id, String titulo, String descripcion, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the comentarios
     */
    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

}
