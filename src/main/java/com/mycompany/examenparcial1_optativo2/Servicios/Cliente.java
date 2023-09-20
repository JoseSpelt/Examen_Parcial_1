
package com.mycompany.examenparcial1_optativo2.Servicios;

import com.mycompany.examenparcial1_optativo2.Infraestructura.ClientePersistencia;
import com.mycompany.examenparcial1_optativo2.Infraestructura.Clientes;
import java.util.List;


public class Cliente {
    ClientePersistencia clienteDB;
    public Cliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new ClientePersistencia(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(Clientes cliente){
           return clienteDB.registrarCliente(cliente);
    
    }
    public String modificarCliente(Clientes cliente){
            return clienteDB.modificarCLiente(cliente);
    }


    public List<Clientes> consultarClientes(){
        return  clienteDB.consultarClientes();
    }
    
    public String eliminarCliente(int cliente){
        return clienteDB.eliminarCliente(cliente);
    }


}
