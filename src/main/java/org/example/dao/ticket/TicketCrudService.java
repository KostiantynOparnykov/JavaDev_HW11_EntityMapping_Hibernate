package org.example.dao.ticket;

import org.example.entities.Ticket;
import org.example.hibernate.HibetnateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;


public class TicketCrudService implements TicketDao{
    @Override
    public Long createTicket(Ticket ticket) {
        Long ticketId = null;
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                ticket.setId(null);
                session.persist(ticket);
                ticketId = ticket.getId();
                transaction.commit();
            }catch (Exception ex){
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return ticketId;
    }

    @Override
    public Ticket getTicketById(Long ticketId) {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            return session.get(Ticket.class, ticketId);
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            return session.createQuery("FROM Ticket", Ticket.class).list();
        }
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        boolean result = false;
        if(Objects.isNull(ticket.getId())){
            return false;
        }
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.merge(ticket);
                transaction.commit();
                result = true;
            }catch (Exception ex){
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public boolean deleteTicket(Ticket ticket) {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean deleteTicketById(Long ticketId) {
        try (Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket existing = session.get(Ticket.class, ticketId);
            session.remove(existing);
            transaction.commit();
            return true;
        }
    }

}
