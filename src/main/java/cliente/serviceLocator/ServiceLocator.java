package cliente.serviceLocator;

import servidor.façada.Façada;
import servidor.façada.IFaçada;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ServiceLocator {

    private IFaçada stubServer = null;
    private Registry registry;

    public ServiceLocator()
    {}

    public void setService(String[] args) {

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
            this.stubServer = (IFaçada) registry.lookup(name);


        }
        catch (Exception e)
        {
            System.err.println("- Exception running the client: " + e.getMessage());
            e.printStackTrace();
        }

    }
    //la llamada al servidor, hay que hacer algo de jetty?
    public IFaçada getService()
    {
        return stubServer;
    }


    public boolean buscar(String pais, String afiliacion) {

          

        //boolean ValBusqueda = false;
        //return IFaçada.buscar(pais, afiliacion);
        return false;

    }

    //YO CREO QUE NO HACE FALTA
    public void target(){
        //NO SABEMOOOS COMO SE HACE
    }
}
