<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario - Inventory Plus Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
<div class="bg-white p-8 rounded-lg shadow-md w-96">
    <h1 class="text-2xl font-bold mb-6">Registro de Usuario</h1>
    <form action="/usuario" method="post">
        <div class="mb-4">
            <label for="nombreUsuario" class="block text-gray-700 mb-2">Nombre</label>
            <input type="text" id="nombreUsuario" name="nombreUsuario" class="w-full px-3 py-2 border rounded-lg" required>
        </div>
        <div class="mb-4">
            <label for="email" class="block text-gray-700 mb-2">Correo Electrónico</label>
            <input type="email" id="email" name="email" class="w-full px-3 py-2 border rounded-lg" required>
        </div>
        <div class="mb-4">
            <label for="password" class="block text-gray-700 mb-2">Contraseña</label>
            <input type="password" id="password" name="password" class="w-full px-3 py-2 border rounded-lg" required>
        </div>
        <div class="mb-4">
            <label for="confirm_password" class="block text-gray-700 mb-2">Confirmar Contraseña</label>
            <input type="password" id="confirm_password" name="confirm_password" class="w-full px-3 py-2 border rounded-lg" required>
        </div>
        <button type="submit" class="btn btn-primary w-full bg-blue-600 hover:bg-blue-700 text-white py-2 rounded-lg">Registrar</button>
        <div class="text-red-500 mt-2">
            <% if (request.getParameter("error") != null) { %>
            <p>Las contraseñas no coinciden o el correo ya está registrado</p>
            <% } %>
        </div>
    </form>
    <div class="text-center mt-4">
        <a href="index.jsp" class="text-blue-600 hover:underline">Volver al inicio de sesión</a>
    </div>
</div>
</body>
</html>
