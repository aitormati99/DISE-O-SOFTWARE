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
    private Gateway gateway;
    private Dao dao = new Dao();
    private ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
    private ArrayList<Commit> listaCommit=new ArrayList<Commit>();
    private ArrayList<Equipo> listaEquipos=new ArrayList<Equipo>();
    private ArrayList<Proyecto> listaProyectos=new ArrayList<Proyecto>();
    private int id_equipo=0;

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

    public void mapeo()throws RemoteException{

        //ENSI ESTA HECHO EN EL EXTRAER
        //FALTARIA UN METODO DE PASARLE TODOS ESTOS ARRAYS DE LISTAS AL DAO PARA QUE LOS GUARDE
    }

    public boolean extraerUsuarioNombre()throws RemoteException{

       //creo que los tipos de return tenemos mal
        //return gateway.extraer();
        //dao.guardar();
        boolean extraido=false;

        try {
            gateway= new Gateway("users");
            Response res1 = gateway.makeGetRequest("");

            // Parse the response as JsonArray
            JSONArray array = res1.readEntity(JSONArray.class);
           //System.out.println(array.size());

            //ESTA PARTE NOSE SI HAY QUE HACERLO EN EL METODO MAPEO DE DAO
            for(int i=0; i<array.size();i++) {
                HashMap<String, String> object1 = (HashMap<String, String>) array.get(i);
                //System.out.println(object1);
                String nombreUser=object1.get("login");
                int a=i;
                listaUsuarios.get(i).setUserName(nombreUser);
                extraerOtraInfoUser(nombreUser,a);
                extraerReposUsers(nombreUser,a);

            }

            // since and per_page parameters are also relevant
            // curl -H "Accept: application/vnd.github.v3+json" "https://api.github.com/users?per_page=2&since=5"

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }



        return extraido;
    }

    public boolean extraerOtraInfoUser(String accesPoint, int a)throws RemoteException{


        boolean extraido=false;

        try {
            gateway= new Gateway("users/"+accesPoint);
            Response res1 = gateway.makeGetRequest("");

            // Parse the response as JsonArray
            JSONArray array = res1.readEntity(JSONArray.class);
            //System.out.println(array.size());

            //ESTA PARTE NOSE SI HAY QUE HACERLO EN EL METODO MAPEO DE DAO
            for(int i=0; i<array.size();i++) {
                HashMap<String, String> object1 = (HashMap<String, String>) array.get(i);
                //System.out.println(object1);
                String email=object1.get("email");
                String pais=object1.get("location");
                String afiliacion=object1.get("company");
                listaUsuarios.get(a).setAfiliacion(afiliacion);
                listaUsuarios.get(a).setEmail(email);
                listaUsuarios.get(a).setPais(pais);

            }

            // since and per_page parameters are also relevant
            // curl -H "Accept: application/vnd.github.v3+json" "https://api.github.com/users?per_page=2&since=5"

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }



        return extraido;
    }

    public boolean extraerReposUsers(String accesPoint, int a)throws RemoteException{


        boolean extraido=false;

        try {
            gateway= new Gateway("users/"+accesPoint+"/repos");
            Response res1 = gateway.makeGetRequest("");

            // Parse the response as JsonArray
            JSONArray array = res1.readEntity(JSONArray.class);
            //System.out.println(array.size());

            //ESTA PARTE NOSE SI HAY QUE HACERLO EN EL METODO MAPEO DE DAO
            for(int i=0; i<array.size();i++) {
                HashMap<String, String> object1 = (HashMap<String, String>) array.get(i);
                //System.out.println(object1);
                String id_pro=object1.get("id");
                int num=parseInt(id_pro);
                String nombre_pro=object1.get("full_name");
                String fecha_ini=object1.get("created_at");
                Date fecha_ini_date=parseDate(fecha_ini);
                //he decidido poner como fecha fin esa porque no hay otra
                String fecha_fin=object1.get("updated_at");
                Date fecha_fin_date=parseDate(fecha_fin);

                int b=i;
                listaProyectos.get(i).setIdpro(num);
                listaProyectos.get(i).setNombrepro(nombre_pro);
                listaProyectos.get(i).setProy_fecha_ini(fecha_ini_date);
                listaProyectos.get(i).setProy_fecha_fin(fecha_fin_date);

                extraerContributorsUsers(nombre_pro,b);

            }

            // since and per_page parameters are also relevant
            // curl -H "Accept: application/vnd.github.v3+json" "https://api.github.com/users?per_page=2&since=5"

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }

        https://api.github.com/repos/mojombo/30daysoflaptops.github.io/contributors

        return extraido;
    }

    public boolean extraerContributorsUsers(String accesPoint, int a)throws RemoteException{


        boolean extraido=false;


        try {
            gateway= new Gateway("repos/"+accesPoint+"/contributors");
            Response res1 = gateway.makeGetRequest("");

            // Parse the response as JsonArray
            JSONArray array = res1.readEntity(JSONArray.class);
            //System.out.println(array.size());

            ArrayList<String>listaLogin=new ArrayList<>();
            //ESTA PARTE NOSE SI HAY QUE HACERLO EN EL METODO MAPEO DE DAO
            for(int i=0; i<array.size();i++) {
                HashMap<String, String> object1 = (HashMap<String, String>) array.get(i);
                //System.out.println(object1);

                String usuario = object1.get("login");
                listaLogin.add(usuario);
            }
                //como no hay nos lo inventamos
                int id_equipo=+1;

                listaEquipos.get(a).setIdEquipo(id_equipo);
                //esto creo que esta mal, nose cuando podemos saber esto
                listaEquipos.get(a).setFecha_ini(listaProyectos.get(a).getProy_fecha_ini());

                for(int e=0; e<listaLogin.size();e++) {
                    for (int c = 0; c < listaUsuarios.size(); c++) {

                        if (listaUsuarios.get(c).getUserName().equals(listaLogin.get(e))){

                            listaUsuarios.get(c).addEquipo(listaEquipos.get(a));
                        }
                    }

                }


            // since and per_page parameters are also relevant
            // curl -H "Accept: application/vnd.github.v3+json" "https://api.github.com/users?per_page=2&since=5"

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }

        https://api.github.com/repos/mojombo/30daysoflaptops.github.io/contributors

        return extraido;
    }

    public boolean extraerCommitsUsers(String accesPoint, int a)throws RemoteException{


        boolean extraido=false;


        try {
            gateway= new Gateway("repos/"+accesPoint+"/commits");
            Response res1 = gateway.makeGetRequest("");

            // Parse the response as JsonArray
            JSONArray array = res1.readEntity(JSONArray.class);
            //System.out.println(array.size());

            ArrayList<String>listaLogin=new ArrayList<>();
            //ESTA PARTE NOSE SI HAY QUE HACERLO EN EL METODO MAPEO DE DAO
            for(int i=0; i<array.size();i++) {
                HashMap<String, String> object1 = (HashMap<String, String>) array.get(i);
                //System.out.println(object1);

                String id_commits = object1.get("sha");
                int id_commit_int=parseInt(id_commits);
                listaCommit.get(i).setIdcommit(id_commit_int);

                int e=i;
                extraerMasInfoCommitsUsers(accesPoint,id_commits,e);

            }

            for(int e=0; e<listaLogin.size();e++) {
                for (int c = 0; c < listaUsuarios.size(); c++) {

                    if (listaUsuarios.get(c).getUserName().equals(listaLogin.get(e))){

                        listaUsuarios.get(c).addEquipo(listaEquipos.get(a));
                    }
                }

            }


            // since and per_page parameters are also relevant
            // curl -H "Accept: application/vnd.github.v3+json" "https://api.github.com/users?per_page=2&since=5"

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }


        return extraido;
    }

    public boolean extraerMasInfoCommitsUsers(String accesPoint, String id_commit,int a)throws RemoteException{


        boolean extraido=false;
        https://api.github.com/repos/mojombo/30daysoflaptops.github.io/commits/sha

        try {
            gateway= new Gateway("repos/"+accesPoint+"/commits/"+id_commit);
            Response res1 = gateway.makeGetRequest("");

            // Parse the response as JsonArray
            JSONArray array = res1.readEntity(JSONArray.class);
            //System.out.println(array.size());

            ArrayList<String>listaLogin=new ArrayList<>();
            //ESTA PARTE NOSE SI HAY QUE HACERLO EN EL METODO MAPEO DE DAO
            for(int i=0; i<array.size();i++) {
                HashMap<String, String> object1 = (HashMap<String, String>) array.get(i);
                //System.out.println(object1);


                String addition_commits = object1.get("stats.addition");
                int addition_commits_int=parseInt(addition_commits);
                String deletion_commits=object1.get("stats.deletion");
                int deletion_commits_int=parseInt(deletion_commits);
                listaCommit.get(a).setAdditionlines(addition_commits_int);
                listaCommit.get(a).setDeletionlines(deletion_commits_int);


            }




            // since and per_page parameters are also relevant
            // curl -H "Accept: application/vnd.github.v3+json" "https://api.github.com/users?per_page=2&since=5"

        } catch (Exception e) {

            System.out.println("Catched exception: " + e.getMessage());
        }


        return extraido;
    }


    public int parseInt(String num){
        int numString = Integer.parseInt(num);
        return numString;
    }

    public Date parseDate(String fecha){

        Date fecha9 = null;
        try {
            fecha9 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            //ensi en la api git tmab esta la hora 2014-11-20T06:42:06Z
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
