package ir.maktab.controller.filter;

import ir.maktab.model.User;
import ir.maktab.service.ExceptionHandling.AccountLoginLimitReachedException;
import ir.maktab.service.ExceptionHandling.AccountNotFoundException;
import ir.maktab.util.ApplicationContext;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        try {
            User account = ApplicationContext.loginServ.login(username, password);
            if (account.isLoggedIn()) {
                session.setAttribute("account", account);
                //request.setAttribute("account", account);
                filterChain.doFilter(request, response);
            } else dispatchFailedLogin(request, response);
        } catch (AccountNotFoundException | AccountLoginLimitReachedException foundException) {
            dispatchFailedLogin(request, response);
        }
    }

    private void dispatchFailedLogin(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/src/main/views/login_failed.jsp");
        requestDispatcher.include(request, response);
    }

    @Override
    public void destroy() {
    }
}
