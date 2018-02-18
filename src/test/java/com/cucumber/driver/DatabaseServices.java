package com.cucumber.driver;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class DatabaseServices {

    private String databaseTitle; // Title of a database in the MongoDB server
    private String collectionTitle; // Title of a collection in a MongoDB database

    private Properties databaseProperties; // Properties object to load properties from a database YML file

    private MongoClient mongo; // MongoClient object to connect to the MongoDB server
    private MongoDatabase database; // MongoDatabase object to connect to the MongoDB database
    private MongoCollection<Document> collection; // MongoCollection object to get the data object collection fom a database

    public DatabaseServices(String database, String collection) {
        this.databaseTitle = database; // Put constructor database title into the instance variable
        this.collectionTitle = collection; // Put constructor collection title into the instance variable

        connectToDatabase(); // Connect to MongoDB
    }

    private void connectToDatabase() {
        databaseProperties = new Properties(); // Initialize Properties object to load properties in it from the YML file in the next step

        try (FileInputStream propertyFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\spring-properties\\database-services.properties.yml")) {
            databaseProperties.load(propertyFile); // Load property file and load the content into the properties object
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Load properties into local variables */
        String databaseUsername = databaseProperties.getProperty("database.Username");
        String databasePassword = databaseProperties.getProperty("database.Password");
        String databaseHost = databaseProperties.getProperty("database.Host");
        int portNumber = Integer.parseInt(databaseProperties.getProperty("database.PortNumber"));
        /* Load properties into local variables */

        mongo = new MongoClient(new MongoClientURI("mongodb://" + databaseUsername + ":" + databasePassword + "@" + databaseHost + ":" + portNumber));
        // Connect to MongoDB with pre-defined values from instance variables

        database = mongo.getDatabase(databaseTitle); // Connect to the database given in the constructor
        log.info("*** MONGO DB *** Verbinding gemaakt met de database: " + database.getName());

        collection = database.getCollection(collectionTitle); // Get database collection as passed in the constructor
        log.info("*** MONGO DB *** De collectie '" + collectionTitle + "' is gevonden en opgehaald!");
    }

    public MongoDatabase returnMongoDatabase() {
        return this.database; /* return database for class TestDataServices which queries the MongoDB */
    }

    public MongoCollection returnMongoCollection() {
        return this.collection; /* return collection for class TestDataServices which queries the MongoDB */
    }
}
