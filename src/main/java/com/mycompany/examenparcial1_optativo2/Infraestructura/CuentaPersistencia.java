
package com.mycompany.examenparcial1_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CuentaPersistencia {
    private Conexiones conexion;

    public CuentaPersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuenta(Cuentas cuenta){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cuentas(" +
                    "id_cliente, " +
                    "nro_cuenta, " +
                    "fecha_alta, " +
                    "tipo_cuenta, " +
                    "estado, " +
                    "saldo, " +
                    "nro_contrato, " +
                    "costo_mantenimiento, " +
                    "prom_acreditacion, " +
                    "moneda) " +
                    "values('" +
                    cuenta.id_cliente + "', '" +
                    cuenta.NumeroCuenta + "', '" +
                    cuenta.FechaAlta +
                    cuenta.TipoCuenta +
                    cuenta.estado +
                    cuenta.Saldo +
                    cuenta.NumeroContrato +
                    cuenta.CostoMantenimiento +
                    cuenta.PromedioAcreditacion +
                    cuenta.Moneda +"')");
            conexion.conexionDB().close();
            return "La Cuenta fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCuenta(Cuentas cuenta){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cuentas SET " +
                    "id_cliente = '" + cuenta.id_cliente + "'," +
                    "nro_cuenta = '" + cuenta.NumeroCuenta + "'," +
                    "fecha_alta = '" + cuenta.FechaAlta +
                    "tipo_cuenta = '" + cuenta.TipoCuenta +
                    "estado = '" + cuenta.estado +
                    "saldo = '" + cuenta.Saldo +
                    "nro_contrato = '" + cuenta.NumeroContrato +
                    "costo_mantenimiento = '" + cuenta.CostoMantenimiento +
                    "prom_acreditacion = '" + cuenta.PromedioAcreditacion +
                    "moneda = '" + cuenta.Moneda+
                    "' Where cuenta.id_cuenta = " + cuenta.id_cuenta);
            conexion.conexionDB().close();
            return "Los datos de la cuenta fueron modificads correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cuentas> consultarCuentas() {
    List<Cuentas> cuentas = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cuentas"));

        while (conexion.getResultadoQuery().next()) {
            Cuentas cuenta = new Cuentas();
            cuenta.NumeroCuenta = conexion.getResultadoQuery().getString("nro_cuenta");
            cuenta.FechaAlta = conexion.getResultadoQuery().getString("fecha_alta");
            cuenta.TipoCuenta = conexion.getResultadoQuery().getString("tipo_cuenta");
            cuenta.estado = conexion.getResultadoQuery().getString("estado");
            cuenta.Saldo = conexion.getResultadoQuery().getString("saldo");
            cuenta.NumeroContrato = conexion.getResultadoQuery().getString("nro_contrato");
            cuenta.CostoMantenimiento = conexion.getResultadoQuery().getString("costo_mantenimiento");
            cuenta.PromedioAcreditacion = conexion.getResultadoQuery().getString("prom_acreditacion");
            cuenta.Moneda = conexion.getResultadoQuery().getString("moneda");

            cuentas.add(cuenta);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return cuentas;
}
    public String eliminarCuenta(int cuenta) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cuentas WHERE id_cuenta = " + cuenta);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "La persona con ID " + cuenta + " ha sido eliminada correctamente.";
        } else {
            return "No se encontró ninguna persona con ID " + cuenta + ". No se realizó ninguna eliminación.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
