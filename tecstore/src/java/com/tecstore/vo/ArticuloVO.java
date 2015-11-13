/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.vo;

/**
 *
 * @author gabrielgrijalvaflores
 */
public class ArticuloVO {
    
    private String idArticulo;
    private String catalogo_idCatalogo;
    private String catalogoNombre;
    private String nombre;
    private String descripcion;
    private String precio;
    private String cantidad;
    private String picture;

    /**
     * @return the idArticulo
     */
    public String getIdArticulo() {
        return idArticulo;
    }

    /**
     * @param idArticulo the idArticulo to set
     */
    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    /**
     * @return the catalogo_idCatalogo
     */
    public String getCatalogo_idCatalogo() {
        return catalogo_idCatalogo;
    }

    /**
     * @param catalogo_idCatalogo the catalogo_idCatalogo to set
     */
    public void setCatalogo_idCatalogo(String catalogo_idCatalogo) {
        this.catalogo_idCatalogo = catalogo_idCatalogo;
    }
    
    /**
     * @return the catalogoNombre
     */
    public String getCatalogoNombre() {
        return catalogoNombre;
    }

    /**
     * @param catalogoNombre the catalogoNombre to set
     */
    public void setCatalogoNombre(String catalogoNombre) {
        this.catalogoNombre = catalogoNombre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    @Override //Para sobre escribir los metodos nativos
    public String toString(){
        return this.getIdArticulo() + " " + this.getNombre() + " " + this.getDescripcion(); 
    }
    
    @Override
    public boolean equals(Object otro) {
        if(otro instanceof UsuarioVO){
            return this.getIdArticulo().equals(((ArticuloVO)otro).getIdArticulo());
            
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return this.getIdArticulo().hashCode();
    }   
    
}
