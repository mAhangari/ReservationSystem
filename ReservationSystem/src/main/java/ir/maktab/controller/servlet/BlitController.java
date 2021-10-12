package ir.maktab.controller.servlet;

import ir.maktab.model.Customer;
import ir.maktab.model.FlightSchedule;
import ir.maktab.model.Ticket;
import ir.maktab.model.Wallet;
import ir.maktab.util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BlitController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession(false);


        Long flightId = Long.valueOf((String) session.getAttribute("flightOpt"));
        FlightSchedule flightSchedule = ApplicationContext.flightScheduleServ.findById(flightId);

        Customer customer = (Customer) session.getAttribute("account");

        Wallet wallet = ApplicationContext.walletServ.findById(customer.getWallet().getId());
        if (wallet.getTotalAmount() >= Double.parseDouble((String) session.getAttribute("totalAmount"))) {
            wallet.setCashAmount(customer.getWallet().getCashAmount() - Double.parseDouble((String) session.getAttribute("totalAmount")));
            ApplicationContext.walletServ.save(wallet);

            Ticket customerTicket = new Ticket();
            customerTicket.setCustomer(customer);
            customerTicket.setFlightSchedule(flightSchedule);
            ApplicationContext.ticketServ.save(customerTicket);

            request.setAttribute("message", "Congratulations, the ticket purchase was successful !!!");

        } else {
            request.setAttribute("message", "Account balance is not enough !!!");
        }
        requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/customer/buy_ticket.jsp");
        requestDispatcher.forward(request, response);
    }
}
