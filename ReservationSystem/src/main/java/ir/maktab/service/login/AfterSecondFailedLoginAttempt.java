package ir.maktab.service.login;

import ir.maktab.model.User;
import ir.maktab.util.ApplicationContext;
import ir.maktab.util.LoginServiceContext;

public class AfterSecondFailedLoginAttempt extends LoginServiceState {
    private final String previousAccountId;

    public AfterSecondFailedLoginAttempt(String previousAccountId) {
        this.previousAccountId = previousAccountId;
    }

    @Override
    public void handleIncorrectPassword(LoginServiceContext context, User account,
                                        String password) {
        if (previousAccountId.equals(account.getUsername())) {
            account.setRevoked(true);
            context.setState(new AwaitingFirstLoginAttempt());
            ApplicationContext.userServ.save(account);
        } else {
            context.setState(new AfterFirstFailedLoginAttempt(account.getUsername()));
        }
    }
}