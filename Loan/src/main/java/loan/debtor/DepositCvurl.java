package loan.debtor;

import coresearch.cvurl.io.model.Response;
import coresearch.cvurl.io.request.CVurl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class DepositCvurl {

    public DepositCvurl() {
    }

    public void cVurl(){
        CVurl cVurl = new CVurl();

        //GET
        Response<String> response = cVurl.get("http://localhost:8080/calc/api/deposit")
                .asString()
                .orElseThrow(RuntimeException::new);
        System.out.println("CVurl GET: " + response.getBody());
    }


}
