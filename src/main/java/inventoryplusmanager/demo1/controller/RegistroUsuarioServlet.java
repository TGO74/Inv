package inventoryplusmanager.demo1.controller;

import inventoryplusmanager.demo1.model.Usuario;
import inventoryplusmanager.demo1.model.data.DBConnector;
import inventoryplusmanager.demo1.model.data.DBGenerator;
import inventoryplusmanager.demo1.model.data.dao.UsuarioDAO;
import org.jooq.DSLContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "RegistroUsuarioServlet", value = "/RegistroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    public static final String nombreDataBase = "GestionInventarioDB";

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
        String nombreUsuario = request.getParameter("nombreUsuario");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Connection connection = null;

        try {
            connection = DBConnector.connection(nombreDataBase, "root", "");
            DSLContext query = DBGenerator.actualizarConexion(connection, nombreDataBase);

            if (!UsuarioDAO.validarExistenciaUsuario(query, email, password)) {
                Usuario usuario = new Usuario(nombreUsuario, email, password);
                UsuarioDAO.registrarUsuario(query, usuario);
                response.sendRedirect("RegistroExitoso.jsp");
            } else {
                response.sendRedirect("RegistroUsuario.jsp?error=true");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("RegistroUsuario.jsp?error=true");
        } finally {
            if (connection != null) {
                DBConnector.closeConnection(connection);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;

        try {
            connection = DBConnector.connection(nombreDataBase, "root", "");
            DSLContext query = DBGenerator.actualizarConexion(connection, nombreDataBase);
            Object[] usuarios = UsuarioDAO.getIDUsuarios(query);
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("listaUsuarios.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            if (connection != null) {
                DBConnector.closeConnection(connection);
            }
        }
    }
}
