package sergey.goit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sergey.goit.entities.Clients;
import sergey.goit.utils.Flyway;
import sergey.goit.utils.HibernateUtil;

public class Main {
    public static void main(String[] args) {
       try(HibernateUtil instance = HibernateUtil.getInstance();
        SessionFactory sessionFactory = instance.getSessionFactory();
           Session session = sessionFactory.openSession()){

//            Clients personCreaet = new Clients();
//           personCreaet.setName("Vasy");
//        List<Person> person = session.createQuery("From Person p WHERE p.id = :id")
//                .setParameter("id", "4")
//                .list();
//        Person persondelete = person.get(0);


           Transaction transaction = session.beginTransaction();
//           session.persist(personCreaet);
//           for (Person person1:persondelete){
//               System.out.println(person1.getName());
//           }
//           session.persist(personCreaet);
           Flyway.flywayMigration();
           transaction.commit();



    }
}
}