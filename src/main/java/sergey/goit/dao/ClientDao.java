package sergey.goit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sergey.goit.entities.Client;
import sergey.goit.utils.HibernateUtil;

import java.util.List;

public class ClientDao {

    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
    }

    public Client findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public List findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE name = :name");
            query.setParameter("name", name);
            return query.list();
        }
    }

    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(client);
            tx.commit();
        }
    }

    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(client);
            tx.commit();
        }
    }

    public void deletaByName(String name) {
        List nameDelete = findByName(name);
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            for (Object o : nameDelete) {
                session.remove(o);
            }
            tx.commit();
        }
    }
}