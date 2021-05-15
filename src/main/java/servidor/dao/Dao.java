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

    public List buscar(String pais, String afiliacion){

       /* try
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

    }

    public <T> boolean guardar(T objeto){

        boolean guardado = true;

        try
        {
            System.out.println("Guardar objetos en la BD...");

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            pm.makePersistent(objeto);

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
}
