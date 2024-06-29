package inventoryplusmanager.demo1.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InicioUsuarioServlet")
public class InicioUsuarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí puedes cargar datos necesarios para la página
        request.setAttribute("totalProducts", 150); // Ejemplo de datos
        request.setAttribute("lowStockProducts", 10);
        request.setAttribute("totalInventoryValue", 50000);

        // Redirige a InicioUsuario.jsp con los datos cargados
        request.getRequestDispatcher("InicioUsuario.jsp").forward(request, response);
    }
}
