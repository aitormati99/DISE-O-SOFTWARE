package servidor.appService;

import java.rmi.RemoteException;
import servidor.dao.Idao;
import servidor.gateway.Gateway;
import servidor.dao.Dao;

import servidor.ld.Usuario;
import servidor.ld.Commit;
import servidor.ld.Equipo;
import servidor.ld.Proyecto;

public class AppService{

    //lo que falta en el gateway como parameto dependera de lo que busquemos
    private Gateway gateway = new Gateway();
    private Dao dao = new Dao();

    public boolean buscar (String pais, String afiliacion) throws  RemoteException{
        boolean ValBusqueda = false;
    //seguir adelante
        return ValBusqueda;
    }
    public boolean buscar1(String pais, String afiliacion) throws RemoteException{

        //return dao.buscar(pais,afiliacion);
        boolean valBusqueda=false;
        //valBusqueda=dao.buscar(pais,afiliacion);
        return valBusqueda;
    }

    public Dao mapeo()throws RemoteException{

    }

    public boolean extraer()throws RemoteException{

       //creo que los tipos de return tenemos mal
        //return gateway.extraer();
        //dao.guardar();
    }

}
