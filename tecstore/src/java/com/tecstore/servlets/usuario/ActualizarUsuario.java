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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabrielgrijalvaflores
 */
@WebServlet(name = "ActualizarUsuario", urlPatterns = {"/usuario/actualizar"})
public class ActualizarUsuario extends HttpServlet {
    
    /**
     * Handles the HTTP <code>POST</code> method.
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
            String idUsuario = request.getParameter("idUsuario");
            String nombre = request.getParameter("nombre");
            String rol = request.getParameter("rol");
            
            if(idUsuario != null && idUsuario.trim().length() > 0 ) {
                
                UsuarioManager manager = new UsuarioManager();
            
                UsuarioVO usuario = new UsuarioVO();
                usuario.setIdUsuario(idUsuario);
                usuario.setNombre(nombre);
                usuario.setRol(rol);
                
                manager.actualizar(usuario);
                
            } else {
                
                UsuarioManager manager = new UsuarioManager();
                
                UsuarioVO usuario = new UsuarioVO();
                usuario.setIdUsuario(idUsuario);
                usuario.setNombre(nombre);
                usuario.setRol(rol);
                
                manager.agregar(usuario);
            }
            
            
            
            response.sendRedirect("/tecstore/usuario/listar");
        }
    }

}
