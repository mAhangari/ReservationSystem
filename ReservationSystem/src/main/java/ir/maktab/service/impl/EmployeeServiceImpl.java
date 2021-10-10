package ir.maktab.service.impl;

import ir.maktab.model.User;
import ir.maktab.repository.BaseUserRepository;
import ir.maktab.service.EmployeeService;

public class EmployeeServiceImpl extends UserServiceImpl implements EmployeeService {

    public EmployeeServiceImpl(BaseUserRepository<User, String, String> repository) {
        super(repository);
    }

}
