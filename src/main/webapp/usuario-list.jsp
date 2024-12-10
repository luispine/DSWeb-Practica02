<%-- 
    Document   : usuario-list
    Created on : 23 sep 2024, 8:36:23
    Author     : Sebastian
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Usuarios</title>
</head>
<body>
<h1>Lista de Usuarios</h1>
<a href="usuario?action=nuevo">Nuevo Usuario</a>
<table border="1">
    <thead>
    <tr>
        <th>Clave</th>
        <th>Nombre</th>
        <th>Dirección</th>
        <th>Teléfono</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="usuario" items="${usuarios}">
        <tr>
            <td>${usuario.clave}</td>
            <td>${usuario.nombre}</td>
            <td>${usuario.direccion}</td>
            <td>${usuario.telefono}</td>
            <td>
                <a href="usuario?action=editar&clave=${usuario.clave}">Editar</a>
                <a href="usuario?action=eliminar&clave=${usuario.clave}" 
                   onclick="return confirm('¿Estás seguro?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

