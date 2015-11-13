/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.vo;

import java.io.Serializable;

/**
 *
 * @author gabrielgrijalvaflores
 */
public class CatalogoVO implements Serializable  {
    
    private String idCatalogo;
    private String nombre;
    private String descripcion;

    /**
     * @return the idCatalogo
     */
    public String getIdCatalogo() {
        return idCatalogo;
    }

    /**
     * @param idCatalogo the idCatalogo to set
     */
    public void setIdCatalogo(String idCatalogo) {
        this.idCatalogo = idCatalogo;
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
    
    @Override //Para sobre escribir los metodos nativos
    public String toString(){
        return this.getIdCatalogo() + " " + this.getNombre() + " " + this.getDescripcion(); 
    }
    
    @Override
    public boolean equals(Object otro) {
        if(otro instanceof UsuarioVO){
            return this.getIdCatalogo().equals(((CatalogoVO)otro).getIdCatalogo());
            
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return this.getIdCatalogo().hashCode();
    }
    
    
}
