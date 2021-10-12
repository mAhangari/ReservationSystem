package ir.maktab.controller.servlet;

import ir.maktab.model.Coupon;
import ir.maktab.util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TicketController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/customer/confirm_ticket.jsp");
        HttpSession session = request.getSession(false);

        boolean isExists = ApplicationContext.couponServ.existsByCouponCode(request.getParameter("coupon"));
        if (isExists) {
            Coupon coupon = ApplicationContext.couponServ.findByCouponCode(request.getParameter("coupon"));
            request.setAttribute("Coupon", coupon);
            request.setAttribute("message", "The discount was successfully applied");
        }else request.setAttribute("message", "Sorry! Coupon code not correct.");
        requestDispatcher.forward(request, response);
    }
}
