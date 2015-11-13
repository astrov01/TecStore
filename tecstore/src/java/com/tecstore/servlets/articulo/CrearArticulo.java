/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.servlets.articulo;

import com.tecstore.manager.CatalogoManager;
import com.tecstore.vo.ArticuloVO;
import com.tecstore.vo.CatalogoVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabrielgrijalvaflores
 */
@WebServlet(name = "CrearArticulo", urlPatterns = {"/articulo/crear"})
public class CrearArticulo extends HttpServlet {
    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArticuloVO articulo = new ArticuloVO();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/articulo/editar.jsp");
            
            CatalogoManager catalogoManager = new CatalogoManager();
            List<CatalogoVO> catalogos = catalogoManager.listar();
            
            
            request.setAttribute("catalogos", catalogos);
            request.setAttribute("articulo", articulo);
        
            rd.forward(request, response);
        }
    }
    
}
