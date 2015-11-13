/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecstore.servlets.usuario;

import com.tecstore.manager.UsuarioManager;
import com.tecstore.vo.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "MostrarUsuario", urlPatterns = {"/usuario/mostrar"})
public class MostrarUsuario extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String idUsuario = request.getParameter("idUsuario");
            UsuarioManager manager = new UsuarioManager();
            UsuarioVO usuario = manager.consultar(idUsuario);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/usuario/mostrar.jsp");
        
            request.setAttribute("usuario", usuario);
        
            rd.forward(request, response);
        }
    }


}
