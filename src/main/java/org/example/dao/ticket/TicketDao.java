package org.example.dao.ticket;

import org.example.entities.Ticket;

import java.util.List;

public interface TicketDao {
    Long createTicket(Ticket ticket);

    Ticket getTicketById(Long ticketId);

    List<Ticket> getAllTickets();

    boolean updateTicket(Ticket ticket);

    boolean deleteTicket(Ticket ticket);

    boolean deleteTicketById(Long ticketId);
}
