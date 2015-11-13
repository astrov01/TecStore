/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.dao;

import com.tecstore.vo.CatalogoVO;
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
public class CatalogoDAO {
    
    public List<CatalogoVO> findAll() {
        
        List<CatalogoVO> catalogos = new ArrayList<CatalogoVO>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("SELECT idCatalogo, nombre, descripcion" +
                    " FROM catalogo ORDER BY idCatalogo");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                CatalogoVO catalogo = new CatalogoVO();
                catalogo.setIdCatalogo(rs.getString(1));
                catalogo.setNombre(rs.getString(2));
                catalogo.setDescripcion(rs.getString(3));
                catalogos.add(catalogo);
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
        
        return catalogos;
    }
    
    public CatalogoVO findById(final String idCatalogo) {
        
        CatalogoVO catalogo = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("SELECT idCatalogo, nombre, descripcion" +
                    " FROM catalogo WHERE idCatalogo=?");
            pstmt.setString(1, idCatalogo);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                catalogo = new CatalogoVO();
                catalogo.setIdCatalogo(rs.getString(1));
                catalogo.setNombre(rs.getString(2));
                catalogo.setDescripcion(rs.getString(3));
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
        
        return catalogo;
    }
    
    public void deleteCatalogo(final String idCatalogo) {
                
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM catalogo WHERE idCatalogo=?");
            pstmt.setString(1, idCatalogo);
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
    
    public void updateCatalogo(final CatalogoVO catalogo) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            if (catalogo != null ) {
                
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement(" UPDATE catalogo SET nombre=?, descripcion=? WHERE idCatalogo=?");
            pstmt.setString(1, catalogo.getNombre());
            pstmt.setString(2, catalogo.getDescripcion());
            pstmt.setString(3, catalogo.getIdCatalogo());
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
    
    public CatalogoVO insertCatalogo(final String nombre, final String descripcion) {
        
        CatalogoVO catalogo = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement(" INSERT INTO catalogo (nombre, descripcion) VALUE (?,?)");
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
            pstmt.close();
            
            pstmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                catalogo = new CatalogoVO();
                catalogo.setNombre(nombre);
                catalogo.setDescripcion(descripcion);
                catalogo.setIdCatalogo(rs.getString(1));
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
        
        return catalogo;
       
    }
    
    public static void main (String[] args) {
        
        Scanner scan = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println(dao.findAll());
        System.out.println("Ingrese el numero de ID del catalogo a buscar:");
        String id = scan.next();
        System.out.println(dao.findById(id));
        
    }
    
}
