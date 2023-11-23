package org.example.hibernate;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.example.props.PropertyReader;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.flywaydb.core.Flyway;

public class HibetnateUtils {
    private static final HibetnateUtils INSTANCE = new HibetnateUtils();
    private SessionFactory sessionFactory;

    private HibetnateUtils(){
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

        flywayMigration(PropertyReader.getConnectionUrlForPostgres(),
                PropertyReader.getUserForPostgres(),
                PropertyReader.getPasswordForPostgres());
    }

    public static HibetnateUtils getInstance(){
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void closeSessionFactory(){
        this.sessionFactory.close();
    }

    private void flywayMigration(String connectionUrl, String username, String password) {
        Flyway flyway = Flyway.configure().dataSource(connectionUrl, username, password).load();
        flyway.migrate();
    }
}
