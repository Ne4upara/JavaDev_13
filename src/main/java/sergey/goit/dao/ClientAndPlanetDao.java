package sergey.goit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sergey.goit.utils.HibernateUtil;

import java.util.List;

public class ClientAndPlanetDao {

    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public <T> void save(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        }
    }

    public <T, ID> T findById(Class<T> entityCLass, ID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(entityCLass, id);
        }
    }

    public <T> List<T> findByName (Class<T> entityClass, String name){
        try (Session session = sessionFactory.openSession()){
            @SuppressWarnings("JpaQlInspection") Query<T> query = session.createQuery("FROM " + entityClass.getSimpleName() + " WHERE name = :name");
            query.setParameter("name", name);
            return query.list();
        }
    }


    public <T> void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
        }
    }

    public <T> void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        }
    }

    public  <T> void deletaByName (Class<T> entityClass, String name){
        List <T> nameDelete = findByName(entityClass, name);
        try (Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            for (T entity : nameDelete){
                session.remove(entity);
            }
            tx.commit();
        }
    }
}