package org.example.dao.client;

import org.example.entities.Client;
import org.example.hibernate.HibetnateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientCrudService implements CLientDao{
    @Override
    public Long createClient(Client client) {
        Long clientId = null;
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                client.setId(null);
                session.persist(client);
                clientId = client.getId();
                transaction.commit();

            }catch (Exception ex){
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return clientId;
    }

    @Override
    public Client getClientById(Long clientId) {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            return session.get(Client.class, clientId);
        }
    }

    @Override
    public List<Client> getAllClients() {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            return session.createQuery("FROM Client", Client.class).list();
        }
    }

    @Override
    public boolean updateClient(Client client) {
        boolean result = false;
        if(Objects.isNull(client.getId())){
            return false;
        }
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.merge(client);
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
    public boolean deleteClient(Client client) {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean deleteClientById(Long clientId) {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Client existing = session.get(Client.class, clientId);
            session.remove(existing);
            transaction.commit();
            return  true;
        }
    }
}
