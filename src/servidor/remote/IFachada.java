package servidor.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFachada extends Remote{

    boolean buscar(String pais, String afiliacion)  throws RemoteException;
}
