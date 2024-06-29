package inventoryplusmanager.demo1.controller;

import inventoryplusmanager.demo1.model.data.DBConnector;
import inventoryplusmanager.demo1.model.data.DBGenerator;
import inventoryplusmanager.demo1.model.data.dao.UsuarioDAO;
import org.jooq.DSLContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static inventoryplusmanager.demo1.model.data.DBConnector.connection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String nombreDataBase = "GestionInventarioDB";

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD(nombreDataBase);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Aquí debes implementar la lógica de autenticación
        boolean isAuthenticated = authenticateUser(email, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            response.sendRedirect("InicioUsuario.jsp");
        } else {
            response.sendRedirect("index.jsp?error=1");
        }
    }

    private boolean authenticateUser(String email, String password) {
        boolean isAuthenticated = false;

        try {
            DSLContext query = DBGenerator.conectarBD(nombreDataBase);
            isAuthenticated = UsuarioDAO.validarExistenciaUsuario(query, email, password);
            DBConnector.closeConnection(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }
}
