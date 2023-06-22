package calculate;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://127.0.0.1:8161/api/jolokia")
public class Main {
    public static void main(String[] args) {
        //ActiveMQ végpont
        String endpoint = "http://localhost:8161/api/jolokia/read/org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=LoanQueue";

        //ActiveMQ lekérdezése
        RestAssured.authentication = RestAssured.basic("admin", "admin");
        Response response = RestAssured.get(endpoint);


        //Válasz
        if (response.statusCode() == 200){
            String responseBody = response.getBody().asString();
            System.out.println(responseBody);
        }else {
            System.out.println("Failed to query ActiveMQ Queue. Status code: " + response.statusCode());
        }
    }
}