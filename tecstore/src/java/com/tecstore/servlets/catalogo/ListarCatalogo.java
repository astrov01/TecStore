/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.servlets.catalogo;

import com.tecstore.manager.CatalogoManager;
import com.tecstore.vo.CatalogoVO;
import java.io.IOException;
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
@WebServlet(name = "ListarCatalogo", urlPatterns = {"/catalogo/listar"})
public class ListarCatalogo extends HttpServlet {

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
        CatalogoManager manager = new CatalogoManager();
        List<CatalogoVO> list = manager.listar();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/catalogo/listar.jsp");
        
        request.setAttribute("list", list);
        
        rd.forward(request, response);
    }
    
}
