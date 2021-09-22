package openPaydApi.stepDefinitions;

import io.cucumber.java.Before;
import openPaydApi.utilities.ConfigurationReader;



import static io.restassured.RestAssured.baseURI;

public class Hooks {
    @Before
    public void beforeClass() {

        baseURI = ConfigurationReader.get("baseUrl");
        System.out.println(baseURI);

    }
}
