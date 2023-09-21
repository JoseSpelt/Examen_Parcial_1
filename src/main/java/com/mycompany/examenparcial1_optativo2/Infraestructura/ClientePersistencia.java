
package com.mycompany.examenparcial1_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientePersistencia {
           private Conexiones conexion;

    public ClientePersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(Clientes cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cliente(" +
                    "id_persona, " +
                    "fecha_ingreso, " +
                    "calificacion, " +
                    "estado) " +
                    "values('" +
                    cliente.id_persona + "', '" +
                    cliente.FechaIngreso + "', '" +
                    cliente.Calificacion +
                    cliente.estado + "')");
            conexion.conexionDB().close();
            return "El cliente  fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCLiente(Clientes cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cliente SET " +
                    "id_persona = '" + cliente.id_persona + "'," +
                    "fecha_ingreso = '" + cliente.FechaIngreso + "'," +
                    "calificacion = '" +
                    "estado = '" + cliente.estado + "' Where cleinte.id_cliente = " + cliente.id_cliente);
            conexion.conexionDB().close();
            return "Los datos del cliente fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Clientes> consultarClientes() {
    List<Clientes> clientes = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cliente"));

        while (conexion.getResultadoQuery().next()) {
            Clientes cliente = new Clientes();
            cliente.id_cliente = conexion.getResultadoQuery().getInt("id_cliente");
            cliente.id_persona = conexion.getResultadoQuery().getInt("id_persona");
            cliente.FechaIngreso = conexion.getResultadoQuery().getString("fecha_ingreso");
            cliente.Calificacion = conexion.getResultadoQuery().getString("calificacion");
            cliente.estado = conexion.getResultadoQuery().getString("estado");


            clientes.add(cliente);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return clientes;
}
    public String eliminarCliente(int cliente) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cliente WHERE id_cliente = " + cliente);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "El cliente con ID " + cliente + " ha sido eliminada correctamente.";
        } else {
            return "No se encontró ningun cliente con ID " + cliente + ". No se realizó ninguna eliminación.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
