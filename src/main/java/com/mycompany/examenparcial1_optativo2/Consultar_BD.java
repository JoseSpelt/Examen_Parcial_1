

package com.mycompany.examenparcial1_optativo2;


import com.mycompany.examenparcial1_optativo2.Infraestructura.Personas;
import com.mycompany.examenparcial1_optativo2.Servicios.Persona;
import java.util.List;


public class Consultar_BD {

    public static void main(String[] args) {
        Persona persona_persistencia = new Persona("postgres", "Invocador1998", "localhost", "5432", "Parcial 1");
        // este bloque de codigo ingresa un registro nuevo en la tabla personas
        
        Personas persona1 = new Personas();
        persona1.Nombre = "Juan";
        persona1.id_ciudad = 1;
        persona1.Apellido = "Lopez";
        persona1.TipoDocumento = "CI";
        persona1.NroDocumento = "5729790";
        persona1.Direccion = "Avda Von Grutter";
        persona1.Celular = "09941141128";
        persona1.Email = "josespelt6@gmail.com";
        persona1.estado = "Soltero";
        persona_persistencia.registrarPersona(persona1);
        
        // este bloque del codigo realiza la consulta a la base de datos y trae los datos de la tabla personas
        List<Personas> listaPersonas = persona_persistencia.consultarPersona();
        for (Personas persona : listaPersonas) {
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Apellido: " + persona.getApellido());

        }
        
        // este bloque del codigo realiza una modificacion en la tabla personas de la base de datos
        
      Personas persona2 = new Personas();
        persona2.Nombre = "Jose";
        persona2.id_persona = 1;
        persona2.Apellido = "Spelt";
        persona2.TipoDocumento = "CI";
        persona2.NroDocumento = "5729790";
        persona2.Direccion = "Avda Von Grutter";
        persona2.Celular = "09941141128";
        persona2.Email = "josespelt6@gmail.com";
        persona2.estado = "Soltero";
        persona_persistencia.modificarPersona(persona2);
        
        // este bloque de codigo realiza un delete en la base de datos de la tabla personas
        
        String resultado = persona_persistencia.eliminarPersona(1);
        System.out.println(resultado);
    }
}

