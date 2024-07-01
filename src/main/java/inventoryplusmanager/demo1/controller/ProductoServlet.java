package inventoryplusmanager.demo1.controller;

import inventoryplusmanager.demo1.model.Categoria;
import inventoryplusmanager.demo1.model.Marca;
import inventoryplusmanager.demo1.model.Producto;
import inventoryplusmanager.demo1.model.data.DBConnector;
import inventoryplusmanager.demo1.model.data.DBGenerator;
import inventoryplusmanager.demo1.model.data.dao.ProductoDAO;
import org.jooq.DSLContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductoServlet", value = "/producto")
public class ProductoServlet extends HttpServlet {
    private static final String nombreDataBase = "GestionInventarioDB";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            DSLContext query = DBGenerator.conectarBD(nombreDataBase);

            switch (action) {
                case "create":
                    crearProducto(request, response, query);
                    break;
                case "update":
                    actualizarProducto(request, response, query);
                    break;
                case "delete":
                    eliminarProducto(request, response, query);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }

            DBConnector.closeConnection(query.configuration().connectionProvider().acquire());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implementar lógica para manejar GET (listar productos, etc.)
    }

    private void crearProducto(HttpServletRequest request, HttpServletResponse response, DSLContext query) throws IOException {
        String nombreProducto = request.getParameter("nombreProducto");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Marca marca = new Marca(request.getParameter("nombreMarca"));
        Categoria categoria = new Categoria(request.getParameter("nombreCategoria"));

        Producto producto = new Producto(nombreProducto, precio, stock, marca, categoria);
        ProductoDAO.registrarProducto(query, producto);
        response.sendRedirect("RegistroExitoso.jsp");
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response, DSLContext query) throws IOException {
        // Implementar lógica de actualización de producto aquí
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response, DSLContext query) throws IOException {
        // Implementar lógica de eliminación de producto aquí
    }
}
