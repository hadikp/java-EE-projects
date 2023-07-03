package loan.debtor;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

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

    public Deposit dataFromApi(String endpoint) throws ParseException {
        Response response = doGetRequest(endpoint);

        Object[] funds = response.jsonPath().getList("fund").toArray();
        //String interest = response.jsonPath().getString("interest[1]");
        int lastListElement = funds.length - 1;
        Object[] interests = response.jsonPath().getList("interest").toArray();
        Object[] years = response.jsonPath().getList("depositYear").toArray();
        Object[] payments = response.jsonPath().getList("payment").toArray();
        Object[] annuities = response.jsonPath().getList("annuity").toArray();
        Object[] annuitiesYears = response.jsonPath().getList("annuitiesYear").toArray();
        Object[] depositInterestByYears = response.jsonPath().getList("depositInterestByYear").toArray();
        Object[] depositInterestByMonths = response.jsonPath().getList("depositInterestByMonth").toArray();

        Deposit depositFromEndpoint = new Deposit((Integer) funds[lastListElement], (Float) interests[lastListElement], (Integer) years[lastListElement], (Integer) payments[lastListElement],
               (String) annuities[lastListElement], (Integer) annuitiesYears[lastListElement], (String) depositInterestByYears[lastListElement], (String) depositInterestByMonths[lastListElement]);

        System.out.println("Tőke: " +  funds[lastListElement]); //int
        System.out.println("Kamat: " + interests[lastListElement]); //Float
        System.out.println("Pénz lekötésének évei: " + years[lastListElement]); //int
        System.out.println("Befizetés: " + payments[lastListElement]); //int
        System.out.println("Életjáradék: " + annuities[lastListElement]); //String, DecimalFormat.getNumberInstance().parse(annuity).doubleValue()
        System.out.println("Pénzgyűjtés évei: " + annuitiesYears[lastListElement]); //int
        System.out.println("Kamatos kamat évente: " + depositInterestByYears[lastListElement]); //String
        System.out.println("Kamatos kamat havonta: " + depositInterestByMonths[lastListElement]); //String

        return depositFromEndpoint;
    }

}
