<%-- 
    Document   : listar
    Created on : Nov 10, 2015, 12:44:02 PM
    Author     : gabrielgrijalvaflores
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de usuarios</title>
    </head>
    <body>
        <jsp:include page="../layout/header.jsp"></jsp:include>
        <h1>Listado de usuarios</h1>
        <br/>

        <table border="1">
            
            <tr>
                <td>Id:</td><td>Nombre</td><td>Rol</td><td></td>
                <td><a href="/tecstore/usuario/crear">Agregar Usuario</a></td>
            </tr>
            
                
                <c:forEach var="usuario" items="${list}">
                    <tr>
                    <td><a href="/tecstore/usuario/mostrar?idUsuario=${usuario.idUsuario}">${usuario.idUsuario}</a></td>
                    <td>${usuario.nombre} </td>
                    <td>${usuario.rol}</td>
                    <td><a href="/tecstore/usuario/eliminar?idUsuario=${usuario.idUsuario}">Eliminar</a></td>
                    <td><a href="/tecstore/usuario/editar?idUsuario=${usuario.idUsuario}">Editar</a></td>
                    </tr>
                </c:forEach>
                
            
        
        </table>
    </body>
</html>
