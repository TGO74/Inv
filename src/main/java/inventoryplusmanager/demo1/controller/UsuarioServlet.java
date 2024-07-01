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

@WebServlet(name = "UsuarioServlet", value = "/usuario")
public class UsuarioServlet extends HttpServlet {
    private static final String nombreDataBase = "GestionInventarioDB";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            DSLContext query = DBGenerator.conectarBD(nombreDataBase);

            switch (action) {
                case "create":
                    crearUsuario(request, response, query);
                    break;
                case "update":
                    actualizarUsuario(request, response, query);
                    break;
                case "delete":
                    eliminarUsuario(request, response, query);
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
        try {
            DSLContext query = DBGenerator.conectarBD(nombreDataBase);
            Object[] usuarios = UsuarioDAO.getIDUsuarios(query);
            request.setAttribute("usuarios", usuarios);
            DBConnector.closeConnection(query.configuration().connectionProvider().acquire());
            request.getRequestDispatcher("listaUsuarios.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void crearUsuario(HttpServletRequest request, HttpServletResponse response, DSLContext query) throws IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!UsuarioDAO.validarExistenciaUsuario(query, email, password)) {
            Usuario usuario = new Usuario(nombreUsuario, email, password);
            UsuarioDAO.registrarUsuario(query, usuario);
            response.sendRedirect("RegistroExitoso.jsp");
        } else {
            response.sendRedirect("RegistroUsuario.jsp?error=true");
        }
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response, DSLContext query) throws IOException {
        // Implementar lógica de actualización de usuario

        String nombreUsuario = request.getParameter("nombreUsuario");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = new Usuario(nombreUsuario, email, password);
        UsuarioDAO.actualizarUsuario(query, usuario);

    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response, DSLContext query) throws IOException {
        // Implementar lógica de eliminación de usuario

        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = new Usuario();
        usuario.setId(id);
        UsuarioDAO.eliminarUsuario(query, usuario);

    }

    //validarExistenciaUsuario

    private void validarExistenciaUsuario(HttpServletRequest request, HttpServletResponse response, DSLContext query) throws IOException {
        // Implementar lógica de validación de usuario

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (UsuarioDAO.validarExistenciaUsuario(query, email, password)) {
            response.sendRedirect("RegistroUsuario.jsp?error=true");
        } else {
            response.sendRedirect("RegistroUsuario.jsp");
        }
    }


}
