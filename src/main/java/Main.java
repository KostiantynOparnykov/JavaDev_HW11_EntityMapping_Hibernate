import org.example.dao.ClientCrudService;
import org.example.dao.PlanetCrudService;
import org.example.entities.Client;
import org.example.entities.Planet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        Client newClient = new Client();
        Planet newPlanet = new Planet();

        newClient.setName("Overlord");

        newPlanet.setId("URANUS1");
        newPlanet.setName("Uranus");

        //CREATE new client
        System.out.println("-->>Creating new client<<--");
        Long clientId = clientCrudService.createClient(newClient);
        System.out.println("ID of new client  = " + clientId);

        //READ client
        Client client = clientCrudService.getClientById(clientId);
        System.out.println("-->>Reading new client<<--\n-->> " + client);

        //READ ALL Clients
        List<Client> clients = clientCrudService.getAllClients();
        System.out.println("-->>AllClients<<--");
        clients.forEach(System.out::println);

        //UPDATE client
        newClient.setName("Mega Overlord");
        newClient.setId(clientId);
        System.out.println("-->>Updating client<<--");
        System.out.println("clientCrudService.updateClient(newClient) = " + clientCrudService.updateClient(newClient));

        //DELETE client by id
        System.out.println("-->>Deleting client by ID<<--");
        System.out.println("clientCrudService.deleteClientById(clientId) = " + clientCrudService.deleteClientById(clientId));

        //DELETE client
        clientCrudService.createClient(newClient);
        System.out.println("-->>Created new client<<--\n-->>" + newClient);
        System.out.println("-->>Deleting client<<--");
        System.out.println("clientCrudService.deleteClient(newClient) = " + clientCrudService.deleteClient(newClient));


        //CREATE new planet
        System.out.println("\n\n-->>Creating new planet<<--");
        System.out.println("planetCrudService.createPlanet(newPlanet) = " + planetCrudService.createPlanet(newPlanet));

        //READ planet
        Planet planet = planetCrudService.getPlanetById("URANUS1");
        System.out.println("-->>Reading new planet<<--\n-->>" + planet);

        //READ ALL Planets
        List<Planet> planets = planetCrudService.getAllPlanets();
        System.out.println("-->>AllPlanets<<--");
        planets.forEach(System.out::println);

        //UPDATE planet
        newPlanet.setName("Mega Uranus");
        System.out.println("-->>Updating planet<<--" );
        System.out.println("planetCrudService.updatePlanet(newPlanet) = " + planetCrudService.updatePlanet(newPlanet));

        //DELETE planet by id
        System.out.println("-->>Deleting planet by ID<<--");
        System.out.println("planetCrudService.deletePlanetById(\"URANUS1\") = " + planetCrudService.deletePlanetById("URANUS1"));

        //DELETE planet
        newPlanet.setName("Uranus");
        newPlanet.setId("URANUS2");
        planetCrudService.createPlanet(newPlanet);
        System.out.println("-->>Created new planet<<--\n-->>>" + newPlanet);
        System.out.println("-->>Deleting planet<<--");
        System.out.println("planetCrudService.deletePlanet(newPlanet) = " + planetCrudService.deletePlanet(newPlanet));
    }
}
