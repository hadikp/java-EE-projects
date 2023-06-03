package calculate.deposit;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepositServlet extends HttpServlet {

    @Inject
    private DepositService depositService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fund = Integer.parseInt(req.getParameter("fund"));
        double integer = Double.parseDouble(req.getParameter("fund"));
        int depositYear = Integer.parseInt(req.getParameter("depositYear"));
        int payment = Integer.parseInt(req.getParameter("payment"));
        depositService.createData(fund, integer, depositYear, payment);
        resp.sendRedirect("deposit");
    }
}
