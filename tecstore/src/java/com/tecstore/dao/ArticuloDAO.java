/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.dao;

import com.tecstore.manager.CatalogoManager;
import com.tecstore.vo.ArticuloVO;
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
public class ArticuloDAO {
    
    public List<ArticuloVO> findAll() {
        
        List<ArticuloVO> articulos = new ArrayList<ArticuloVO>();
        CatalogoManager catalogoManager = new CatalogoManager();
        CatalogoVO catalogo = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("SELECT idArticulo, catalogo_idCatalogo, nombre, " +
                    "descripcion, precio, cantidad, picture FROM articulo ORDER BY idArticulo");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                ArticuloVO articulo = new ArticuloVO();
                articulo.setIdArticulo(rs.getString(1));
                catalogo = catalogoManager.consultar(rs.getString(2));
                articulo.setCatalogo_idCatalogo(catalogo.getIdCatalogo());
                articulo.setCatalogoNombre(catalogo.getNombre());
                articulo.setNombre(rs.getString(3));
                articulo.setDescripcion(rs.getString(4));
                articulo.setPrecio(rs.getString(5));
                articulo.setCantidad(rs.getString(6));
                articulo.setPicture(rs.getString(7));
                articulos.add(articulo);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articulos;
    }
    
    public List<ArticuloVO> findByCatalog(final String idCatalogo) {
        
        List<ArticuloVO> articulos = new ArrayList<ArticuloVO>();
        CatalogoManager catalogoManager = new CatalogoManager();
        CatalogoVO catalogo = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("SELECT idArticulo, catalogo_idCatalogo, nombre, " +
                    "descripcion, precio, cantidad, picture FROM articulo WHERE catalogo_idCatalogo = ? ORDER BY idArticulo");
            pstmt.setString(1, idCatalogo);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                ArticuloVO articulo = new ArticuloVO();
                articulo.setIdArticulo(rs.getString(1));
                catalogo = catalogoManager.consultar(rs.getString(2));
                articulo.setCatalogo_idCatalogo(catalogo.getIdCatalogo());
                articulo.setCatalogoNombre(catalogo.getNombre());
                articulo.setNombre(rs.getString(3));
                articulo.setDescripcion(rs.getString(4));
                articulo.setPrecio(rs.getString(5));
                articulo.setCantidad(rs.getString(6));
                articulo.setPicture(rs.getString(7));
                articulos.add(articulo);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articulos;
    }
    
    public ArticuloVO findById(final String idArticulo) {
        
        ArticuloVO articulo = null;
        CatalogoManager catalogoManager = new CatalogoManager();
        CatalogoVO catalogo = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("SELECT idArticulo, catalogo_idCatalogo, nombre, " +
                    "descripcion, precio, cantidad, picture FROM articulo WHERE idArticulo=?");
            pstmt.setString(1, idArticulo);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                articulo = new ArticuloVO();
                articulo.setIdArticulo(rs.getString(1));
                catalogo = catalogoManager.consultar(rs.getString(2));
                articulo.setCatalogo_idCatalogo(catalogo.getIdCatalogo());
                articulo.setCatalogoNombre(catalogo.getNombre());
                articulo.setNombre(rs.getString(3));
                articulo.setDescripcion(rs.getString(4));
                articulo.setPrecio(rs.getString(5));
                articulo.setCantidad(rs.getString(6));
                articulo.setPicture(rs.getString(7));
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articulo;
    }
    
    public void deleteArticulo(final String idArticulo) {
        
        ArticuloVO articulo = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM articulo WHERE idArticulo=?");
            pstmt.setString(1, idArticulo);
            int rs = pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void updateArticulo(final ArticuloVO articulo) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            if (articulo != null ) {
                
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement(" UPDATE articulo SET catalogo_idCatalogo=?, nombre=?, " +
                    "descripcion=?, precio=?, cantidad=?, picture=? WHERE idArticulo=?");
            pstmt.setString(1, articulo.getCatalogo_idCatalogo());
            pstmt.setString(2, articulo.getNombre());
            pstmt.setString(3, articulo.getDescripcion());
            pstmt.setString(4, articulo.getPrecio());
            pstmt.setString(5, articulo.getCantidad());
            pstmt.setString(6, articulo.getPicture());
            pstmt.setString(7, articulo.getIdArticulo());
            
            int rs = pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            }
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public ArticuloVO insertArticulo(final String catalogo_idCatalogo, final String nombre, final String descripcion,
                                     final String precio, final String cantidad, final String picture) {
        
        ArticuloVO articulo = null;
        CatalogoManager catalogoManager = new CatalogoManager();
        CatalogoVO catalogo = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/tecstore?user=root&password=audir8");
            PreparedStatement pstmt = conn.prepareStatement(" INSERT INTO articulo (catalogo_idCatalogo, nombre, " +
                    "descripcion, precio, cantidad, picture) VALUE (?,?,?,?,?,?)");
            pstmt.setString(1, catalogo_idCatalogo);
            pstmt.setString(2, nombre);
            pstmt.setString(3, descripcion);
            pstmt.setString(4, precio);
            pstmt.setString(5, cantidad);
            pstmt.setString(6, picture);
            pstmt.executeUpdate();
            pstmt.close();
            
            pstmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                articulo = new ArticuloVO();
                
                catalogo = catalogoManager.consultar(catalogo_idCatalogo);
                articulo.setCatalogo_idCatalogo(catalogo.getIdCatalogo());
                articulo.setCatalogoNombre(catalogo.getNombre());
                articulo.setNombre(nombre);
                articulo.setDescripcion(descripcion);
                articulo.setPrecio(precio);
                articulo.setCantidad(cantidad);
                articulo.setPicture(picture);
                articulo.setIdArticulo(rs.getString(1));
            } 
            
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articulo;
       
    }
    
    public static void main (String[] args) {
        
        Scanner scan = new Scanner(System.in);
        ArticuloDAO dao = new ArticuloDAO();
        System.out.println(dao.findAll());
        System.out.println("Ingrese el numero de ID del articulo a buscar:");
        String id = scan.next();
        System.out.println(dao.findById(id));
        
    }
    
}
