package cliente.controller;


import cliente.lp.PantallaInicial;
import cliente.serviceLocator.ServiceLocator;
import servidor.façada.IFaçada;

import java.rmi.RemoteException;

public class Controller {

    private ServiceLocator rsl = null;
    private IFaçada fachada;

    public Controller(String [] args) throws RemoteException
    {
        //creamos el servicelocator y el gui
        rsl = new ServiceLocator();
        rsl.setService(args);
        fachada = rsl.getService();

        PantallaInicial frame = new PantallaInicial();
        frame.setVisible(true);

    }

    public ServiceLocator buscar(String pais, String afiliacion){
    }


}
