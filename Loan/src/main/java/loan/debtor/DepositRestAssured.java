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
        String fund = response.jsonPath().getString("fund[0]");
        String interest = response.jsonPath().getString("interest[0]");
        String year = response.jsonPath().getString("depositYear[0]");
        String payment = response.jsonPath().getString("payment[0]");
        System.out.println("Tőke:" + Integer.valueOf(fund));
        System.out.println("Kamat:" + Double.valueOf(interest));
        System.out.println("Pénz lekötésének évei:" + Integer.valueOf(year));
        System.out.println("Befizetés:" + Integer.valueOf(payment));
    }
}
