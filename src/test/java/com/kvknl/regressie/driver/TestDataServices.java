package com.kvknl.regressie.driver;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.exists;

@Slf4j
public class TestDataServices {

    private MongoDatabase database; // MongoDatabase object to connect to the MongoDB database
    private MongoCollection<Document> collection; // MongoCollection object to get the data object collection fom a database
    private FindIterable<Document> testData; // Object to fetch query results

    public TestDataServices(DatabaseServices databaseInstantion) {
        this.database = databaseInstantion.returnMongoDatabase();
        this.collection = databaseInstantion.returnMongoCollection();
        /* Get the MongoDB instances that is used to connect to MongoDB for querying purposes */
    }

    public void changeCollection(String newCollectionTitle) {
        collection = database.getCollection(newCollectionTitle);  // Get database collection as passed in the constructor
        log.info("*** MONGO DB *** Collectie aanpassing naar: " + newCollectionTitle);
    }

    private FindIterable<Document> returnDocuments(String operation, String resultMatcher, String valueORkey, boolean returnList) {
        int resultSetNumber = 0; // Integer is used later to count query results
        FindIterable<Document> query = null; // Is used to join query results in one object

        switch (operation) {
            case "valueFromKeyObject":
                query = collection.find(eq(resultMatcher, valueORkey)); // Query: Search one value in a specific field
                break;
            case "valueFromKey":
                query = collection.find(exists(resultMatcher)); // Query: Search if a value exists in a data object
                break;
            default:
                Assert.fail("Geen query operatie geselecteerd!"); // If no operation is selected stop the test
                break;
        }             // TODO: MEER CASES AANMAKEN -> Inventariseren hoe TestData set eruit ziet en dan vervolgens meer CASES aanmaken voor MongoDB Querying

        for (Document notrelevantVariable : query) {
            resultSetNumber++; // Count query results. This solution has been choosen because MongoDB has no custom function to count query results.
        }

        /* Based on the count we determine the log information to inform the user about multiple testdata sets, one testdata set or no set at all. */
        if (resultSetNumber == 0) {
            log.error("Geen testdata set gevonden.");
            Assert.fail("Geen testdata gevonden.");
        } else if (resultSetNumber == 1) {
            query = query.limit(1);
        } else if (!returnList && resultSetNumber > 1) {
            log.warn("Let op het resultaat geeft meer dan 1 testdata set terug. Het 1e resultaat wordt gebruikt als testdata.");
            query = query.limit(1);
        }

        return query;
    }

    public String getTestDataByAttributeAndValue(String attribute, String value, String keyToReturn) {
        testData = returnDocuments("valueFromKeyObject", attribute, value, false); // Start query method and return one data object. False == one.
        String dataResult = null; // The variable where the data object will be loaded

        for (Document testDataResult : testData) {
            dataResult = String.valueOf(testDataResult.get(keyToReturn)); // Load the data object into the variable
        }

        return dataResult;
        /* This method returns a single result from a column that matches the search query.
        For example: Look up all NAMES where column AGE = 18 and return one result. This would return one name where AGE = 18. */
    }

    public List<String> getTestDataResultListByAttributeAndValue(String attribute, String value, String keyToReturn) {
        testData = returnDocuments("valueFromKeyObject", attribute, value, true); // Start query method and return multiple data objects. True == multiple.
        ArrayList<String> dataList = new ArrayList<>(); // The List where the data objects will be loaded in.

        for (Document testDataResult : testData) {
            dataList.add(String.valueOf(testDataResult.get(keyToReturn))); // Load the data objects into the List
        }

        return dataList;
        /* This method returns a List of values from a column that matches the search query.
        For example: Look up all NAMES where column AGE = 18. This would return all names where AGE = 18. */
    }
}
