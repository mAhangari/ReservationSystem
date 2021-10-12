package ir.maktab.controller.servlet;

import ir.maktab.model.Coupon;
import ir.maktab.util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class DiscountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher requestDispatcher;

        String couponCode = request.getParameter("couponCode");
        LocalDateTime expireDate = LocalDateTime.parse(request.getParameter("expireDate"));
        int offPercentage = Integer.parseInt(request.getParameter("OffPercentage"));

        if (expireDate.isBefore(LocalDateTime.now())) {
            out.println("<p style='color:red'>Expiration date is wrong !!!</p>");
            requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/boss/discount_coupon.jsp");
        } else if (ApplicationContext.couponServ.existsByCouponCode(couponCode)) {
            out.println("<p style='color:red'>Coupon is Already Exists !!!</p>");
            requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/boss/discount_coupon.jsp");
        } else {
            Coupon coupon = new Coupon(couponCode, expireDate, offPercentage);
            ApplicationContext.couponServ.save(coupon);

            out.println("<p style='color:green'>Coupon Creation was Successful !!!</p>");
            requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/boss/boss_profile.jsp");
        }
        requestDispatcher.include(request, response);
    }
}
