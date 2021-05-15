package servidor.façada;

import servidor.appService.AppService;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFaçada extends Remote{

    public AppService buscar(String pais, String afiliacion)  throws RemoteException;
}
