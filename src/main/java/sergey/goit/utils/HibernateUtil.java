package sergey.goit.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sergey.goit.entities.Client;
import sergey.goit.entities.Planet;
import sergey.goit.entities.Ticket;

public class HibernateUtil implements AutoCloseable{
    private static final HibernateUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }
    @Override
    public void close() {
        sessionFactory.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
