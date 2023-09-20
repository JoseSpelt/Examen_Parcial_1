
package com.mycompany.examenparcial1_optativo2;

import com.mycompany.examenparcial1_optativo2.Infraestructura.Ciudades;
import com.mycompany.examenparcial1_optativo2.Servicios.Ciudad;
import java.util.List;


public class CiudadPrueba {
    public static void main(String[] args) {
        Ciudad ciudad_persistencia = new Ciudad("postgres", "Invocador1998", "localhost", "5432", "Parcial 1");
        // este bloque de codigo ingresa un registro nuevo en la tabla personas
        
        List<Ciudades> listaCiudades = ciudad_persistencia.consultarCiudad();
        for (Ciudades ciudad : listaCiudades) {
        System.out.println("ID ciudad: " + ciudad.id_ciudad);
        System.out.println("Nombre de Ciudad: " + ciudad.NombreCiudad);
        System.out.println("Departamento: " + ciudad.Departamento);
        System.out.println("Codigo Postal: " + ciudad.CodigoPostal);
        }
    }
}
