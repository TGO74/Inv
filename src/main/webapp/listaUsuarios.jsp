<%--
  Created by IntelliJ IDEA.
  User: Tomás
  Date: 26/06/2024
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <style>
        /* Estilos básicos para la tabla (puedes personalizarlos) */
        table { width: 80%; margin: 20px auto; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>

<h2>Lista de Usuarios</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Correo Electrónico</th>
        <th>Rol</th>
        <th>Acciones</th>
    </tr>

    <c:forEach items="${listaUsuarios}" var="usuario">
        <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nombre}</td>
            <td>${usuario.email}</td>
            <td>${usuario.rol}</td>
            <td>
                <a href="editarUsuario.jsp?id=${usuario.id}">Editar</a> |
                <a href="eliminarUsuario.jsp?id=${usuario.id}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

