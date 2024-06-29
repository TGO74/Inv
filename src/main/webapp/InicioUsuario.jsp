<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio Usuario - Inventory Plus Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/UserStyle.css">
</head>
<body class="bg-gray-100">

<header class="bg-white shadow-md p-4">
    <div class="container mx-auto flex justify-between items-center">
        <div>
            <img src="img/logoInventoryPlusManager.jpeg" alt="Logo" class="h-12">
            <span class="ml-2 text-xl font-bold text-gray-800">Inventory Plus Manager</span>
        </div>
        <nav>
            <a href="#" class="text-gray-600 hover:text-gray-800 px-3 py-2">Gestión de Productos</a>
            <a href="#" class="text-gray-600 hover:text-gray-800 px-3 py-2">Control de Inventario</a>
            <a href="#" class="text-gray-600 hover:text-gray-800 px-3 py-2">Informes</a>
            <span class="text-gray-600">Bienvenido, <%= request.getRemoteUser() %></span>
        </nav>
    </div>
</header>

<main class="container mx-auto mt-4">
    <section class="mb-8">
        <div class="bg-white p-6 rounded-lg shadow-md">
            <h2 class="text-2xl font-bold mb-4">Resumen de Inventario</h2>
            <div class="grid grid-cols-1 sm:grid-cols-2 gap-4">
                <div class="bg-gray-100 p-4 rounded-md">
                    <p class="text-xl font-semibold">Número total de productos</p>
                    <p class="text-4xl font-bold text-blue-600">150</p>
                </div>
                <div class="bg-gray-100 p-4 rounded-md">
                    <p class="text-xl font-semibold">Productos con stock bajo</p>
                    <p class="text-4xl font-bold text-blue-600">10</p>
                </div>
                <div class="bg-gray-100 p-4 rounded-md">
                    <p class="text-xl font-semibold">Valor total del inventario</p>
                    <p class="text-4xl font-bold text-blue-600">$50,000</p>
                </div>
            </div>
        </div>
    </section>

    <section class="mb-8">
        <div class="bg-white p-6 rounded-lg shadow-md">
            <h2 class="text-2xl font-bold mb-4">Actividades Recientes</h2>
            <ul class="divide-y divide-gray-200">
                <li class="py-4">
                    <p class="text-lg"><span class="font-bold">14 de Junio, 10:30 AM:</span> Agregado nuevo producto "Laptop HP"</p>
                </li>
                <li class="py-4">
                    <p class="text-lg"><span class="font-bold">12 de Junio, 2:15 PM:</span> Actualización de información del producto "Mouse Logitech"</p>
                </li>
                <li class="py-4">
                    <p class="text-lg"><span class="font-bold">10 de Junio, 4:45 PM:</span> Generado informe de ventas mensual</p>
                </li>
            </ul>
        </div>
    </section>

    <section class="mb-8">
        <div class="bg-white p-6 rounded-lg shadow-md">
            <h2 class="text-2xl font-bold mb-4">Acciones Rápidas</h2>
            <div class="grid grid-cols-1 sm:grid-cols-3 gap-4">
                <a href="#" class="block bg-blue-600 hover:bg-blue-700 text-white px-4 py-3 rounded-md text-center">
                    Agregar Nuevo Producto
                </a>
                <a href="#" class="block bg-blue-600 hover:bg-blue-700 text-white px-4 py-3 rounded-md text-center">
                    Ver Catálogo de Productos
                </a>
                <a href="#" class="block bg-blue-600 hover:bg-blue-700 text-white px-4 py-3 rounded-md text-center">
                    Generar Informe de Inventario
                </a>
            </div>
        </div>
    </section>
</main>

<footer class="bg-gray-800 text-white text-center py-4">
    <div class="container mx-auto">
        <p class="text-sm">&copy; 2024 InventoryPlusManager. Todos los derechos reservados.</p>
        <p class="text-sm">Contacto: contacto@inventoryplusmanager.com</p>
    </div>
</footer>

</body>
</html>

