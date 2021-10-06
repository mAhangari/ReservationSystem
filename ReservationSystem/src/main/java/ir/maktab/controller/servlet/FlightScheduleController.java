package ir.maktab.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.maktab.model.FlightSchedule;
import ir.maktab.model.pojo.FlightSchedulePOJO;
import ir.maktab.util.ApplicationContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightScheduleController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("txt/html");
        HttpSession session = request.getSession(false);
        Long priceValue;
        if (request.getParameter("priceValue").equals(""))
            priceValue = null;
        else priceValue = Long.valueOf(request.getParameter("priceValue"));
        List<FlightSchedule> flightSchedules =
                ApplicationContext.flightScheduleServ.findAllBySourceAndDestination(
                        request.getParameter("source"), request.getParameter("destination"),
                        priceValue,
                        ApplicationContext.airlineServ.findById(Long.valueOf(request.getParameter("airlineName"))));
        List<FlightSchedulePOJO> flightSchedulePOJOS = getObject(flightSchedules);

        ObjectMapper obj = new ObjectMapper();

        try {
            String jsonStr = obj.writeValueAsString(flightSchedulePOJOS);
            session.setAttribute("flightSchedules", jsonStr);

        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/src/main/views/profile/customer/show_flight_schedule.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private List<FlightSchedulePOJO> getObject(List<FlightSchedule> flightSchedules) {
        List<FlightSchedulePOJO> flightSchedulePOJOS = new ArrayList<>();
        for (FlightSchedule flightSchedule: flightSchedules){
            flightSchedulePOJOS.add(new FlightSchedulePOJO(
                    flightSchedule.getFlightNumber(),
                    flightSchedule.getDestination(),
                    flightSchedule.getSource(),
                    flightSchedule.getPrice(),
                    flightSchedule.getAirline().getAirlineName(),
                    flightSchedule.getFlyTime()
            ));
        }
        return flightSchedulePOJOS;
    }

}
