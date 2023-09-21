
package com.mycompany.examenparcial1_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadPersistencia {
       private Conexiones conexion;

    public CiudadPersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(Ciudades ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad(" +
                    "nombre_ciudad, " +
                    "departamento, " +
                    "codigo_postal) " +
                    "values('" +
                    ciudad.NombreCiudad + "', '" +
                    ciudad.Departamento + "', '" +
                    ciudad.CodigoPostal + "')");
            conexion.conexionDB().close();
            return "La Ciudad " + ciudad.NombreCiudad + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCiudad(Ciudades ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET " +
                    "nombre_ciudad = '" + ciudad.NombreCiudad + "'," +
                    "departamento = '" + ciudad.Departamento + "'," +
                    "codigo_postal = '" + ciudad.CodigoPostal + "' Where ciudad.id_ciudad = " + ciudad.id_ciudad);
            conexion.conexionDB().close();
            return "Los datos de la ciudad " + ciudad.NombreCiudad + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ciudades> consultarCiudades() {
    List<Ciudades> ciudades = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM ciudad"));

        while (conexion.getResultadoQuery().next()) {
            Ciudades ciudad = new Ciudades();
            ciudad.id_ciudad = conexion.getResultadoQuery().getInt("id_ciudad");
            ciudad.NombreCiudad = conexion.getResultadoQuery().getString("nombre_ciudad");
            ciudad.Departamento = conexion.getResultadoQuery().getString("departamento");
            ciudad.CodigoPostal = conexion.getResultadoQuery().getString("codigo_postal");
            ciudades.add(ciudad);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return ciudades;
}
    public String eliminarCiudad(int ciudad) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM ciudad WHERE id_ciudad = " + ciudad);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "La ciudad con ID " + ciudad + " ha sido eliminada correctamente.";
        } else {
            return "No se encontró ninguna ciudad con ID " + ciudad+ ". No se realizó ninguna eliminación.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
