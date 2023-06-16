package loan.debtor;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.text.DecimalFormat;
import java.text.ParseException;

import static io.restassured.RestAssured.given;

public class DepositRestAssured {

    public static Response doGetRequest(String endpoint){
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public void dataFromApi(String endpoint) throws ParseException {
        Response response = doGetRequest(endpoint);
        String fund = response.jsonPath().getString("fund[2]");
        String interest = response.jsonPath().getString("interest[2]");
        String year = response.jsonPath().getString("depositYear[2]");
        String payment = response.jsonPath().getString("payment[2]");
        String annuity = response.jsonPath().getString("annuity[2]");
        String annuitiesYear = response.jsonPath().getString("annuitiesYear[2]");
        String depositInterestByYear = response.jsonPath().getString("depositInterestByYear[2]");
        String depositInterestByMonth = response.jsonPath().getString("depositInterestByMonth[2]");
        System.out.println("Tőke: " + Integer.valueOf(fund));
        System.out.println("Kamat: " + Double.valueOf(interest));
        System.out.println("Pénz lekötésének évei: " + Integer.valueOf(year));
        System.out.println("Befizetés: " + Integer.valueOf(payment));
        System.out.println("Életjáradék: " + DecimalFormat.getNumberInstance().parse(annuity).doubleValue());
        System.out.println("Pénzgyűjtés évei: " + annuitiesYear);
        System.out.println("Kamatos kamat évente: " + depositInterestByYear);
        System.out.println("Kamatos kamat havonta: " + depositInterestByMonth);
    }
}
