import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.List;

public class Main {


    public static void main(String args[])
    {

        System.out.println("Datanucleus + JDO example");
        System.out.println("=========================");

        //Create objects -  objects in memory
        Usuario user1= new Usuario("anebollo", "swap", "España","anebollo@gmail.com");
        Usuario user2 = new Usuario("olatzgonzalez", "uvesco", "España", "olatz.gonzalez1@opendeusto.es");
        Usuario user3 = new Usuario("aitormati99", "deusto", "España", "aitor.matilla@opendeusto.es");
        Usuario user4 = new Usuario("SarobeEzponda", "deusto", "España", "pablo.sarobe@opendeusto.es");


        //para los objetos equipo y proyecto

        String datoFecha = "20-02-2021";
        Date fecha = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String datoFecha1 = "05-11-2020";
        Date fecha1 = null;
        try {
            fecha1 = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha2 = "10-04-2020";
        Date fecha2 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Equipo equipo1 = new Equipo(1, fecha);
        Equipo equipo2 = new Equipo(2, fecha1);
        Equipo equipo3 = new Equipo(3, fecha2);

        String datoFecha3 = "10-04-2020";
        Date fecha3 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String datoFecha4 = "10-06-2020";
        Date fecha4 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha5 = "13-11-2020";
        Date fecha5 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String datoFecha6 = "10-02-2021";
        Date fecha6 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha7 = "11-04-2020";
        Date fecha7 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String datoFecha8 = "11-11-2020";
        Date fecha8 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha9 = "10-01-2021";
        Date fecha9 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha10 = "23-03-2021";
        Date fecha10= null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Proyecto proyecto1 = new Proyecto(1, "Biblioteca", fecha3,fecha4);
        Proyecto proyecto2 = new Proyecto(2, "AA", fecha5, fecha6);
        Proyecto proyecto3 = new Proyecto(3, "Investigadores", fecha7,fecha8);
        Proyecto proyecto4 = new Proyecto(4, "DeustoPress", fecha9,fecha10);

        Commit commit1=new Commit (1,3,4);
        Commit commit2=new Commit (2,7,0);
        Commit commit3=new Commit (3,2,1);
        Commit commit4=new Commit (4,31,4);
        Commit commit5=new Commit (5,21,19);
        Commit commit6=new Commit (6,15,8);
        Commit commit7=new Commit (7,3,4);
        Commit commit8=new Commit (8,7,0);
        Commit commit9=new Commit (9,2,1);
        Commit commit10=new Commit (10,31,4);
        Commit commit11=new Commit (11,21,19);
        Commit commit12=new Commit (12,15,8);

        user1.addEquipo(equipo1);
        equipo1.addUsuario(user1);

        user1.addEquipo(equipo2);
        equipo2.addUsuario(user1);

        user2.addEquipo(equipo1);
        equipo1.addUsuario(user2);

        user2.addEquipo(equipo3);
        equipo3.addUsuario(user2);

        user3.addEquipo(equipo1);
        equipo1.addUsuario(user3);

        user3.addEquipo(equipo2);
        equipo2.addUsuario(user3);

        user4.addEquipo(equipo1);
        equipo1.addUsuario(user4);

        user4.addEquipo(equipo3);
        equipo3.addUsuario(user4);

        equipo1.addPro(proyecto1);
        equipo1.addPro(proyecto2);
        equipo2.addPro(proyecto3);
        equipo3.addPro(proyecto4);

        proyecto1.addCommit(commit1);
        proyecto1.addCommit(commit2);
        proyecto1.addCommit(commit3);
        user1.addCommit(commit1);
        user3.addCommit(commit2);
        user4.addCommit(commit3);

        proyecto2.addCommit(commit4);
        proyecto2.addCommit(commit5);
        proyecto2.addCommit(commit6);
        user1.addCommit(commit4);
        user3.addCommit(commit5);
        user4.addCommit(commit6);

        proyecto3.addCommit(commit7);
        proyecto3.addCommit(commit8);
        proyecto3.addCommit(commit9);
        user1.addCommit(commit7);
        user3.addCommit(commit8);
        user3.addCommit(commit9);

        proyecto4.addCommit(commit10);
        proyecto4.addCommit(commit11);
        proyecto4.addCommit(commit12);
        user2.addCommit(commit10);
        user2.addCommit(commit11);
        user2.addCommit(commit12);

        // Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        // Persistence Manager
        PersistenceManager pm = null;

        //Transaction to group DB operations
        Transaction tx = null;

        try
        {
            System.out.println("- Store objects in the DB");

            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            //NOSE SI HAY QUE HACER EL MAKEPERSISTENTE DE TODOS
            pm.makePersistent(user1);
            pm.makePersistent(user2);
            pm.makePersistent(user3);
            pm.makePersistent(user4);
            pm.makePersistent(equipo1);
            pm.makePersistent(equipo2);
            pm.makePersistent(equipo3);
            //pm.makePersistent(proyecto1);
            //pm.makePersistent(proyecto2);
            //pm.makePersistent(proyecto3);
            //pm.makePersistent(proyecto4);
            //pm.makePersistent(commit1);
            //pm.makePersistent(commit2);
            //pm.makePersistent(commit3);
            //pm.makePersistent(commit4);
            //pm.makePersistent(commit5);
            //pm.makePersistent(commit6);
            //pm.makePersistent(commit7);
            //pm.makePersistent(commit8);
            //pm.makePersistent(commit9);
            //pm.makePersistent(commit10);
            //pm.makePersistent(commit11);
            //pm.makePersistent(commit12);


            //End the transaction
            tx.commit();

        }

        catch (Exception ex)
        {
            System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
            ex.printStackTrace();
        }

        finally
        {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed())
            {
                pm.close();
                // ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
            }
        }


        //A PARTIR DE AQUI HAY QUE CAMBIAR LO QUE DA ERROR
        //CREO QUE APARTIR DE AQUI SE PONEN LOS DELETE, SELECT, UPDATE Y INSERT

        //ESTO PARECE UN SELECT
        try
        {
            System.out.println("- Retrieving all the proyectos using an 'Extent'...");

            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            Extent<Proyecto> extent = pm.getExtent(Proyecto.class, true);

            for (Proyecto proyecto : extent)
            {
                System.out.println("  -> " + proyecto);
            }

            //Notice the change in the accounts' balances
            //End the transaction
            tx.commit();
        }

        catch (Exception ex)
        {
            System.err.println(" $ Error retrieving proyectos using an 'Extent': " + ex.getMessage());
        }

        finally
        {
            if (tx != null && tx.isActive())
            {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed())
            {
                pm.close();
            }
        }

        //ESTO PARECE UN SELECT
        try
        {
            System.out.println("- Retrieving commit with addition_lines > 10 using a 'Query'...");

            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();

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

        //ESTO PARECE UN DELETE
        try
        {
            System.out.println("- Deleting 'Usuarios->equipos' relation...");

            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            Query<Usuario> query = pm.newQuery(Usuario.class);

            @SuppressWarnings("unchecked")
            List<Usuario> users = (List<Usuario>) query.execute();

            for (Usuario user : users)
            {
                System.out.println("  -> Retrieved user: " + user.getUserName());
                System.out.println("     + Removing user from equipos ... ");
                user.removeEquipos();
            }

            //End the transaction
            tx.commit();
        }

        catch (Exception ex)
        {
            System.err.println(" $ Error deleting 'Usuarios->equipos' relation: " + ex.getMessage());
        }

        finally
        {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }

        //ESTO PARECE UN DELETE
        try
        {
            System.out.println("- Cleaning the DB...");
            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();
            //Obtain the current transaction
            tx = pm.currentTransaction();
            //Start the transaction
            tx.begin();

            //Delete users from DB

            // As we are considering equipo as dependents on user - CASCADING BEHAVIOUR - ACCOUNTS DELETED
            Query<Usuario> query1 = pm.newQuery(Usuario.class);
            System.out.println(" * '" + query1.deletePersistentAll() + "' users and their equipos deleted from the DB.");

            //Delete equipo from DB
            Query<Equipo> query2 = pm.newQuery(Equipo.class);
            System.out.println(" * '" + query2.deletePersistentAll() + "' equipos deleted from the DB.");

            //End the transaction
            tx.commit();
        }

        catch (Exception ex)
        {
            System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
            ex.printStackTrace();
        }

        finally
        {
            if (tx != null && tx.isActive())
            {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed())
            {
                pm.close();
            }
        }

        //PARECE UN SELECT
        try
        {
            //Select data using a Query
            pm = pmf.getPersistenceManager();
            tx = pm.currentTransaction();
            tx.begin();

            @SuppressWarnings("unchecked")
            Query<Usuario> userQuery = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE afiliacion='deusto' 150.00 ORDER BY user_name ASC");

            for (Usuario usuario : userQuery.executeList())
            {
                System.out.println("- Selected from db: " + usuario.getUserName());
                pm.deletePersistent(usuario);
                System.out.println("- Deleted from db: " + usuario.getUserName());
            }

            tx.commit();
        }

        catch(Exception ex)
        {
            System.err.println("* Exception executing a query: " + ex.getMessage());
        }

        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }

            pm.close();
        }

        System.out.println("End of the Datanucleus + JDO example");
        System.out.println("====================================");

    }
}
