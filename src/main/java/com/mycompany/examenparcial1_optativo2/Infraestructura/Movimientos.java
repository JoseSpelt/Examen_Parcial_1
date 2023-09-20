
package com.mycompany.examenparcial1_optativo2.Infraestructura;

public class Movimientos {
    public int id_movimiento;
    public int id_cuenta;
    public String FechaMovimiento;
    public String TipoMovimiento;
    public String SaldoAnterior;
    public String SaldoActual;
    public String MontoMovimiento;
    public String CuentaOrigen;
    public String Canal;

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getFechaMovimiento() {
        return FechaMovimiento;
    }

    public void setFechaMovimiento(String FechaMovimiento) {
        this.FechaMovimiento = FechaMovimiento;
    }

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public void setTipoMovimiento(String TipoMovimiento) {
        this.TipoMovimiento = TipoMovimiento;
    }

    public String getSaldoAnterior() {
        return SaldoAnterior;
    }

    public void setSaldoAnterior(String SaldoAnterior) {
        this.SaldoAnterior = SaldoAnterior;
    }

    public String getSaldoActual() {
        return SaldoActual;
    }

    public void setSaldoActual(String SaldoActual) {
        this.SaldoActual = SaldoActual;
    }

    public String getMontoMovimiento() {
        return MontoMovimiento;
    }

    public void setMontoMovimiento(String MontoMovimiento) {
        this.MontoMovimiento = MontoMovimiento;
    }

    public String getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(String CuentaOrigen) {
        this.CuentaOrigen = CuentaOrigen;
    }

    public String getCanal() {
        return Canal;
    }

    public void setCanal(String Canal) {
        this.Canal = Canal;
    }
    
    
    
}
