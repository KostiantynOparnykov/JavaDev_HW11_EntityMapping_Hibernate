package org.example.dao.planet;
import org.example.entities.Planet;

import java.util.List;

public interface PlanetDao {
    boolean createPlanet(Planet planet);
    Planet getPlanetById(String planetId);
    boolean updatePlanet(Planet planet);
    List<Planet> getAllPlanets();
    boolean deletePlanet(Planet planet);
    boolean deletePlanetById(String planetId);
}
