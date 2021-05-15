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

    private Gateway gateway = new Gateway();
    private Dao dao = new Dao();


    public Dao buscar(String pais, String afiliacion) throws RemoteException{

        //return dao.buscar(pais,afiliacion);
    }

    public Dao mapeo()throws RemoteException{

    }

    public Gateway extraer()throws RemoteException{

       //creo que los tipos de return tenemos mal
        //return gateway.extraer();
        //dao.guardar();
    }

}
