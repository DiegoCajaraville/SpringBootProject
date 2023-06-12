package com.teleco.gestor_servicios.dto;

import java.util.List;

public class PublicacionResponse {
    
    private List<PublicacionDto> contenido;
    private int pageNo;
    private int pageSize;
    private long totalElementos;
    private int totalPaginas;
    private boolean ultima;

    /**
     * 
     */
    public PublicacionResponse() {
    }

    /**
     * @return the contenido
     */
    public List<PublicacionDto> getContenido() {
        return contenido;
    }
    /**
     * @param contenido the contenido to set
     */
    public void setContenido(List<PublicacionDto> contenido) {
        this.contenido = contenido;
    }
    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }
    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }
    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    /**
     * @return the totalElementos
     */
    public long getTotalElementos() {
        return totalElementos;
    }
    /**
     * @param totalElementos the totalElementos to set
     */
    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }
    /**
     * @return the totalPaginas
     */
    public int getTotalPaginas() {
        return totalPaginas;
    }
    /**
     * @param totalPaginas the totalPaginas to set
     */
    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
    /**
     * @return the ultima
     */
    public boolean isUltima() {
        return ultima;
    }
    /**
     * @param ultima the ultima to set
     */
    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }

    
}
