
package com.mycompany.examenparcial1_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MovimientoPersistencia {
        private Conexiones conexion;

    public MovimientoPersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(Movimientos movimiento){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO movimientos(" +
                    "id_cuenta, " +
                    "fecha_movimiento, " +
                    "tipo_movimiento, " +
                    "saldo_anterior, " +
                    "saldo_actual, " +
                    "monto_movimiento, " +
                    "cuenta_origen, " +
                    "canal) " +
                    "values('" +
                    movimiento.id_cuenta + "', '" +
                    movimiento.FechaMovimiento + "', '" +
                    movimiento.TipoMovimiento +
                    movimiento.SaldoAnterior +
                    movimiento.SaldoActual +
                    movimiento.MontoMovimiento +
                    movimiento.CuentaOrigen +
                    movimiento.Canal + "')");
            conexion.conexionDB().close();
            return "El movimiento fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarMovimiento(Movimientos movimiento){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE movimientos SET " +
                    "id_cuenta = '" + movimiento.id_cuenta + "'," +
                    "fecha_movimiento = '" + movimiento.FechaMovimiento + "'," +
                    "tipo_movimiento = '" + movimiento.TipoMovimiento + "'," +
                    "saldo_anterior= '" + movimiento.SaldoAnterior + "'," +
                    "saldo_actual= '" + movimiento.SaldoActual + "'," +
                    "monto_movimiento = '" + movimiento.MontoMovimiento + "'," +
                    "cuenta_origen = '" + movimiento.CuentaOrigen + "'," +
                    "canal = '" + movimiento.Canal + "'," +
                    "' Where movimientos.id_movimiento = " + movimiento.id_movimiento);
            conexion.conexionDB().close();
            return "Los datos de la cuenta fueron modificads correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movimientos> consultarMovimiento() {
    List<Movimientos> movimientos = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM movimientos"));

        while (conexion.getResultadoQuery().next()) {
            Movimientos movimiento = new Movimientos();
            movimiento.FechaMovimiento = conexion.getResultadoQuery().getString("fecha_movimiento");
            movimiento.TipoMovimiento = conexion.getResultadoQuery().getString("tipo_movimiento");
            movimiento.SaldoAnterior = conexion.getResultadoQuery().getString("saldo_anterior");
            movimiento.SaldoActual = conexion.getResultadoQuery().getString("saldo_actual");
            movimiento.MontoMovimiento = conexion.getResultadoQuery().getString("monto_movimiento");
            movimiento.CuentaOrigen = conexion.getResultadoQuery().getString("cuenta_origen");
            movimiento.Canal = conexion.getResultadoQuery().getString("canal");

            movimientos.add(movimiento);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return movimientos;
}
    public String eliminarMovimiento(int movimiento) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM movimientos WHERE id_movimiento = " + movimiento);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "El movimiento con ID " + movimiento + " ha sido eliminada correctamente.";
        } else {
            return "No se encontró ninguna movimiento con ID " + movimiento + ". No se realizó ninguna eliminación.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
