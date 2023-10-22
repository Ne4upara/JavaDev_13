package sergey.goit.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import sergey.goit.entities.Client;
import sergey.goit.utils.HibernateUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientCrudServiceTest {

    private SessionFactory sessionFactory;

    @Before
    public void setup() {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    @Test
    public void saveClientTest() {
        Client client = new Client();
        client.setName("Vasy");

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            new ClientCrudService().saveClient(client);
            Long clientId = client.getId();
            assertNotNull(clientId);
            tx.rollback();
        }
    }

    @Test
    public void findClientByIdTest() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Client client = new ClientCrudService().findClientById(1L);
            Client clientTest = new Client();
            clientTest.setId(1L);
            clientTest.setName("Вася Пупкин");
            assertEquals(client.getId(), clientTest.getId());
            assertEquals(client.getName(), clientTest.getName());
            tx.rollback();
        }
    }

    @Test
    public void findClientByNameTest(){
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            List<Client> clients = new ClientCrudService().findClientByName("Коля Подубцев");
            Client client = clients.get(0);
            Client clientTest = new Client();
            clientTest.setId(2L);
            clientTest.setName("Коля Подубцев");
            assertEquals(client.getId(), clientTest.getId());
            assertEquals(client.getName(), clientTest.getName());
            tx.rollback();
        }
    }
}