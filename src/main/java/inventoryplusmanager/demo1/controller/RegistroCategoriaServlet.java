package inventoryplusmanager.demo1.controller;

import inventoryplusmanager.demo1.model.Categoria;
import inventoryplusmanager.demo1.model.data.dao.CategoriaDAO;
import inventoryplusmanager.demo1.model.data.DBConnector;
import inventoryplusmanager.demo1.model.data.DBGenerator;

import org.jooq.DSLContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static inventoryplusmanager.demo1.model.data.DBConnector.connection;

@WebServlet(name = "registroCategoriaServlet", value = "/registroCategoria")
public class RegistroCategoriaServlet extends HttpServlet {
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
        String nombreCategoria = request.getParameter("nombreCategoria");

        try {
            DSLContext query = DBGenerator.conectarBD(nombreDataBase);

            if (!CategoriaDAO.validarExistenciaCategoria(query, nombreCategoria)) {
                Categoria categoria = new Categoria(nombreCategoria);
                CategoriaDAO.registrarCategoria(query, categoria);
                response.sendRedirect("registro_exitoso.jsp");
            } else {
                response.sendRedirect("registroCategoria.jsp?error=true");
            }
            DBConnector.closeConnection(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("registroCategoria.jsp?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implementa el método GET si es necesario, por ejemplo, para obtener las categorías existentes
        try {
            DSLContext query = DBGenerator.conectarBD(nombreDataBase);
            Object[] categorias = CategoriaDAO.getIDCategorias(query);
            request.setAttribute("categorias", categorias);
            DBConnector.closeConnection(connection);
            request.getRequestDispatcher("listaCategorias.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
