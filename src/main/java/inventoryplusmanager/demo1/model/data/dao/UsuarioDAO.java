package inventoryplusmanager.demo1.model.data.dao;

import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import inventoryplusmanager.demo1.model.Usuario;
import org.jetbrains.annotations.NotNull;


import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class UsuarioDAO {

    public static void registrarUsuario(DSLContext query, Usuario usuario) {
        Table<?> tablaUsuario = table(name("Usuario"));
        query.insertInto(tablaUsuario, DSL.field("nombreUsuario"), DSL.field("email"), DSL.field("password"))
                .values(usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword())
                .execute();
    }

    public static boolean validarExistenciaUsuario(DSLContext query, String email, String password) {
        Result<Record> resultados = query.select()
                .from("Usuario")
                .where(DSL.field("email").eq(email))
                .fetch();
        return resultados.size() > 0;
    }

    // Método para obtener IDs de usuarios
    public static Object[] getIDUsuarios(DSLContext query) {
        Table<?> usuario = DSL.table("Usuario");
        @NotNull Result<? extends Record1<?>> resultados = query.select(usuario.field("idUsuario")).from(usuario).fetch();
        if (resultados.isEmpty()) {
            return new String[]{"Error: no existen usuarios"};
        } else {
            return resultados.getValues(usuario.field("idUsuario")).toArray();
        }
    }

    // Método para obtener nombres de usuarios
    public static Object[] getNombreUsuarios(DSLContext query) {
        Table<?> usuario = DSL.table("Usuario");
        @org.jetbrains.annotations.NotNull Result<? extends Record1<?>> resultados = query.select(usuario.field("nombreUsuario")).from(usuario).fetch();
        if (resultados.isEmpty()) {
            return new String[]{"Error: no existen usuarios"};
        } else {
            return resultados.getValues(usuario.field("nombreUsuario")).toArray();
        }
    }

    // Método para exportar datos de usuarios
    public static String[][] exportarDatos(DSLContext query) {
        Result<Record> resultados = query.select()
                .from("Usuario")
                .fetch();
        return exportarDatos(resultados);
    }

    private static String[][] exportarDatos(Result<Record> resultados) {
        String[][] datosResultado = new String[resultados.size()][3];
        for (int registro = 0; registro < resultados.size(); registro++) {
            datosResultado[registro][0] = String.valueOf(resultados.getValue(registro, "idUsuario"));
            datosResultado[registro][1] = (String) resultados.getValue(registro, "nombreUsuario");
            datosResultado[registro][2] = (String) resultados.getValue(registro, "email");
        }
        return datosResultado;
    }
}
