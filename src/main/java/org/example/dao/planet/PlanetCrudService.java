package org.example.dao.planet;

import org.example.entities.Planet;
import org.example.hibernate.HibetnateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetCrudService implements PlanetDao{
    @Override
    public boolean createPlanet(Planet planet) {
        boolean result = false;
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.persist(planet);
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
    public boolean updatePlanet(Planet planet) {
        boolean result = false;
        if(Objects.isNull(planet.getId())){
            return false;
        }
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.merge(planet);
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
    public Planet getPlanetById(String planetId) {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            return session.get(Planet.class, planetId);
        }
    }

    @Override
    public List<Planet> getAllPlanets() {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            return session.createQuery("FROM Planet", Planet.class).list();
        }
    }

    @Override
    public boolean deletePlanet(Planet planet) {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean deletePlanetById(String planetId) {
        try(Session session = HibetnateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Planet existing = session.get(Planet.class, planetId);
            session.remove(existing);
            transaction.commit();
            return true;
        }
    }
}
