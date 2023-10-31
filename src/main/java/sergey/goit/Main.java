package sergey.goit;

import sergey.goit.entities.Client;
import sergey.goit.entities.Planet;
import sergey.goit.entities.Ticket;
import sergey.goit.service.ClientCrudService;
import sergey.goit.service.PlanetCrudService;
import sergey.goit.service.TicketCrudService;
import sergey.goit.utils.Flyway;

public class Main {

    public static void main(String[] args) {
        Flyway.flywayMigration();

        ClientCrudService ccs = new ClientCrudService();
        PlanetCrudService pcs = new PlanetCrudService();
        TicketCrudService tcs = new TicketCrudService();
//        Client client = new Client();
//        client.setName("TEST TEST");
//        Client newClient = new Client();
//        newClient.setName("New Earth 10");
//        newClient.setId(12L);
//        ccs.saveClient(client);
//        System.out.println("OLD " + ccs.findClientById(12L));
//        ccs.updateClient(newClient);
//        System.out.println("NEW " + ccs.findClientById(12L));
//        ccs.deleteClient(newClient);
//
//        System.out.println(ccs.findClientByName("New Earth 10"));
//        ccs.deleteName("New Earth 10");
//
//
//        Planet planet = new Planet();
//        Planet planetNew = new Planet();
//        planet.setId("EA2");
//        planet.setName("EART 1");
//        planetNew.setId("EA2");
//        planetNew.setName("New Earth 10");
//        pcs.savePlanet(planet);
//        System.out.println("OLD " + pcs.findPlanetById("EA1"));
//        pcs.updatePlanet(planetNew);
//        System.out.println("NEW " + pcs.findPlanetById("EA1"));
//        pcs.deletePlanet(planetNew);
//
//        System.out.println(pcs.findPlanetByName("New Earth 10"));
//        pcs.deleteName("New Earth 10");

        Ticket ticket= new Ticket();
        ticket.setClientId(ccs.findClientById(9L));
        ticket.setFromplanet(pcs.findPlanetById("MRS"));
        ticket.setToPlanet(pcs.findPlanetById("SAT"));
        tcs.save(ticket);

    }
}