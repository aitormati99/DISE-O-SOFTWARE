package servidor.façada;

import servidor.appService.AppService;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;
import java.util.HashMap;

public class Façada extends UnicastRemoteObject implements IFaçada  {

    private AppService appservice=new AppService();


    public Façada() throws RemoteException {

        //NOSE SI ESTO VA AQUI PERO SEGUN SUS EJEMPLOS SII
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        //nose de donde sacar los puertos, ip y eso del servicelocator
        String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

        try
        {
            IFaçada objServer = new Façada();
            Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
            //Naming.rebind(name, objServer);
            registry.rebind(name, objServer);

        }
        catch (Exception e)
        {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public AppService buscar(String pais, String afiliacion)  throws RemoteException{

        //NOSE QUE PONER
       // return appservice.buscar(pais,afiliacion);
        return null;
    }

}

