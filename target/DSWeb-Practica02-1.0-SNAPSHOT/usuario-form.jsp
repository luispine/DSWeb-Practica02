<%-- 
    Document   : usuario-form
    Created on : 23 sep 2024, 8:37:09
    Author     : Sebastian
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Formulario de Usuario</title>
</head>
<body>
<h1>Formulario de Usuario</h1>
<form action="usuario" method="post">
    <input type="hidden" name="clave" value="${usuario.clave}">
    <label>Nombre:</label>
    <input type="text" name="nombre" value="${usuario.nombre}" required><br>
    <label>Dirección:</label>
    <input type="text" name="direccion" value="${usuario.direccion}" required><br>
    <label>Teléfono:</label>
    <input type="text" name="telefono" value="${usuario.telefono}" required><br>
    <button type="submit">Guardar</button>
    <a href="usuario?action=listar">Cancelar</a>
</form>
</body>
</html>
