package inventoryplusmanager.demo1.controller;

import inventoryplusmanager.demo1.model.Categoria;
import inventoryplusmanager.demo1.model.data.DBGenerator;
import inventoryplusmanager.demo1.model.data.DBConnector;
import inventoryplusmanager.demo1.model.Producto;
import inventoryplusmanager.demo1.model.data.dao.ProductoDAO;
import inventoryplusmanager.demo1.model.Marca;
import inventoryplusmanager.demo1.model.data.dao.MarcaDAO;
import inventoryplusmanager.demo1.model.data.dao.CategoriaDAO;






import org.jooq.DSLContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static inventoryplusmanager.demo1.model.data.DBConnector.connection;

@WebServlet(name = "registroProductoServlet", value = "/registroProducto")
public class RegistroProductoServlet extends HttpServlet {
    private static final String nombreDataBase = "GestionInventarioDB";

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD(nombreDataBase);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreProducto = request.getParameter("nombreProducto");
        String descripcion = request.getParameter("descripcion");
        String categoriaIdStr = request.getParameter("categoriaId");
        String precioStr = request.getParameter("precio");

        int categoriaId;
        double precio;

        try {
            categoriaId = Integer.parseInt(categoriaIdStr);
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("registroProducto.jsp?error=true");
            return;
        }

        try {
            DSLContext query = DBGenerator.conectarBD(nombreDataBase);

            if (!ProductoDAO.validarExistenciaProducto(query, nombreProducto)) {
                // Assuming id is auto-incremented in the database and can be set to 0 or omitted
                int id = 0; // or you can modify accordingly if id needs to be set
                // Assuming Marca and Categoria are already fetched/created objects
                int idMarca;
                try {
                    idMarca = Integer.parseInt(request.getParameter("idMarca"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    response.sendRedirect("registroProducto.jsp?error=true");
                    return;
                }
                Marca marca = MarcaDAO.getMarcaById(query, idMarca); // Modify as needed to get Marca object
                Categoria categoria = CategoriaDAO.getCategoriaById(query, categoriaId); // Modify as needed to get Categoria object

                int stock = 0; // Assuming stock is 0 by default, modify as needed
                Producto producto = new Producto(id, nombreProducto, precio, stock, marca, categoria);
                ProductoDAO.registrarProducto(query, producto);
                response.sendRedirect("registro_exitoso.jsp");
            } else {
                response.sendRedirect("registroProducto.jsp?error=true");
            }
            DBConnector.closeConnection(DBConnector.connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("registroProducto.jsp?error=true");
        }




    }


}

