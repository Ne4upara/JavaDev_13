//package sergey.goit.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import sergey.goit.entities.Client;
//import sergey.goit.entities.Planet;
//import sergey.goit.utils.HibernateUtil;
//
//public class PlanetDao {
//
//    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
//
//    public void save (Planet planet){
//        try (Session session = sessionFactory.openSession()){
//            Transaction tx = session.beginTransaction();
//            session.persist(planet);
//            tx.commit();
//        }
//    }
//
//    public void delete (Planet planet){
//        try(Session session = sessionFactory.openSession()){
//            Transaction tx = session.beginTransaction();
//            session.remove(planet);
//            tx.commit();
//        }
//    }
//
//    public void update (Planet planet){
//        try(Session session = sessionFactory.openSession()){
//            Transaction tx = session.beginTransaction();
//            session.merge(planet);
//            tx.commit();
//        }
//    }
//
//    public Planet findById(String id) {
//        try (Session session = sessionFactory.openSession()) {
//            return session.get(Planet.class, id);
//        }
//    }
//}
