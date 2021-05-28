package cliente.serviceLocator;
import servidor.remote.IFachada;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ServiceLocator {

    private IFachada stubServer = null;
    private Registry registry;

    public ServiceLocator()
    {}

    public void setService(String[] args) {

        System.out.println("SETSERVICE");
        if (args.length != 3)
        {
            System.out.println("uso: java [policy] [codebase] cliente.Cliente [host] [port] [server]");
            System.exit(0);
        }

        if (System.getSecurityManager() == null)
        {
            System.setSecurityManager(new SecurityManager());
        }

        String ip = args[0];
        String puerto = args[1];
        String serviceName = args [2];


        try
        {
            this.registry = LocateRegistry.getRegistry(((Integer.valueOf(puerto))));
            String name = "//" + ip+ ":" + puerto + "/" + serviceName;
            //stubServer = (IServer) java.rmi.Naming.lookup(name);
            this.stubServer = (IFachada) registry.lookup(name);


        }
        catch (Exception e)
        {
            System.err.println("- Exception running the client: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public IFachada getService()
    {

        System.out.println("GETSERVICE");
        return stubServer;
    }


}
