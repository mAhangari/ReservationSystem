package ir.maktab.controller.filter;

import ir.maktab.model.User;
import ir.maktab.service.ExceptionHandling.AccountNotFoundException;
import ir.maktab.util.ApplicationContext;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User account = ApplicationContext.loginServ.login(username, password);
            filterChain.doFilter(request, response);
        } catch (AccountNotFoundException a) {
            out.println("<h1>Sorry username or password incorrect!!!</h1>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.include(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
