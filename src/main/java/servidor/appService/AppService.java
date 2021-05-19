package servidor.appService;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import servidor.dao.Idao;
import servidor.gateway.Gateway;
import servidor.dao.Dao;

import servidor.ld.Usuario;
import servidor.ld.Commit;
import servidor.ld.Equipo;
import servidor.ld.Proyecto;

import javax.ws.rs.core.Response;

public class AppService{

    //lo que falta en el gateway como parameto dependera de lo que busquemos
    private Gateway gateway = new Gateway();

    private Dao dao = new Dao();
    ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
    ArrayList<Commit> listaCommit=new ArrayList<Commit>();
    ArrayList<Equipo> listaEquipos=new ArrayList<Equipo>();
    ArrayList<Proyecto> listaProyectos=new ArrayList<Proyecto>();


    private int id_equipo=0;

    public boolean buscar (String pais, String afiliacion) throws  RemoteException{

        boolean val=dao.buscarUsuarios(pais,afiliacion);
        boolean val1= dao.buscarCommits(pais,afiliacion);
        boolean val2=dao.buscarEquipos(pais,afiliacion);
        boolean val3=dao.buscarProyectos(pais,afiliacion);

        //DEPENDE CUANTOS METODOS EXTRAER HAGAMOS EN GATEWAY LLAMAREMOS A ESOS
        gateway.extraerUsuarioNombre();

        listaUsuarios= gateway.getListaUsuarios();
        listaCommit= gateway.getListaCommit();
        listaEquipos= gateway.getListaEquipos();
        listaProyectos= gateway.getListaProyectos();

        guardarDao();

        return val;

    }

    public void guardarDao(){

        dao.guardar(listaUsuarios);
        dao.guardar(listaCommit);
        dao.guardar(listaEquipos);
        dao.guardar(listaProyectos);
        //dao.guardar(listaUsuarios, listaCommit, listaEquipos, listaProyectos);

    }






}
