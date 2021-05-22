package servidor.dao;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.List;

import servidor.ld.Usuario;
import servidor.ld.Commit;
import servidor.ld.Equipo;
import servidor.ld.Proyecto;

public class Dao implements Idao{


    private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    private Transaction tx;

    public Dao(){

        this.pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        this.pm = pmf.getPersistenceManager();
    }

    public boolean buscarUsuarios(String pais, String afiliacion){

       /* ALGOOOOO ASI PARA CADA OBJETOOOOOOOO
       //SELECT USUARIOS
        {
            System.out.println("- Retrieving commit with addition_lines > 10 using a 'Query'...");
            //Get the Persistence Manager
            pm = fm.getPersistenceManager();
            //Obtain the current transaction
            tx = pm.currentTransaction();
            //Start the transaction
            tx.begin();
            Query<Commit> query = pm.newQuery(Commit.class);
            query.setFilter("addition_lines > 10");
            @SuppressWarnings("unchecked")
            List<Commit> commits = (List<Commit>) query.execute();
            //End the transaction
            tx.commit();
            for (Commit commit : commits)
            {
                System.out.println("  -> " + commit.getId_commit());
            }
        }
        catch (Exception ex)
        {
            System.err.println(" $ Error retrieving commit using a 'Query': " + ex.getMessage());
        }
        finally
        {
            if (tx != null && tx.isActive())
            {
                tx.rollback();
            }
            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }
        */

        //PABLO: posible codigo:
        //una vez estoy en la BD, lo que hago es comparar el pais y afiliaciacion con lo que tenemos
        //en el caso de que coincida copiara le nombre del usuario y lo imprimira para aseguararnos que
        //esta bn, y cambio el la validacion de falso a true
        //posibles problemas: *tiene que buscar con ambos parametros para que funcione (doble if)
        //                    *no se si hay que donde añadir los usuarios que coinciden, si a un arraylist
        //                     o a otro sitio para crear lo del CV
        /**String busqueda = null;
        boolean busquedaVal = false;

        try
        {
            System.out.println("Buscando en usuarios por pais y afiliacion...");

            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            Query<Usuario> query = pm.newQuery(Usuario.class);
            //query.setFilter("nombre == ");

            @SuppressWarnings("unchecked")
            List<Usuario> usuarios = (List<Usuario>) query.execute();

            //End the transaction
            tx.commit();

            for (Usuario usuario : usuarios)
            {
                if(usuario.getPais()==pais)
                {
                    if(usuario.getAfiliacion()==afiliacion)
                    {
                        busqueda = usuario.getUser_name();
                        System.out.println("EL ultimo nombre encontrado es: " + busqueda);
                        busquedaVal = true;
                    }
                }
            }
        }

        catch (Exception ex)
        {
            System.err.println(" $ Error retrieving user name using a 'Query': " + ex.getMessage());
        }

        finally
        {
            if (tx != null && tx.isActive())
            {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }
        return busquedaVal;
            */
        //habria que quitar el return false, para mete esta parte
        return false;
    }

    public boolean buscarEquipos(String pais, String afiliacion){

        //SELECT EQUIPOS
        return false;
    }

    public boolean buscarProyectos(String pais, String afiliacion){

        //SELECT PROYECTOS
        return false;
    }

    public boolean buscarCommits(String pais, String afiliacion){

        //SELECT COMMITS
        return false;
    }

    public <T>boolean guardar(List<T> listaObjetos){

        boolean guardado = true;

        try
        {
            System.out.println("Guardar objetos en la BD...");

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            for(int i=0; i<listaObjetos.size(); i++) {
                pm.makePersistent(listaObjetos.get(i));
            }

            //End the transaction
            tx.commit();

            System.out.println("Los objetos se han guardado satisfactoriamente");

        }

        catch (Exception ex)
        {
            guardado = false;

            System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());

            ex.printStackTrace();
        }

        finally
        {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }

        return guardado;
    }

    //¿?Para cerrar la BD, + deberia de ser private sino cerramos la BD desde fuera, no?
    public void cerrarBD() {

        if (tx != null && tx.isActive()) {
            tx.rollback();
        }

        if (pm != null && !pm.isClosed())
        {
            pm.close();
            // ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
        }
    }
}
