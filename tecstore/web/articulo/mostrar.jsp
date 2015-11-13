<%-- 
    Document   : mostrar
    Created on : Nov 10, 2015, 12:57:11 PM
    Author     : gabrielgrijalvaflores
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articulo</title>
    </head>
    <body>
        <jsp:include page="../layout/header.jsp"></jsp:include>
        <h1>Articulo</h1>
        <br/>
        
        <table border="1">
            <tr>
                <td><b>Id:</b></td><td>${articulo.idArticulo}</td>
            </tr>
            <tr>
                <td><b>Nombre:</b></td><td>${articulo.nombre}</td>
            </tr>
            <tr>
                <td><b>Descripcion:</b></td><td>${articulo.descripcion}</td>
            </tr>
            <tr>
                <td><b>Catalogo:</b></td><td>${articulo.catalogoNombre}</td>
            </tr>
            <tr>
                <td><b>Precio:</b></td><td>${articulo.precio}</td>
            </tr>
            <tr>
                <td><b>Cantidad:</b></td><td>${articulo.cantidad}</td>
            </tr>
            <tr>
                <td><b>Foto:</b></td><td>${articulo.picture}</td>
            </tr>
        </table>
        
    </body>
</html>
