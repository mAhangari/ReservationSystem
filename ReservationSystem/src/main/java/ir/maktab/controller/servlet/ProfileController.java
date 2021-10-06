package ir.maktab.controller.servlet;

import ir.maktab.model.User;
import ir.maktab.service.menu.ClientAppConfiguration;
import ir.maktab.service.menu.ProfileMenu;
import ir.maktab.service.menu.impl.ClientApp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProfileController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession(false);
        User account = (User) session.getAttribute("account");
        //ApplicationContext.userServ.save(account);

        ClientApp app = ClientAppConfiguration.configureApp(account);
        ProfileMenu profile = app.getProfileMenu();

        String typeOfProfile = profile.dashboard();
        if (typeOfProfile.equals("customer")) {
            requestDispatcher =
                    request.getRequestDispatcher("/src/main/views/profile/customer/customer_profile.jsp");
            requestDispatcher.forward(request, response);
        }else if (typeOfProfile.equals("simpleEmployee")){
            requestDispatcher =
                    request.getRequestDispatcher("/src/main/views/profile/employee/simple_employee_profile.jsp");
            requestDispatcher.forward(request, response);
        }else {
            requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/boss/boss_profile.jsp");
            requestDispatcher.forward(request, response);
        }

//        account.setLoggedIn(false);
//        ApplicationContext.userServ.save(account);
//        PrintWriter out = response.getWriter();
//        out.println("<h2>Hello " + account.getFirstName() + " " + account.getLastName() + "</h2>");
    }
}
