package sergey.goit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sergey.goit.entities.Planet;
import sergey.goit.utils.HibernateUtil;

import java.util.List;

public class PlanetDao {

    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(planet);
            tx.commit();
        }
    }

    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(planet);
            tx.commit();
        }
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(planet);
            tx.commit();
        }
    }

    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public List findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Planet> query = session.createQuery("FROM Planet WHERE name = :name");
            query.setParameter("name", name);
            return query.list();
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