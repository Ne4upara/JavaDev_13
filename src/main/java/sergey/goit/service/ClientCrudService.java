package sergey.goit.service;

import sergey.goit.dao.ClientDao;
import sergey.goit.entities.Client;

import java.util.List;

public class ClientCrudService {

    private ClientDao clientDao = new ClientDao();

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public Client findClientById(Long id) {
        return clientDao.findById(id);
    }

    public List<Client> findClientByName(String name) {
        return clientDao.findByName(name);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }

    public void deleteName(String name) {
        clientDao.deletaByName(name);
    }
}