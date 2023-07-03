package loan.debtor;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DepositRestAssuredTest {

    DepositRestAssured depositRestAssured = new DepositRestAssured();

    @Test
    public void jsonTest() throws ParseException {
        String uri = "http://localhost:8080/loan-calc/api/deposit";
        depositRestAssured.dataFromApi(uri);
    }


}