package loan.debtor;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DepositRestAssuredTest {

    @Test
    public void jsonTest() throws ParseException {
        String uri = "http://localhost:8080/loan-calc/api/deposit";
        DepositRestAssured depositRestAssured = new DepositRestAssured();
        depositRestAssured.dataFromApi(uri);
    }

}