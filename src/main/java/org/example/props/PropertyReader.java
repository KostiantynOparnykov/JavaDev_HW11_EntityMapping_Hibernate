package org.example.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String getConnectionUrlForPostgres(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("hibernate.properties")){
            Properties properties = new Properties();

            if(input == null){
                System.out.println("Unable to find hibernate.properties");
                return null;
            }
            properties.load(input);

            return properties.getProperty("hibernate.connection.url");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getUserForPostgres(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("hibernate.properties")){
            Properties properties = new Properties();

            if(input == null){
                System.out.println("Unable to find hibernate.properties");
                return null;
            }
            properties.load(input);

            return properties.getProperty("hibernate.connection.username");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getPasswordForPostgres(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("hibernate.properties")){
            Properties properties = new Properties();

            if(input == null){
                System.out.println("Unable to load hibernate.properties");
                return null;
            }
            properties.load(input);
            return properties.getProperty("hibernate.connection.password");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
