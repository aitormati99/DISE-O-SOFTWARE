package cliente.serviceLocator;

import servidor.façada.Façada;
import servidor.façada.IFaçada;

public class ServiceLocator {

    private IFaçada façada;

    public ServiceLocator()
    {}
    public Façada buscar(String pais, String afiliacion) {

    }

    public void setService(String[] args) {

        String ip = args[0];
        String puerto = args[1];
        String serviceName = args [2];

    }

    public IFaçada getService()
    {
        return façada;
    }

    public void target(){
        //NO SABEMOOOS COMO SE HACE
    }
}
