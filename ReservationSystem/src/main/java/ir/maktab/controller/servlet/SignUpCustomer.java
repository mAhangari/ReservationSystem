package ir.maktab.controller.servlet;

import ir.maktab.model.Customer;
import ir.maktab.model.Wallet;
import ir.maktab.util.ApplicationContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class SignUpCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher;

        if (!Objects.equals(request.getParameter("password"), request.getParameter("passRepeat"))) {
            request.setAttribute("message", "Passwords does not match!!!");
            requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/customer/sign_up.jsp");
        } else {

            boolean check = ApplicationContext.userServ.existsByUsername(request.getParameter("username"));
            if (check) {
                request.setAttribute("message", "This Username is already Exists.");
                requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/customer/sign_up.jsp");
            } else {

                Customer customer = new Customer(request.getParameter("username"),
                        request.getParameter("password"),
                        request.getParameter("firstName"),
                        request.getParameter("lastName"),
                        request.getParameter("nationalCode"));

                Wallet wallet = new Wallet();
                ApplicationContext.walletServ.save(wallet);
                customer.setWallet(wallet);
                ApplicationContext.userServ.save(customer);

                request.setAttribute("message", "Congratulations!" +
                        request.getParameter("firstName") +
                        " " + request.getParameter("lastName") +
                        "Your Registration was Successful!!!");

                requestDispatcher = request.getRequestDispatcher("/index.jsp");
            }
        }
        requestDispatcher.forward(request, response);
    }
}
