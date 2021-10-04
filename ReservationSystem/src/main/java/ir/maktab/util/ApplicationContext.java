package ir.maktab.util;

import ir.maktab.repository.CustomerRepository;
import ir.maktab.repository.EmployeeRepository;
import ir.maktab.repository.FlightScheduleRepository;
import ir.maktab.repository.UserRepository;
import ir.maktab.repository.impl.CustomerRepositoryImpl;
import ir.maktab.repository.impl.EmployeeRepositoryImpl;
import ir.maktab.repository.impl.FlightScheduleRepositoryImpl;
import ir.maktab.repository.impl.UserRepositoryImpl;
import ir.maktab.service.CustomerService;
import ir.maktab.service.EmployeeService;
import ir.maktab.service.FlightScheduleService;
import ir.maktab.service.UserService;
import ir.maktab.service.impl.CustomerServiceImpl;
import ir.maktab.service.impl.EmployeeServiceImpl;
import ir.maktab.service.impl.FlightScheduleServiceImpl;
import ir.maktab.service.impl.UserServiceImpl;
import ir.maktab.service.login.LoginService;

public class ApplicationContext {

    private static final UserRepository userRepo;
    public static final UserService userServ;

    private static final CustomerRepository customerRepo;
    public static final CustomerService customerServ;

    private static final EmployeeRepository employeeRepo;
    public static final EmployeeService employeeServ;


    private static final FlightScheduleRepository flightScheduleRepo;
    public static final FlightScheduleService flightScheduleServ;

    public static final LoginService loginServ;

    public static final CheckInputInformation chInInformation;

    private ApplicationContext(){
    }

    static {
        userRepo = new UserRepositoryImpl(HibernateUtil.getEntityMangerFactory());
        userServ = new UserServiceImpl(userRepo);

        customerRepo = new CustomerRepositoryImpl(HibernateUtil.getEntityMangerFactory());
        customerServ = new CustomerServiceImpl(customerRepo);

        employeeRepo = new EmployeeRepositoryImpl(HibernateUtil.getEntityMangerFactory());
        employeeServ = new EmployeeServiceImpl(employeeRepo);

        flightScheduleRepo = new FlightScheduleRepositoryImpl(HibernateUtil.getEntityMangerFactory());
        flightScheduleServ = new FlightScheduleServiceImpl(flightScheduleRepo);

        loginServ = new LoginService(userServ);

        chInInformation = new CheckInputInformation();

    }
}

