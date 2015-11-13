<%-- 
    Document   : editar
    Created on : Nov 10, 2015, 1:04:10 PM
    Author     : gabrielgrijalvaflores
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicion de Usuario</title>
    </head>
    <body>
        <jsp:include page="../layout/header.jsp"></jsp:include>
        <h1>Edicion de Usuario!</h1>
        <form action="/tecstore/usuario/actualizar" method="POST">
            <table border="1">
                <tr>
                  <td>Id:</td>
                  <td><input type="hidden" name="idUsuario" value="${usuario.idUsuario}"></td>
                </tr>
                
                <tr>
                  <td>Nombre:</td>
                  <td><input type="text" name="nombre" value="${usuario.nombre}"></td>
                </tr>
                
                <tr>
                  <td>Rol:</td>
                  <td><input type="text" name="rol" value="${usuario.rol}"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Guardar"></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>