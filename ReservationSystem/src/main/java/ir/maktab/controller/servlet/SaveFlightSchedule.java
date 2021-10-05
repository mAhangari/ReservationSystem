package ir.maktab.controller.servlet;

import ir.maktab.model.Employee;
import ir.maktab.model.FlightSchedule;
import ir.maktab.util.ApplicationContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

public class SaveFlightSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);

        FlightSchedule flightSchedule = new FlightSchedule();
        flightSchedule.setSource(request.getParameter("source"));
        flightSchedule.setDestination(request.getParameter("destination"));
        flightSchedule.setFlyTime(LocalDateTime.parse(request.getParameter("travelDay")));
        flightSchedule.setFlightNumber(request.getParameter("flightNumber"));
        flightSchedule.setPrice(request.getParameter("flightPrice"));
        Employee employee = (Employee) session.getAttribute("account");
        flightSchedule.setAirline(employee.getAirline());
        ApplicationContext.flightScheduleServ.save(flightSchedule);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/src/main/views/simple_employee_profile.jsp");
        requestDispatcher.forward(request, response);

    }
}
