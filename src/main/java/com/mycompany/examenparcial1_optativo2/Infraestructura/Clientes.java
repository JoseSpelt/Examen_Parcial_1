
package com.mycompany.examenparcial1_optativo2.Infraestructura;


public class Clientes {
    public int id_cliente;
    public int id_persona;
    public String FechaIngreso;
    public String Calificacion;
    public String estado;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(String Calificacion) {
        this.Calificacion = Calificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
