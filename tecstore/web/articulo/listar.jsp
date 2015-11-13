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
        <title>Listado de articulos</title>
        <link rel="stylesheet" type="text/css" href="../css/newcss.css" /> 
    </head>
    <body>
        <jsp:include page="../layout/header.jsp"></jsp:include>
        <h1>Listado de articulos</h1>
        <br/>

        <table border="1">
            
            <tr>
                <td>Id:</td><td>Nombre</td><td>Descripcion</td><td>Catalogo</td>
                <td>Precio</td><td>Cantidad</td><td>Foto</td>
                <td></td><td><a href="/tecstore/articulo/crear">Agregar Articulo</a></td>
            </tr>
            
                <c:forEach var="articulo" items="${list}">
                    <tr>
                    <td><a href="/tecstore/articulo/mostrar?idArticulo=${articulo.idArticulo}">${articulo.idArticulo}</a></td>
                    <td>${articulo.nombre}</td>
                    <td>${articulo.descripcion}</td>
                    <td>${articulo.catalogoNombre}</td>
                    <td>${articulo.precio}</td>
                    <td>${articulo.cantidad}</td>
                    <td>${articulo.picture}</td>
                    <td><a href="/tecstore/articulo/eliminar?idArticulo=${articulo.idArticulo}">Eliminar</a></td>
                    <td><a href="/tecstore/articulo/editar?idArticulo=${articulo.idArticulo}">Editar</a></td>
                    </tr>
                </c:forEach>
                
            
        
        </table>
    </body>
</html>
