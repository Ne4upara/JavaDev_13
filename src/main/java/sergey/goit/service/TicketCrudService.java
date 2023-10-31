package sergey.goit.service;

import sergey.goit.dao.TicketDao;
import sergey.goit.entities.Planet;
import sergey.goit.entities.Ticket;

public class TicketCrudService {

    private TicketDao ticketDao = new TicketDao();

    public void save(Ticket ticket){
       ticketDao.save(ticket);
    }


}
