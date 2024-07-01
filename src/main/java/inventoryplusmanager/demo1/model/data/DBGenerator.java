package inventoryplusmanager.demo1.model.data;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaMarca(create);
        crearTablaCategoria(create);
        crearTablaProducto(create);
        crearTablaUsuario(create);
        DBConnector.closeConnection(connection);
    }

    public static DSLContext conectarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombreBD, "root", "");
        return DSL.using(connection);
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) throws ClassNotFoundException {
        DBConnector.closeConnection(connection);
        connection = DBConnector.connection(nombreBD, "root", "");
        return DSL.using(connection);
    }

    private static void crearTablaProducto(DSLContext create) {
        create.createTableIfNotExists("Producto")
                .column("id", INTEGER.identity(true))
                .column("nombre", VARCHAR(100))
                .column("precio", DOUBLE)
                .column("stock", INTEGER)
                .column("marca", INTEGER)
                .column("categoria", INTEGER)
                .constraint(primaryKey("id"))
                .constraint(foreignKey("marca").references("Marca", "idMarca"))
                .constraint(foreignKey("categoria").references("Categoria", "idCategoria"))
                .execute();
    }

    private static void crearTablaMarca(DSLContext create) {
        create.createTableIfNotExists("Marca")
                .column("idMarca", INTEGER.identity(true))
                .column("nombreMarca", VARCHAR(50))
                .constraint(primaryKey("idMarca"))
                .execute();
    }

    private static void crearTablaCategoria(DSLContext create) {
        create.createTableIfNotExists("Categoria")
                .column("idCategoria", INTEGER.identity(true))
                .column("nombreCategoria", VARCHAR(50))
                .constraint(primaryKey("idCategoria"))
                .execute();
    }

    private static void crearTablaUsuario(DSLContext create) {
        create.createTableIfNotExists("Usuario")
                .column("idUsuario", INTEGER.identity(true))
                .column("nombreUsuario", VARCHAR(50))
                .column("email", VARCHAR(100))
                .column("password", VARCHAR(100))
                .constraint(primaryKey("idUsuario"))
                .execute();
    }
}
