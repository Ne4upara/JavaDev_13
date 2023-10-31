package sergey.goit.service;

import sergey.goit.dao.ClientDao;
import sergey.goit.dao.PlanetDao;
import sergey.goit.entities.Planet;

import java.util.List;

public class PlanetCrudService {

    private PlanetDao planetDao = new PlanetDao();

    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }

    public Planet findPlanetById(String id) {
        return planetDao.findById(id);
    }

    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }

    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }

    public List<Planet> findPlanetByName(String name) {
        return planetDao.findByName(name);
    }

    public void deleteName(String name) {
        planetDao.deletaByName(name);
    }
}