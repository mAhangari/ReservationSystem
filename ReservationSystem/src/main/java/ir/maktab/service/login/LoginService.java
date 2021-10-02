package ir.maktab.service.login;

import ir.maktab.domain.User;
import ir.maktab.service.ExceptionHandling.AccountNotFoundException;
import ir.maktab.service.UserService;
import ir.maktab.util.LoginServiceContext;

public class LoginService extends LoginServiceContext {
    private final UserService userService;

    public LoginService(UserService userService) {
        super(new AwaitingFirstLoginAttempt());
        this.userService = userService;
    }

    public User login(String username, String password) {
        User user = userService.findUserByUsername(username);

        if (user == null)
            throw new AccountNotFoundException("Account not exists");

        return getState().login(this, user, password);
    }
}