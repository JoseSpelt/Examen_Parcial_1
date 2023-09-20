
package com.mycompany.examenparcial1_optativo2.Servicios;

import com.mycompany.examenparcial1_optativo2.Infraestructura.PersonaPersistencia;
import com.mycompany.examenparcial1_optativo2.Infraestructura.Personas;
import java.util.List;


public class Persona {
  PersonaPersistencia personasDB;
    public Persona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new PersonaPersistencia(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(Personas persona){
        if(validarDatos(persona)){
           return personasDB.registrarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarPersona(Personas persona){
        if(validarDatos(persona)){
            return personasDB.modificarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public List<Personas> consultarPersona(){
        return  personasDB.consultarPersonas();
    }
    
    public String eliminarPersona(int persona){
        return personasDB.eliminarPersona(persona);
    }

    private boolean validarDatos(Personas persona) {
        try {
        if(persona.Nombre.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (persona.Nombre.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
