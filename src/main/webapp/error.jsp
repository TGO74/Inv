<%--
  Created by IntelliJ IDEA.
  User: Tomás
  Date: 26/06/2024
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body { font-family: sans-serif; text-align: center; margin: 50px; }
        h1 { color: #dc3545; } /* Rojo */
        p { margin-bottom: 20px; }
    </style>
</head>
<body>
<h1>¡Oops! Algo salió mal.</h1>

<p>Ha ocurrido un error inesperado.</p>

<% if (exception != null) { %>
<h3>Detalles del error:</h3>
<p><%= exception.getMessage() %></p>
<%-- Puedes mostrar más detalles si es necesario --%>
<% } %>

<p>Por favor, intenta nuevamente más tarde o contacta al administrador del sitio.</p>
<a href="index.jsp">Volver a la página principal</a>
</body>
</html>

