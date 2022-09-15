import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldTest {
    @Test
    public void testHelloWorld(){
       Response response = RestAssured
               .get("https://playground.learnqa.ru/api/hello")
               .andReturn();
       response.prettyPrint();

    }

    @Test
    public void getTextFromApi(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/get_text")
                .andReturn();
        response.prettyPrint();
    }

    @Test
    public void testRestAssured(){
        Map<String, String> params = new HashMap<>();
        params.put("name","Gemma");
        JsonPath response = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.get("answer");
        System.out.println(answer);
    }

    @Test
    public void testGetSecondMessage(){
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        //simple way - to get 2nd message bcs there is "get second message text" in ex5
        ArrayList answer = response.get("messages.message");
        System.out.println(answer.get(1));
    }
}
