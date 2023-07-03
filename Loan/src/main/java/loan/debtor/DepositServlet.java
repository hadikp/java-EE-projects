package loan.debtor;

import lombok.SneakyThrows;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

    @Inject
    DepositRestAssured depositRestAssured;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Deposit depositsFromRestAssured = depositRestAssured.dataFromApi("http://localhost:8080/loan-calc/api/deposit");
        req.setAttribute("deposit", depositsFromRestAssured);
        req.getRequestDispatcher("/WEB-INF/jsp/depositFromEndpoint.jsp").forward(req, resp);
    }
}
