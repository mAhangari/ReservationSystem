package ir.maktab.controller.filter;

import ir.maktab.model.User;
import ir.maktab.service.ExceptionHandling.AccountNotFoundException;
import ir.maktab.util.ApplicationContext;
import javax.servlet.*;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User account = ApplicationContext.loginServ.login(username, password);
            request.setAttribute("account", account);
            filterChain.doFilter(request, response);
        } catch (AccountNotFoundException a) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/src/main/views/login_failed.jsp");
            requestDispatcher.include(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
