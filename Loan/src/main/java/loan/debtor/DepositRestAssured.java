package loan.debtor;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DepositRestAssured {

    public static Response doGetRequest(String endpoint){
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public void dataFromApi(String endpoint){
        Response response = doGetRequest(endpoint);
        String fund = response.jsonPath().getString("fund[1]");
        System.out.println(fund);
        /*Map<String, String> fundMap = response.jsonPath().getMap("fund");
        System.out.println(fundMap.get("fund"));*/
    }
}
