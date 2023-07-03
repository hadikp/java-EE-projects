package loan.debtor;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepositServlet extends HttpServlet {

    @Inject
    DepositRestAssured depositRestAssured;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Deposit depositsFromRestAssured = depositRestAssured.getDepositFromEndpoint();
        req.setAttribute("deposit", depositsFromRestAssured);
        req.getRequestDispatcher("/WEB-INF/jsp/depositFromEndpoint.jsp").forward(req, resp);
    }
}
