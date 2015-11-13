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
        <title>Catalogo</title>
    </head>
    <body>
        <jsp:include page="../layout/header.jsp"></jsp:include>
        <h1>Catalogo</h1>
        <br/>
        
        <table border="1">
            <tr>
                <td><b>Id:</b></td><td>${catalogo.idCatalogo}</td>
            </tr>
            <tr>
                <td><b>Nombre:</b></td><td>${catalogo.nombre}</td>
            </tr>
            <tr>
                <td><b>Descripcion:</b></td><td>${catalogo.descripcion}</td>
            </tr>
        </table>
        
    </body>
</html>
