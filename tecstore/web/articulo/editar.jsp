<%-- 
    Document   : editar
    Created on : Nov 10, 2015, 1:04:10 PM
    Author     : gabrielgrijalvaflores
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicion de articulo</title>
    </head>
    <body>
        <jsp:include page="../layout/header.jsp"></jsp:include>
        <h1>Edicion de articulo!</h1>
        <form action="/tecstore/articulo/actualizar" method="POST">
            <table border="1">
                <tr>
                  <td>Id:</td>
                  <td><input type="hidden" name="idArticulo" value="${articulo.idArticulo}"></td>
                </tr>
                
                <tr>
                  <td>Nombre:</td>
                  <td><input type="text" name="nombre" value="${articulo.nombre}"></td>
                </tr>
                
                <tr>
                  <td>Descripcion:</td>
                  <td><input type="text" name="descripcion" value="${articulo.descripcion}"></td>
                </tr>
                
                <tr>
                  <td>Catalogo</td>
                  <td>
                      
                    
                    <select name="catalogo_idCatalogo">
                                      
                        <c:forEach var="catalogo" items="${catalogos}">
                            
                            <c:choose>
                                <c:when test="${articulo.catalogo_idCatalogo == catalogo.idCatalogo}">
                                    <option value="${catalogo.idCatalogo}" selected >${catalogo.nombre}</option>
                                </c:when>    
                                <c:otherwise>
                                    <option value="${catalogo.idCatalogo}" >${catalogo.nombre}</option>
                                </c:otherwise>
                            </c:choose>
                                
                        </c:forEach>
                        
                    </select>
                  
                  </td>
                </tr>
                
                <tr>
                  <td>Precio</td>
                  <td><input type="text" name="precio" value="${articulo.precio}"></td>
                </tr>
                
                <tr>
                  <td>Cantidad</td>
                  <td><input type="text" name="cantidad" value="${articulo.cantidad}"></td>
                </tr>
                
                <tr>
                  <td>Foto</td>
                  <td><input type="text" name="picture" value="${articulo.picture}"></td>
                </tr>
                

                
                <tr>
                    <td colspan="2"><input type="submit" value="Guardar"></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>