package servidor.façada;

import cliente.controller.Controller;
import servidor.appService.AppService;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;
import java.util.HashMap;

public class Façada extends UnicastRemoteObject implements IFaçada  {

    //private static final long serialVersionUID = 1L;

    private AppService appservice=new AppService();

    public Façada() throws RemoteException {
        //A
        super();
    }

    @Override
    public boolean buscar(String pais, String afiliacion) throws RemoteException {

        boolean ValBusqueda = false;
        return appservice.buscar(pais, afiliacion);

    }

}

