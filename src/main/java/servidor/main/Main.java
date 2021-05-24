package servidor.main;

import servidor.façada.Façada;
import servidor.façada.IFaçada;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    private static IFaçada fachada;

    public static void main(String [] args) throws RemoteException
    {
        String ip = args[0];
        String puerto = args[1];
        String serviceName = args[2];

        fachada = new Façada();

        if (System.getSecurityManager() == null)
        {
            System.setSecurityManager(new SecurityManager());
        }
        try {

            Registry registry = LocateRegistry.createRegistry(((Integer.valueOf(puerto))));
            String name = "//" + ip + ":" + puerto + "/" + serviceName;

            System.out.println("El name es: " + name + "\n");

            registry.rebind(name, fachada);
        }

        catch (Exception e) {
            System.err.println("- Exception running the server (main): " + e.getMessage() );
            e.printStackTrace();
        }
    }
}
