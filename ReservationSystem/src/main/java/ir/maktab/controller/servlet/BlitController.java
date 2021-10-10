package ir.maktab.controller.servlet;

import ir.maktab.model.Customer;
import ir.maktab.model.FlightSchedule;
import ir.maktab.model.Ticket;
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
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession(false);

        if (request.getParameter("flightOption") != null) {

            Long flightId = Long.valueOf(request.getParameter("flightOption"));
            FlightSchedule flightSchedule = ApplicationContext.flightScheduleServ.findById(flightId);

            Customer customer = (Customer) session.getAttribute("account");
            Ticket customerTicket = new Ticket();
            customerTicket.setCustomer(customer);
            customerTicket.setFlightSchedule(flightSchedule);

            ApplicationContext.ticketServ.save(customerTicket);

            request.setAttribute("message", "Congratulations, the ticket purchase was successful !!!");

            requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/customer/buy_ticket.jsp");
        } else {
            request.setAttribute("message", "No tickets selected!!!");
            requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/customer/show_flight_schedule.jsp");
        }
        requestDispatcher.forward(request, response);
    }
}
