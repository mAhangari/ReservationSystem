package ir.maktab.controller.servlet;

import ir.baseCRUD.domain.enumeration.UserType;
import ir.maktab.model.Employee;
import ir.maktab.model.enumeration.WorkPlace;
import ir.maktab.util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddEmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher;

        if (request.getParameter("password").equals(request.getParameter("passRepeat"))) {

            UserType userType;
            if (request.getParameter("employeeType").equals("1"))
                userType = UserType.Employee;
            else userType = UserType.Boss;

            Employee employee = new Employee(
                    request.getParameter("username"),
                    request.getParameter("password"),
                    request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("nationalCode"),
                    userType,
                    WorkPlace.AIRLINE
            );
            Employee boss = (Employee) session.getAttribute("account");
            employee.setAirline(boss.getAirline());
            ApplicationContext.employeeServ.save(employee);
            request.setAttribute("message", "New Employee Add Successful!!");

        }
        else {
            request.setAttribute("message", "Passwords doesn't match!!!");
        }
        requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/boss/add_employee.jsp");
        requestDispatcher.forward(request, response);
    }
}
