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
        <title>Listado de catalogos</title>
        <link rel="stylesheet" type="text/css" href="../css/newcss.css" /> 
    </head>
    <body>
        <jsp:include page="../layout/header.jsp"></jsp:include>
        <h1>Listado de catalogos</h1>
        <br/>

        <table border="1">
            
            <tr>
                <td>Id:</td><td>Nombre</td><td>Descripcion</td><td></td>
                <td><a href="/tecstore/catalogo/crear">Agregar Catalogo</a></td>
            </tr>
            
                <c:forEach var="catalogo" items="${list}">
                    <tr>
                    <td><a href="/tecstore/catalogo/mostrar?idCatalogo=${catalogo.idCatalogo}">${catalogo.idCatalogo}</a></td>
                    <td><div class="prueba">${catalogo.nombre}</div></td>
                    <td>${catalogo.descripcion}</td>
                    <td><a href="/tecstore/catalogo/eliminar?idCatalogo=${catalogo.idCatalogo}">Eliminar</a></td>
                    <td><a href="/tecstore/catalogo/editar?idCatalogo=${catalogo.idCatalogo}">Editar</a></td>
                    </tr>
                </c:forEach>
                
            
        
        </table>
    </body>
</html>
