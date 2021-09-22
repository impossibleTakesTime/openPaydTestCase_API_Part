package openPaydApi.stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class testApi {

    Response response;

    @When("I get a list of blog posts using the API endpoint")
    public void i_get_a_list_of_blog_posts_using_the_API_endpoint() {
        response = given().accept(ContentType.JSON)
                .when().get(baseURI + "/posts");


        // verify status code 200
        assertEquals(response.statusCode(),200);
        assertTrue("Api latency is greater than 1000ms",response.time()<1000);

    }

    @Then("User {int} should have {int} posts")
    public void user_should_have_posts(Integer userId, Integer numPosts) {
        List<Integer> usedID;
        JsonPath jp= response.jsonPath();
        usedID= jp.getList("userId");
        Integer count = Collections.frequency(usedID,userId);
        assertEquals(numPosts, count);
    }

    @Then("Each blog post should have a unique ID")
    public void each_blog_post_should_have_a_unique_ID() {
        List<Integer> uniqueID;
        JsonPath jp= response.jsonPath();
        uniqueID= jp.getList("id");
        assertTrue(uniqueID.stream().distinct().count() == uniqueID.stream().count());
    }



}
