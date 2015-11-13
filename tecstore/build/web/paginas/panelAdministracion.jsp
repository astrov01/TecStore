<%-- 
    Document   : panelAdministracion
    Created on : Nov 11, 2015, 1:00:18 PM
    Author     : gabrielgrijalvaflores
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de administracion</title>
    </head>
    <body>
       
        <jsp:include page="../layout/header.jsp"></jsp:include>
        
        
        
        <h1>Panel de administracion</h1>
        
        <div><a href="/tecstore/catalogo/crear">+ Agregar un Catalogo</a></div>
    
        <br/>
        <br/>

        <c:forEach var="catalogo" items="${catalogos}">
            <a href="/tecstore/articulo/listar?idCatalogo=${catalogo.idCatalogo}">${catalogo.nombre}</a><br/>
        </c:forEach>
        
        
        
    </body>
    
</html>
