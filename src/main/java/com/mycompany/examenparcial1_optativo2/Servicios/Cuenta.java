
package com.mycompany.examenparcial1_optativo2.Servicios;

import com.mycompany.examenparcial1_optativo2.Infraestructura.CuentaPersistencia;
import com.mycompany.examenparcial1_optativo2.Infraestructura.Cuentas;
import java.util.List;


public class Cuenta {
    CuentaPersistencia clienteDB;
    public Cuenta(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new CuentaPersistencia(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuenta(Cuentas cuenta){
           return clienteDB.registrarCuenta(cuenta);
    
    }
    public String modificarCuenta(Cuentas cuenta){
            return clienteDB.modificarCuenta(cuenta);
    }


    public List<Cuentas> consultarCuentas(){
        return  clienteDB.consultarCuentas();
    }
    
    public String eliminarCuenta(int cuenta){
        return clienteDB.eliminarCuenta(cuenta);
    }

}
