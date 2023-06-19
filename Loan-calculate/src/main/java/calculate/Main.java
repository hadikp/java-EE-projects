package calculate;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Main {
    public static void main(String[] args) {
        //ActiveMQ végpont
        String endpoint = "http://localhost:8161/api/jolokia";

        //ActiveMQ lekérdezése
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .param("mbean", "org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=MyQueue")
                .get(endpoint);

        //Válasz
        if (response.statusCode() == 200){
            String responseBody = response.getBody().asString();
            System.out.println(responseBody);
        }else {
            System.out.println("Failed to query ActiveMQ Queue. Status code: " + response.statusCode());
        }
    }
}