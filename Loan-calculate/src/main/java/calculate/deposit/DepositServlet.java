package calculate.deposit;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

    @Inject
    private DepositService depositService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int depositYear = Integer.parseInt(req.getParameter("depositYear"));
        int fund = Integer.parseInt(req.getParameter("fund"));
        double interest = Double.parseDouble(req.getParameter("interest"));
        int payment = Integer.parseInt(req.getParameter("payment"));
        depositService.addData(fund, interest, depositYear, payment);
        resp.sendRedirect("deposit");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Deposit> deposits = depositService.listDepositData();
        List<String> depositByYears = depositService.listDepositInterestByYear();
        List<String> depositByMonths = depositService.listDepositInterestByMonth();
        List<String> annuities = depositService.listAnnuity();
        depositService.depositInterestByYear(); //fusson le a függvény
        depositService.depositInterestByMonth(); //fusson le a függvény
        depositService.getAnnuity(); //fusson le a függvény
        req.setAttribute("deposits", deposits);
        req.setAttribute("depositByYears", depositByYears);
        req.setAttribute("depositByMonths", depositByMonths);
        req.setAttribute("annuities", annuities);
        req.getRequestDispatcher("/WEB-INF/jsp/deposit.jsp").forward(req, resp);
    }
}
