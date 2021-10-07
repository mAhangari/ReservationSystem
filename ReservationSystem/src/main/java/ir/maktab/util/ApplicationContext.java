package ir.maktab.util;

import ir.maktab.repository.*;
import ir.maktab.repository.impl.*;
import ir.maktab.service.*;
import ir.maktab.service.impl.*;
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

    private static final AirlineRepository airlineRepo;
    public static final AirlineService airlineServ;

    public static final LoginService loginServ;

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

        airlineRepo = new AirlineRepositoryImpl(HibernateUtil.getEntityMangerFactory());
        airlineServ = new AirlineServiceImpl(airlineRepo);

        loginServ = new LoginService(userServ);

    }
}

