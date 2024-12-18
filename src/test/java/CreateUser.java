import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Randomgenerator;
import static io.restassured.RestAssured.given;

public class CreateUser {

    Randomgenerator email = new Randomgenerator();
    public String baseURI="https://ai-coach.bes-learning.com/api/v1";

    public String signingEmail ="Thor"+email.RandomNumberString()+"@yopmail.com";

    @Test
    @Feature("Positive Scenario")
    public void CreateAccount_POST(){
        String body = "{\"email\": \"" + signingEmail + "\"}";

        System.out.println(body);

        Response response = given()
                .contentType("application/json")
                .body(body)
                .post(baseURI+"/auth/register");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);

/*        String password = response.jsonPath().getString("password");

        System.out.println("Password: " + password);*/
    }
}
