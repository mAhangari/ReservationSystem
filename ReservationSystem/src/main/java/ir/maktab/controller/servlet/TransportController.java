package ir.maktab.controller.servlet;

import ir.maktab.model.Employee;
import ir.maktab.model.enumeration.WorkPlace;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TransportController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);

        Employee employee = (Employee) session.getAttribute("account");
        if (employee.getWorkPlace().equals(WorkPlace.AIRLINE)) {
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/src/main/views/profile/employee/create_travel_schedule.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
