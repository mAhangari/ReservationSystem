package ir.maktab.service.impl;

import ir.maktab.model.User;
import ir.maktab.repository.BaseUserRepository;
import ir.maktab.service.CustomerService;
import java.util.Scanner;

public class CustomerServiceImpl extends UserServiceImpl implements CustomerService {

    Scanner input = new Scanner(System.in);

    public CustomerServiceImpl(BaseUserRepository<User, String, String> repository) {
        super(repository);
    }

}
