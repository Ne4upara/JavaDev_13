package sergey.goit.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sergey.goit.entities.Ticket;
import sergey.goit.utils.HibernateUtil;

public class TicketDao {

    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save (Ticket ticket){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();
        }
    }
}
