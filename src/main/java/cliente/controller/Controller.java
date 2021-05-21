package cliente.controller;


import cliente.lp.PantallaInicial;
import cliente.serviceLocator.ServiceLocator;
import servidor.façada.IFaçada;

import java.rmi.RemoteException;

public class Controller {

    private ServiceLocator serviceLocator = null;
    private IFaçada fachada;

    public Controller(String [] args) throws RemoteException
    {
        //creamos el servicelocator y el gui
        serviceLocator = new ServiceLocator();
        serviceLocator.setService(args);
        fachada = serviceLocator.getService();

        //Pasarle al frame el controller
        PantallaInicial frame = new PantallaInicial(this);
        frame.setVisible(true);

    }

   /** public ServiceLocator buscar(String pais, String afiliacion) throws RemoteException {

        //nose como poner porque ensi teoricamente es esto pero devuelve fachada
       // return serviceLocator.buscar(pais,afiliacion);
        return null;

    }**/
   //¿? si habría que hacer el return desde SL, creo que para RMI
   //codigo--> return serviceLocator.getService().buscar();
    public boolean buscar(String pais, String afiliacion) throws RemoteException {
        boolean ValBusqueda = false;
        ValBusqueda = fachada.buscar(pais, afiliacion);

        return ValBusqueda;

    }

    public static void main(String[]args)throws RemoteException{
        new Controller(args);
    }

}
