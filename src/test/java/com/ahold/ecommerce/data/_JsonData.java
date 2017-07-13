package com.ahold.ecommerce.data;

import com.ahold.ecommerce.driver.CukeConfigurator;
import io.qameta.allure.Step;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class _JsonData extends CukeConfigurator {

    public String JsonData(String category, String data) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(testdata_dir));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsondata = (JSONArray) jsonObject.get(category);

        String ah_data = null;
        for (Object ahobjects : jsondata) {
            JSONObject jsonNumber = (JSONObject) ahobjects;
            ah_data = (String) jsonNumber.get(data);
        }
        dataRetrieve(category, data, ah_data);
        return ah_data;
    }

    @Step("Retreive required JSON data:")
    public void dataRetrieve(String category, String data, String retrievedData) {}
}
