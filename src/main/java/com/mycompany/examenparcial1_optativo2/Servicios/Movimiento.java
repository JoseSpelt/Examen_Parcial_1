
package com.mycompany.examenparcial1_optativo2.Servicios;

import com.mycompany.examenparcial1_optativo2.Infraestructura.MovimientoPersistencia;
import com.mycompany.examenparcial1_optativo2.Infraestructura.Movimientos;
import java.util.List;


public class Movimiento {
    MovimientoPersistencia movimientoDB;
    public Movimiento(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        movimientoDB = new MovimientoPersistencia(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(Movimientos movimiento){
           return movimientoDB.registrarMovimiento(movimiento);
    
    }
    public String modificarMovimiento(Movimientos movimiento){
            return movimientoDB.modificarMovimiento(movimiento);
    }


    public List<Movimientos> consultarMovimiento(){
        return  movimientoDB.consultarMovimiento();
    }
    
    public String eliminarMovimiento(int movimiento){
        return movimientoDB.eliminarMovimiento(movimiento);
    }
 
}
