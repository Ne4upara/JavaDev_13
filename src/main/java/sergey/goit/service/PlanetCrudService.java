package sergey.goit.service;

import sergey.goit.dao.ClientAndPlanetDao;
import sergey.goit.entities.Planet;

import java.util.List;

public class PlanetCrudService {

    private ClientAndPlanetDao clientAndPlanetDao = new ClientAndPlanetDao();

    public void savePlanet (Planet planet){
        clientAndPlanetDao.save(planet);
    }

    public Planet findPlanetById (String id){
        return clientAndPlanetDao.findById(Planet.class,id);
    }

    public void updatePlanet(Planet planet){
        clientAndPlanetDao.update(planet);
    }

    public void deletePlanet(Planet planet){
        clientAndPlanetDao.delete(planet);
    }

    public List<Planet> findPlanetByName(String name){
        return clientAndPlanetDao.findByName(Planet.class,name);
    }

    public void deleteName (String name){
        clientAndPlanetDao.deletaByName(Planet.class, name);
    }
}