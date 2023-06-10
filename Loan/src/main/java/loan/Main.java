package loan;

import coresearch.cvurl.io.model.Response;
import coresearch.cvurl.io.request.CVurl;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String uri = "http://localhost:8080/calc/api/deposit";

        CVurl cVurl = new CVurl();

        //GET
        Response<String> response = cVurl.get(uri)
                .asString()
                .orElseThrow(RuntimeException::new);
        System.out.println("CVurl GET: " + response.getBody());


    }
}