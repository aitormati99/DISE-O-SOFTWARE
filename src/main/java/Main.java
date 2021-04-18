import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {

    public static void main(String args[])
    {

        System.out.println("Datanucleus + JDO example");
        System.out.println("=========================");

        //Create objects -  objects in memory
        Usuario user1= new Usuario("anebollo", "sd1", "España","anebollo@gmail.com");
        Usuario user2 = new Usuario("olatzgonzalez", "sd2", "España", "olatz.gonzalez1@opendeusto.es");
        Usuario user3 = new Usuario("aitormati99", "sd2", "España", "aitor.matilla@opendeusto.es");
        Usuario user4 = new Usuario("SarobeEzponda", "sd2", "España", "pablo.sarobe@opendeusto.es");


        //para los objetos equipo y proyecto
        String datoFecha = "20/02/2021";
        Date fecha = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String datoFecha1 = "05/11/2020";
        Date fecha1 = null;
        try {
            fecha1 = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha2 = "10/04/2020";
        Date fecha2 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Equipo equipo1 = new Equipo(1, fecha);
        Equipo equipo2 = new Equipo(2, fecha1);
        Equipo equipo3 = new Equipo(3, fecha2);

        String datoFecha3 = "10/04/2020";
        Date fecha3 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String datoFecha4 = "10/06/2020";
        Date fecha4 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha5 = "13/11/2020";
        Date fecha5 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String datoFecha6 = "10/02/2021";
        Date fecha6 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha7 = "11/04/2020";
        Date fecha7 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String datoFecha8 = "11/11/2020";
        Date fecha8 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha9 = "10/01/2021";
        Date fecha9 = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(datoFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datoFecha10 = "23/03/2021";
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
            pm.makePersistent(proyecto1);
            pm.makePersistent(proyecto2);
            pm.makePersistent(proyecto3);
            pm.makePersistent(proyecto4);
            pm.makePersistent(commit1);
            pm.makePersistent(commit2);
            pm.makePersistent(commit3);
            pm.makePersistent(commit4);
            pm.makePersistent(commit5);
            pm.makePersistent(commit6);
            pm.makePersistent(commit7);
            pm.makePersistent(commit8);
            pm.makePersistent(commit9);
            pm.makePersistent(commit10);
            pm.makePersistent(commit11);
            pm.makePersistent(commit12);


            //End the transaction
            tx.commit();

            //System.out.println("  * Objects and their relationships have been stored!");
            //System.out.println("- Transferring $100");
            //System.out.println("    - " + account1.getBankName() + "($ " + account1.getBalance() + ")");
            //System.out.println("Open Date: " + account1.getOpenDate());
            //System.out.println("    + " + account2.getBankName() + "($ " + account2.getBalance() + ")");
            //account1.debit(100);
            //account2.credit(100);

           // System.out.println("  * Money transferred!");
            //System.out.println("    - " + account1.getBankName() + "($ " + account1.getBalance() + ")");
           // System.out.println("    + " + account2.getBankName() + "($ " + account2.getBalance() + ")");
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
            System.out.println("- Retrieving all the accounts using an 'Extent'...");

            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            Extent<Account> extent = pm.getExtent(Account.class, true);

            for (Account account : extent)
            {
                System.out.println("  -> " + account);
            }

            //Notice the change in the accounts' balances
            //End the transaction
            tx.commit();
        }

        catch (Exception ex)
        {
            System.err.println(" $ Error retrieving accounts using an 'Extent': " + ex.getMessage());
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
            System.out.println("- Retrieving accounts with balace > 200.0 using a 'Query'...");

            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            Query<Account> query = pm.newQuery(Account.class);
            query.setFilter("balance > 200.0");

            @SuppressWarnings("unchecked")
            List<Account> accounts = (List<Account>) query.execute();

            //End the transaction
            tx.commit();

            for (Account account : accounts)
            {
                System.out.println("  -> " + account.getUser().getFullName() + " - " + account.getBankName());
            }
        }

        catch (Exception ex)
        {
            System.err.println(" $ Error retrieving accounts using a 'Query': " + ex.getMessage());
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
            System.out.println("- Deleting 'User->Address' relation...");

            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();

            //Obtain the current transaction
            tx = pm.currentTransaction();

            //Start the transaction
            tx.begin();

            Query<User> query = pm.newQuery(User.class);

            @SuppressWarnings("unchecked")
            List<User> users = (List<User>) query.execute();

            for (User user : users)
            {
                System.out.println("  -> Retrieved user: " + user.getFullName());
                System.out.println("     + Removing user from the addresses ... ");
                user.removeUserFromAddresses();
            }

            //End the transaction
            tx.commit();
        }

        catch (Exception ex)
        {
            System.err.println(" $ Error deleting 'User->Address' relation: " + ex.getMessage());
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

            // As we are considering accounts as dependents on user - CASCADING BEHAVIOUR - ACCOUNTS DELETED
            Query<User> query1 = pm.newQuery(User.class);
            System.out.println(" * '" + query1.deletePersistentAll() + "' users and their accounts deleted from the DB.");

            //Delete addresses from DB
            Query<Address> query2 = pm.newQuery(Address.class);
            System.out.println(" * '" + query2.deletePersistentAll() + "' addresses deleted from the DB.");

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
            Query<Product> productsQuery = pm.newQuery("SELECT FROM " + Product.class.getName() + " WHERE price < 150.00 ORDER BY price ASC");

            for (Product product : productsQuery.executeList())
            {
                System.out.println("- Selected from db: " + product.name);
                pm.deletePersistent(product);
                System.out.println("- Deleted from db: " + product.name);
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
