/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.servlets.catalogo;

import com.tecstore.manager.CatalogoManager;
import com.tecstore.vo.CatalogoVO;
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
@WebServlet(name = "ActualizarCatalogo", urlPatterns = {"/catalogo/actualizar"})
public class ActualizarCatalogo extends HttpServlet {

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
            String idCatalogo = request.getParameter("idCatalogo");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            
            if(idCatalogo != null && idCatalogo.trim().length() > 0 ) {
                
                CatalogoManager manager = new CatalogoManager();
            
                CatalogoVO catalogo = new CatalogoVO();
                catalogo.setIdCatalogo(idCatalogo);
                catalogo.setNombre(nombre);
                catalogo.setDescripcion(descripcion);
                
                manager.actualizar(catalogo);
                
            } else {
                
                CatalogoManager manager = new CatalogoManager();
                
                CatalogoVO catalogo = new CatalogoVO();
                catalogo.setIdCatalogo(idCatalogo);
                catalogo.setNombre(nombre);
                catalogo.setDescripcion(descripcion);
                
                manager.agregar(catalogo);
            }
            
            
            
            response.sendRedirect("/tecstore/catalogo/listar");
        }
    }

}
