package sergey.goit.service;

import sergey.goit.dao.ClientAndPlanetDao;
import sergey.goit.entities.Client;

import java.util.List;

public class ClientCrudService {

    private ClientAndPlanetDao clientDao = new ClientAndPlanetDao();

    public void saveClient (Client client){
        clientDao.save(client);
    }

    public Client findClientById (Long id){
        return clientDao.findById(Client.class, id);
    }

    public List<Client> findClientByName(String name){
        return clientDao.findByName(Client.class,name);
    }

    public void updateClient(Client client){
        clientDao.update(client);
    }

    public void deleteClient(Client client){
        clientDao.delete(client);
    }

    public void deleteName (String name){
        clientDao.deletaByName(Client.class, name);
    }
}