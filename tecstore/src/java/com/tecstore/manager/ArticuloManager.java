/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.manager;

import com.tecstore.dao.ArticuloDAO;
import com.tecstore.vo.ArticuloVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabrielgrijalvaflores
 */
public class ArticuloManager {
    
    public List<ArticuloVO> listar() {
    
        List<ArticuloVO> articulos = new ArrayList<ArticuloVO>();
        ArticuloDAO dao = new ArticuloDAO();
        
        articulos = dao.findAll();
        
        return articulos;
        
    }
    
    public List<ArticuloVO> listarCatalogo(String idCatalogo) {
    
        List<ArticuloVO> articulos = new ArrayList<ArticuloVO>();
        ArticuloDAO dao = new ArticuloDAO();
        
        articulos = dao.findByCatalog(idCatalogo);
        
        return articulos;
        
    }
    
    public ArticuloVO consultar(String id){
        ArticuloVO articulo = new ArticuloVO();
        ArticuloDAO dao = new ArticuloDAO();
        
        articulo = dao.findById(id);
        
        return articulo;
    }
    
    public void eliminar(String id) {
        
        ArticuloDAO dao = new ArticuloDAO();
        
        dao.deleteArticulo(id);
    
    }
    
    public void actualizar(final ArticuloVO articulo) {
        ArticuloDAO dao = new ArticuloDAO();
        dao.updateArticulo(articulo);
    }
    
    public void agregar(final ArticuloVO articulo) {
        ArticuloDAO dao = new ArticuloDAO();
        dao.insertArticulo(articulo.getCatalogo_idCatalogo(), articulo.getNombre(), articulo.getDescripcion(),
                           articulo.getPrecio(), articulo.getCantidad(), articulo.getPicture());
    }
    
    public static void main (String[] args){
        
        Scanner scan = new Scanner(System.in);
        ArticuloManager articuloManager = new ArticuloManager();
        System.out.println("Ingrese el ID del catalogo:");
        String idCatalogo = scan.next();
        System.out.println("Ingrese el Nombre:");
        String nombre = scan.next();
        System.out.println("Ingrese la descripcion:");
        String descripcion = scan.next();
        System.out.println("Ingrese el precio:");
        String precio = scan.next();
        System.out.println("Ingrese la cantidad:");
        String cantidad = scan.next();
        System.out.println("Ingrese la foto:");
        String picture = scan.next();
        
        ArticuloVO articulo = new ArticuloVO();
        articulo.setCatalogo_idCatalogo(idCatalogo);
        articulo.setNombre(nombre);
        articulo.setDescripcion(descripcion);
        articulo.setPrecio(precio);
        articulo.setCantidad(cantidad);
        articulo.setPicture(picture);        
        
        articuloManager.agregar(articulo);
        
        System.out.println(articuloManager.consultar("1"));
    
    }
    
}
