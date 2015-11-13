/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.dao;

import com.tecstore.vo.UsuarioVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrielgrijalvaflores
 */
public class UsuarioDAO {
    public List<UsuarioVO> findAll() {
        
        List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("SELECT idUsuario, nombre, rol" +
                    " FROM usuario ORDER BY idUsuario");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                UsuarioVO usuario = new UsuarioVO();
                usuario.setIdUsuario(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setRol(rs.getString(3));
                usuarios.add(usuario);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
    
    public UsuarioVO findById(final String idUsuario) {
        
        UsuarioVO usuario = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("SELECT idUsuario, nombre, rol" +
                    " FROM usuario WHERE idUsuario=?");
            pstmt.setString(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                usuario = new UsuarioVO();
                usuario.setIdUsuario(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setRol(rs.getString(3));
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    public void deleteUsuario(final String idUsuario) {
        
        UsuarioVO usuario = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM usuario WHERE idUsuario=?");
            pstmt.setString(1, idUsuario);
            int rs = pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void updateUsuario(final UsuarioVO usuario) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            if (usuario != null ) {
                
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement(" UPDATE usuario SET nombre=?, rol=? WHERE idUsuario=?");
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getRol());
            pstmt.setString(3, usuario.getIdUsuario());
            int rs = pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            }
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public UsuarioVO insertUsuario(final String nombre, final String rol) {
        
        UsuarioVO usuario = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement(" INSERT INTO usuario (nombre, rol) VALUE (?,?)");
            pstmt.setString(1, nombre);
            pstmt.setString(2, rol);
            pstmt.executeUpdate();
            pstmt.close();
            
            pstmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                usuario = new UsuarioVO();
                usuario.setNombre(nombre);
                usuario.setRol(rol);
                usuario.setIdUsuario(rs.getString(1));
            } 
            
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
       
    }
    
    public static void main (String[] args) {
        
        Scanner scan = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println(dao.findAll());
        System.out.println("Ingrese el numero de ID del usuario a buscar:");
        String id = scan.next();
        System.out.println(dao.findById(id));
        
    }
}
