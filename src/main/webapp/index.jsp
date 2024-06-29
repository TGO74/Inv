<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InventoryPlusManager</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/styles.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.9.1/gsap.min.js"></script>
    <script>
        $(document).ready(function() {
            // Animación del logo
            gsap.fromTo(".logo", { opacity: 0, scale: 0.01 }, { opacity: 1, scale: 1, duration: 1 });

            // Animación del formulario
            gsap.fromTo(".login-form", { opacity: 0, y: 50 }, { opacity: 1, y: 0, duration: 1, delay: 0.5 });
        });
    </script>
    <style>
        /* Styles for background movement */
        .parallax {
            background-attachment: fixed;
            background-size: cover;
            background-position: center;
        }
        .promo-section {
            background-color: #f8fafc;
            padding: 4rem 2rem;
        }
        .promo-section h2 {
            color: #2d3748;
        }
        .promo-section ul {
            color: #4a5568;
        }
    </style>
</head>
<body>

<header class="bg-white text-center p-3">
    <img src="img/logoInventoryPlusManager.jpeg" alt="Logo" class="logo w-800 h-800 rounded-full mx-auto"> <!-- Clases de Tailwind para tamaño y centrado del logo -->
</header>

<section class="flex login-section">
    <div class="w-1/2 p-8 bg-blue flex items-center justify-center">
        <div class="max-w-lg">
            <h1 class="text-center text-4xl font-bold mb-6">Transforma tu Negocio con Inventory Plus Manager</h1>
            <p class="text-xl leading-loose text-center">
                <strong>Bienvenido a Inventory Plus Manager</strong>, la solución definitiva para la gestión integral de inventario.
            </p>

            <ul class="text-center list-disc list-inside text-xl leading-loose mt-4">
                <li><strong>Control Total</strong></li>
                <li><strong>Fácil Implementación</strong></li>
                <li><strong>Soporte y Actualizaciones</strong></li>
                <li><strong>Sin Costos Ocultos</strong></li>
            </ul>

            <p class="text-center text-xl leading-loose mt-4">
                <strong>¿Listo para transformar tu negocio? Inicia sesión ahora o regístrate para una demostración gratuita.</strong>
            </p>
        </div>
    </div>
    <div class="w-1/2 flex items-center justify-center p-8">
        <div class="login-form bg-white p-6 rounded-lg shadow-lg max-w-lg mx-auto">
            <h2 class="text-center text-2xl font-bold mb-4">Iniciar Sesión</h2>
            <form action="LoginServlet" method="post">
                <div class="form-group mb-4">
                    <label for="email" class="block text-sm font-medium text-gray-700">Correo Electrónico</label>
                    <input type="email" class="form-control w-full px-3 py-2 border border-gray-300 rounded-md" id="email" name="email" placeholder="Ingresa tu correo electrónico" required>
                </div>
                <div class="form-group mb-4">
                    <label for="password" class="block text-sm font-medium text-gray-700">Contraseña</label>
                    <input type="password" class="form-control w-full px-3 py-2 border border-gray-300 rounded-md" id="password" name="password" placeholder="Ingresa tu contraseña" required>
                </div>
                <button type="submit" class="btn btn-primary w-full bg-blue-600 text-white py-2 rounded-md hover:bg-blue-700">Iniciar Sesión</button>
                <div class="text-center mt-3">
                    <a href="olvideContrasena.jsp" class="text-blue-600 hover:underline">Olvidé mi contraseña</a> | <a href="RegistroUsuario.jsp" class="text-blue-600 hover:underline">Registrarse</a>
                </div>
            </form>
        </div>
    </div>
</section>

<section class="promo-section text-center">
    <h2 class="text-4xl font-bold mb-4">Absolutamente todo incluido</h2>
    <p class="text-center text-xl leading-loose mt-4">
        Con <strong>Inventory Plus Manager</strong>, obtienes más que control de inventario; obtienes un socio en el crecimiento de tu negocio.
    </p>
    <p class="text-xl mb-6">Es la solución integral completa que tu empresa necesita. Contará con acceso a todos los módulos disponibles y acceso garantizado a todos los que vendrán.</p>
    <div class="flex justify-center">
        <div class="w-1/3 p-4">
            <img src="https://d1eipm3vz40hy0.cloudfront.net/images/SSAC-Blog/co%CC%81mo+llevar+un+control+de+ventas.jpg" alt="Imagen 1" class="mx-auto mb-4 rounded-full">
            <strong><p class="text-lg">Controla tus compras y ventas de manera eficiente.</p></strong>
        </div>
        <div class="w-1/3 p-4">
            <img src="https://blog.solistica.com/hubfs/Control%20de%20inventarios%20automatizados%20en%20la%20industria%20manufacturera.jpeg" alt="Imagen 2" class="mx-auto mb-4 rounded-full">
            <strong><p class="text-lg">Automatiza procesos y mejora la productividad.</p></strong>
        </div>
        <div class="w-1/3 p-4">
            <img src="https://www.serlog21.com/wp-content/uploads/2022/09/gente-negocios-sentado-escritorio-oficina-trabajando-proyecto_1098-17930.jpg" alt="Imagen 3" class="mx-auto mb-4 rounded-full">
            <strong><p class="text-lg">Accede a informes financieros en tiempo real.</p></strong>
        </div>
    </div>
</section>

<section class="relative h-screen text-black parallax" style="background-image: url('https://sw.com.mx/hubfs/Automatizacion-de-procesos-administrativos-eficiencia-para-tu-empresa-P.jpg');">
    <div class="relative z-10 flex items-center justify-center h-full">
        <div class="text-center bg-opacity-80 bg-white p-6 rounded-lg">
           <strong> <h2 class="text-center text-3xl font-bold mb-6">¿Qué beneficios tiene Inventory Plus Manager?</h2></strong>
            <ul class="list-disc list-inside text-lg leading-loose">
                <strong><li>Visualiza tu empresa en tiempo real desde cualquier dispositivo.</li>
                <li>Automatiza tus procesos y mejora tu comunicación interna.</li>
                <li>Software 100% web.</li>
                <li>Mayor control sobre tus compras, ventas, cobros, pagos, presupuestos, inventario, y contabilidad.</li>
                <li>Implementación fácil con capacitación, soporte y actualizaciones continuas.</li></strong>
            </ul>
        </div>
    </div>
</section>

<footer class="bg-blue-600 text-white text-center p-3">
    <p>© 2024 InventoryPlusManager. Todos los derechos reservados.</p>
</footer>
</body>
</html>
