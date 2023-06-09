package loan;

import coresearch.cvurl.io.model.Response;
import coresearch.cvurl.io.request.CVurl;

import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CVurl cVurl = new CVurl();

        //GET
        Response<String> response = cVurl.get("http://localhost:8080/calc/api/deposit")
                .asString()
                .orElseThrow(RuntimeException::new);
        System.out.println("CVurl GET: " + response.getBody());
    }
}