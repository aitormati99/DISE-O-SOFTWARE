package servidor.appService;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
    int idEquipo=0;


    private int id_equipo=0;

    public boolean buscar (String pais, String afiliacion) throws  RemoteException{

        extraerUsuario();
        ExtraerExtraInfoUser();
        extraerProyecto();
        extraerEquipo();
        extraerCommit();
        extraerMasInfoCommit();

        guardarDao();

        boolean val=dao.buscarUsuarios(pais,afiliacion);
        boolean val1= dao.buscarCommits(pais,afiliacion);
        boolean val2=dao.buscarEquipos(pais,afiliacion);
        boolean val3=dao.buscarProyectos(pais,afiliacion);


        return val;

    }


    public void extraerUsuario(){

        String accespoint="users";
        JSONArray arrayUser=gateway.extraerArrayJson(accespoint);
        mapeoUsuario(arrayUser);

    }

    public void ExtraerExtraInfoUser(){

        String accespoint=null;
        String id=null;
        for(int i=0; i<listaUsuarios.size();i++){

            id=listaUsuarios.get(i).getUser_name();
            accespoint="users/"+id;
            JSONObject objectUser=gateway.extraerJsonObject(accespoint);
            mapeoExtraInfoUser(objectUser,i);

        }
    }

    public void extraerProyecto(){

        String accespoint=null;
        String id=null;
        for(int i=0; i<listaUsuarios.size();i++){

            id=listaUsuarios.get(i).getUser_name();
            accespoint="users/"+id+"/repos";
            JSONArray array=gateway.extraerArrayJson(accespoint);
            mapeoProyecto(array, i);

        }
    }

    public void extraerEquipo(){

        String accespoint=null;
        String id=null;
        for(int i=0; i<listaProyectos.size();i++){

            id=listaProyectos.get(i).getNombrepro();
            accespoint="repos/"+id+"/contributors";
            JSONArray array=gateway.extraerArrayJson(accespoint);
            Date created=listaProyectos.get(i).getProy_fecha_ini();
            Proyecto hecho=listaProyectos.get(i);
            mapeoEquipo(array,created,hecho);

        }

    }

    public void extraerCommit(){

        String accespoint=null;
        String id=null;
        for(int i=0; i<listaProyectos.size();i++){

            id=listaProyectos.get(i).getNombrepro();
            accespoint="repos/"+id+"/commits";
            JSONArray array=gateway.extraerArrayJson(accespoint);
            Proyecto hecho=listaProyectos.get(i);
            mapeoCommits(array,hecho);

        }
    }

    public void extraerMasInfoCommit(){

        String accespoint=null;
        String id=null;
        String nombrepro=null;
        for(int j=0;j<listaProyectos.size();j++) {
            for (int i = 0; i < listaCommit.size(); i++) {

                id = listaCommit.get(i).getId_commit();
                nombrepro=listaProyectos.get(j).getNombrepro();
                accespoint = "repos/" + nombrepro+ "/commits/"+id;
                JSONObject objectUser = gateway.extraerJsonObject(accespoint);
                mapeoExtraInfoCommits(objectUser,i);

            }

        }
    }


    public void mapeoUsuario(JSONArray array){

        for(int i=0; i<array.size();i++){

            HashMap<String, String> object1 = (HashMap<String, String>)array.get(i);
            String username=object1.get("login");

            Usuario nuevo=new Usuario();
            nuevo.setUser_name(username);

            listaUsuarios.add(nuevo);
        }

    }

    public void mapeoExtraInfoUser(JSONObject object1, int i){

        String email= (String) object1.get("email");
        String pais= (String) object1.get("location");
        String afiliacion= (String) object1.get("company");

        listaUsuarios.get(i).setPais(pais);
        listaUsuarios.get(i).setAfiliacion(afiliacion);
        listaUsuarios.get(i).setEmail(email);

    }

    public void mapeoEquipo(JSONArray array, Date created, Proyecto hecho){

        ArrayList<String> usernames=new ArrayList<String>();
        for(int i=0; i<array.size();i++){

            HashMap<String, String> object1 = (HashMap<String, String>)array.get(i);
            String username=object1.get("login");
            usernames.add(username);

        }

        Equipo nuevo=new Equipo();
        nuevo.setId_equipo(id_equipo);
        nuevo.setFecha_ini(created);
        nuevo.addPro(hecho);
        id_equipo++;

        for(int t=0;t<usernames.size();t++){

            for(int k=0;k<listaUsuarios.size();k++){

                if(usernames.get(t).equals(listaUsuarios.get(k).getUser_name())){

                    Usuario a=listaUsuarios.get(k);
                    nuevo.addUsuario(a);
                    listaUsuarios.get(k).addEquipo(nuevo);
                    break;
                }
            }
        }

        listaEquipos.add(nuevo);
    }

    public void mapeoCommits(JSONArray array,Proyecto hecho){

        for(int i=0; i<array.size();i++){

            HashMap<String, String> object1 = (HashMap<String, String>)array.get(i);
            //HashMap<String, String> autor = (HashMap<String, String>)object1.get("author");
            LinkedHashMap<String,String>author=object1.get("author");
            String username=author.get("login");
            String id_commit=object1.get("sha");

            Commit añadir= new Commit();
            añadir.setId_commit(id_commit);
            for(int j=0;j<listaUsuarios.size();j++) {

                if(username.equals(listaUsuarios.get(j).getUser_name())) {
                    añadir.setUser(listaUsuarios.get(j));
                }
            }

           listaCommit.add(añadir);
        }

    }

    public void mapeoProyecto(JSONArray array, int i){

        for(int j=0; j<array.size();j++){

            HashMap<String, String> object1 = (HashMap<String, String>)array.get(j);
            String id_pro=object1.get("id");
            int id_pro_int=parseInt(id_pro);

            String nombrepro=object1.get("full_name");

            String fecha_ini=object1.get("created_at");
            Date fehca_ini_date=parseDate(fecha_ini);

            String fecha_fin=object1.get("updated_at");
            Date fehca_fin_date=parseDate(fecha_fin);

            Proyecto nuevo= new Proyecto();
            nuevo.setNombrepro(nombrepro);
            nuevo.setId_pro(id_pro_int);
            nuevo.setProy_fecha_ini(fehca_ini_date);
            nuevo.setProy_fecha_fin(fehca_fin_date);

            listaProyectos.add(nuevo);


        }


    }

    public void mapeoExtraInfoCommits(JSONObject object1, int i){

        LinkedHashMap<String,String>author=object1.get("stats");

        String addition=author.get("additions");
        int addition_int=parseInt(addition);
        String deletion=author.get("deletions");
        int deletion_int=parseInt(deletion);

        listaCommit.get(i).setAddition_lines(addition_int);
        listaCommit.get(i).setDeletion_lines(deletion_int);

        for(int j=0; j<listaCommit.size();j++){
            for( int k=0;k<listaUsuarios.size();k++){

                if(listaCommit.get(j).getUser().getUser_name().equals(listaUsuarios.get(k).getUser_name())){

                    listaUsuarios.get(k).addCommit(listaCommit.get(j));
                }
            }
        }
    }

    public void guardarDao(){

        dao.guardar(listaUsuarios);
        dao.guardar(listaCommit);
        dao.guardar(listaEquipos);
        dao.guardar(listaProyectos);
        //dao.guardar(listaUsuarios, listaCommit, listaEquipos, listaProyectos);

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

        return fecha9;
    }

}
