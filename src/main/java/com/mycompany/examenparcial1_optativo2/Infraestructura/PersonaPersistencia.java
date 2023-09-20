
package com.mycompany.examenparcial1_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonaPersistencia {
        private Conexiones conexion;

    public PersonaPersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(Personas persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO personas(" +
                    "id_ciudad, " +
                    "nombre, " +
                    "apellido, " +
                    "tipo_documento, " +
                    "nro_documento, " +
                    "direccion," +
                    "celular, " +
                    "email, " +
                    "estado) " +
                    "values('" +
                    persona.id_ciudad + "', '" +
                    persona.Nombre + "', '" +
                    persona.Apellido + "', '" +
                    persona.TipoDocumento + "', '" +
                    persona.NroDocumento + "', '" +
                    persona.Direccion + "', '" +
                    persona.Celular + "', '" +
                    persona.Email + "', '" +
                    persona.estado + "')");
            conexion.conexionDB().close();
            return "La persona " + persona.Nombre + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(Personas persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE personas SET " +
                    "nombre = '" + persona.Nombre + "'," +
                    "apellido = '" + persona.Apellido + "'," +
                    "tipo_documento = '" + persona.TipoDocumento + "'," +
                    "nro_documento = '" + persona.NroDocumento + "'," +
                    "direccion = '" + persona.Direccion + "'," +
                    "celular = '" + persona.Celular + "'," +
                    "email = '" + persona.Email + "'," +
                    "estado = '" + persona.estado + "' Where personas.id_persona = " + persona.id_persona);
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.Nombre + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Personas> consultarPersonas() {
    List<Personas> personas = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM personas"));

        while (conexion.getResultadoQuery().next()) {
            Personas persona = new Personas();
            persona.Nombre = conexion.getResultadoQuery().getString("nombre");
            persona.Apellido = conexion.getResultadoQuery().getString("apellido");
            persona.TipoDocumento = conexion.getResultadoQuery().getString("tipo_documento");
            persona.NroDocumento = conexion.getResultadoQuery().getString("nro_documento");
            persona.Direccion = conexion.getResultadoQuery().getString("direccion");
            persona.Celular = conexion.getResultadoQuery().getString("celular");
            persona.Email = conexion.getResultadoQuery().getString("email");
            persona.estado = conexion.getResultadoQuery().getString("estado");
            personas.add(persona);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return personas;
}
    public String eliminarPersona(int persona) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM personas WHERE id_persona = " + persona);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "La persona con ID " + persona + " ha sido eliminada correctamente.";
        } else {
            return "No se encontró ninguna persona con ID " + persona+ ". No se realizó ninguna eliminación.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

}
