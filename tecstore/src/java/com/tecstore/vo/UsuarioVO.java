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
public class UsuarioVO implements Serializable {
    
    private String idUsuario;
    private String nombre;
    private String rol;
    
    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
        
    @Override //Para sobre escribir los metodos nativos
    public String toString(){
        return this.getIdUsuario() + " " + this.getNombre() + " " + this.getRol(); 
    }
    
    @Override
    public boolean equals(Object otro) {
        if(otro instanceof UsuarioVO){
            return this.getIdUsuario().equals(((UsuarioVO)otro).getIdUsuario());
            
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return this.getIdUsuario().hashCode();
    }


    
}
