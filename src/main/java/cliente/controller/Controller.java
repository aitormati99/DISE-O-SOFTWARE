package cliente.controller;


import cliente.serviceLocator.ServiceLocator;
import servidor.façada.IFaçada;

import java.rmi.RemoteException;

public class Controller {

    private ServiceLocator rsl = null;
    private IFaçada fachada;

    public Controller(String [] args) throws RemoteException
    {
        //creamos el servicelocator y el gui
    }

    public ServiceLocator buscar(String pais, String afiliacion){

    }


}
