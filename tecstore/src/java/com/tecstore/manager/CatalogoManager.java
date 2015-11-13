/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.manager;

import com.tecstore.dao.CatalogoDAO;
import com.tecstore.vo.CatalogoVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabrielgrijalvaflores
 */
public class CatalogoManager {
    
    public List<CatalogoVO> listar() {
    
        List<CatalogoVO> catalogos = new ArrayList<CatalogoVO>();
        CatalogoDAO dao = new CatalogoDAO();
        
        catalogos = dao.findAll();
        
        return catalogos;
        
    }
    
    public CatalogoVO consultar(String id){
        CatalogoVO catalogo = new CatalogoVO();
        CatalogoDAO dao = new CatalogoDAO();
        
        catalogo = dao.findById(id);
        
        return catalogo;
    }
    
    public void eliminar(String id) {
        
        CatalogoDAO dao = new CatalogoDAO();
        
        dao.deleteCatalogo(id);
    
    }
    
    public void actualizar(final CatalogoVO catalogo) {
        CatalogoDAO dao = new CatalogoDAO();
        dao.updateCatalogo(catalogo);
    }
    
    public void agregar(final CatalogoVO catalogo) {
        CatalogoDAO dao = new CatalogoDAO();
        dao.insertCatalogo(catalogo.getNombre(), catalogo.getDescripcion());
    }
    
    public static void main (String[] args){
        
        Scanner scan = new Scanner(System.in);
        CatalogoManager catalogoManager = new CatalogoManager();
        System.out.println(catalogoManager.listar());
        System.out.println("Ingrese el numero de ID del catalogo a buscar:");
        String id = scan.next();
        System.out.println(catalogoManager.consultar(id));
    
    }
    
}   
