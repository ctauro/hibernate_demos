
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        // Set up database tables
        HibernateUtil.droptable("drop table person");
        HibernateUtil.setup("create table person ( id int, cname VARCHAR(20))");

        // Create SessionFactory and Session object
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        // Perform life-cycle operations under a transaction
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Create a Person object and persist it
            Person p1 = new Person();  //transient state
            p1.setName("Sang Shin");
            // Persist the given transient instance, first assigning a 
            // generated identifier.
            Object id1 = session.save(p1);          // persistent state

            // Object id1 = session.getIdentifier(p1);
            System.out.println("id1 = " + id1);

            // Create another Person object and persist it.
            Person p2 = new Person();  //transient state
            p2.setName("Young Shin");
            // Try commenting out the following line and observe 
            // that p2 will not be written to the table
            session.save(p2);          // persistent state
            
            // If you commented out the above line, you have to comment
            // out the following 2 lines as well
            Object id2 = session.getIdentifier(p2);
            System.out.println("id2 = " + id2);

            // Observe that p3 will not be written to the table
            // because we call delete() method
            Person p3 = new Person();  //transient state
            p3.setName("Daniel Shin");
            session.save(p3);          // persistent state
            
            // Remove a persistent instance from the datastore. 
            // The argument may be an instance associated with the receiving 
            // Session or a transient instance with an identifier associated 
            // with existing persistent state.  In the example below,
            // it is the former since p3 is associated with a session meaning
            // it is in persistent state.
            session.delete(p3);
            
            // Assuming unsaved-value="0" set in the mapping file, the
            // following makes the p3 a transitent object, which does 
            // not have object identifier.
            p3.setId(0);

            Object id3 = session.getIdentifier(p3);
            System.out.println("id3 = " + id3);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Display tables
        HibernateUtil.checkData("select * from person");

    }
}
