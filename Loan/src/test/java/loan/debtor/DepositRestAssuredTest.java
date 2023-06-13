package loan.debtor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositRestAssuredTest {

    @Test
    public void jsonTest(){
        String uri = "http://localhost:8080/loan-calc/api/deposit";
        DepositRestAssured depositRestAssured = new DepositRestAssured();
        depositRestAssured.dataFromApi(uri);
    }

}