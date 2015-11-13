package com.tecstore.manager;

import com.tecstore.dao.UsuarioDAO;
import com.tecstore.vo.UsuarioVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabrielgrijalvaflores
 */
public class UsuarioManager {
    
    public List<UsuarioVO> listar() {
    
        List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
        UsuarioDAO dao = new UsuarioDAO();
        
        usuarios = dao.findAll();
        
        return usuarios;
        
    }
    
    public UsuarioVO consultar(String id){
        UsuarioVO usuario = new UsuarioVO();
        UsuarioDAO dao = new UsuarioDAO();
        
        usuario = dao.findById(id);
        
        return usuario;
    }
    
    public void eliminar(String id) {
        
        UsuarioDAO dao = new UsuarioDAO();
        
        dao.deleteUsuario(id);
    
    }
    
    public void actualizar(final UsuarioVO usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.updateUsuario(usuario);
    }
    
    public void agregar(final UsuarioVO usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.insertUsuario(usuario.getNombre(), usuario.getRol());
    }
    
    public static void main (String[] args){
        
        Scanner scan = new Scanner(System.in);
        UsuarioManager usuarioManager = new UsuarioManager();
        System.out.println(usuarioManager.listar());
        System.out.println("Ingrese el numero de ID del usuario a buscar:");
        String id = scan.next();
        System.out.println(usuarioManager.consultar(id));
    
    }
    
}
