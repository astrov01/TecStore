/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.servlets.articulo;

import com.tecstore.manager.ArticuloManager;
import com.tecstore.vo.ArticuloVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabrielgrijalvaflores
 */
@WebServlet(name = "ActualizarArticulo", urlPatterns = {"/articulo/actualizar"})
public class ActualizarArticulo extends HttpServlet {

      // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String idArticulo = request.getParameter("idArticulo");
            String catalogo_idCatalogo = request.getParameter("catalogo_idCatalogo");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String precio = request.getParameter("precio");
            String cantidad = request.getParameter("cantidad");
            String picture = request.getParameter("picture");
            
            if(idArticulo != null && idArticulo.trim().length() > 0 ) {
                
                ArticuloManager manager = new ArticuloManager();
            
                ArticuloVO articulo = new ArticuloVO();
                articulo.setIdArticulo(idArticulo);
                articulo.setCatalogo_idCatalogo(catalogo_idCatalogo);
                articulo.setNombre(nombre);
                articulo.setDescripcion(descripcion);
                articulo.setPrecio(precio);
                articulo.setCantidad(cantidad);
                articulo.setPicture(picture);
                
                manager.actualizar(articulo);
                
            } else {
                
                ArticuloManager manager = new ArticuloManager();
                
                ArticuloVO articulo = new ArticuloVO();
                articulo.setIdArticulo(idArticulo);
                articulo.setCatalogo_idCatalogo(catalogo_idCatalogo);
                articulo.setNombre(nombre);
                articulo.setDescripcion(descripcion);
                articulo.setPrecio(precio);
                articulo.setCantidad(cantidad);
                articulo.setPicture(picture);
                
                manager.agregar(articulo);
            }
            
            
            
            response.sendRedirect("/tecstore/articulo/listar");
        }
    }
    
}
