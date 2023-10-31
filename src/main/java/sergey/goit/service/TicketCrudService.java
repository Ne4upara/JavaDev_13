package sergey.goit.service;

import sergey.goit.dao.TicketDao;
import sergey.goit.entities.Ticket;

import java.util.List;

public class TicketCrudService {

    private TicketDao ticketDao = new TicketDao();

    public void save(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public Ticket findById(Long id) {
        return ticketDao.findById(id);
    }

    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }

    public List<Ticket> findTicketByName(Long id) {
        return ticketDao.findByClientId(id);
    }
}