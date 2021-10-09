package ir.maktab.controller.servlet;

import ir.maktab.model.Customer;
import ir.maktab.model.Wallet;
import ir.maktab.util.ApplicationContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChargeCustomerWallet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);

        Customer customer = (Customer) session.getAttribute("account");
        Wallet wallet = ApplicationContext.walletServ.findById(customer.getId());
        wallet.setCashAmount(wallet.getCashAmount() + Long.parseLong(request.getParameter("price")));
        ApplicationContext.walletServ.save(wallet);

        request.setAttribute("message", "Account has been charged successfully!!!");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/customer/customer_profile.jsp");
        requestDispatcher.forward(request, response);

    }
}
