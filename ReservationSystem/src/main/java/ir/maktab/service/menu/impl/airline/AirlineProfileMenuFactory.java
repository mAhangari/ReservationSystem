package ir.maktab.service.menu.impl.airline;

import ir.maktab.model.Customer;
import ir.maktab.model.Employee;
import ir.maktab.service.menu.ProfileMenu;
import ir.maktab.service.menu.ProfileMenuAbstractFactory;

public class AirlineProfileMenuFactory implements ProfileMenuAbstractFactory {

    @Override
    public ProfileMenu createBossProfileMenu(Employee employee) {
        return new AirlineBossProfileMenu(employee);
    }

    @Override
    public ProfileMenu createSimpleEmployeeProfileMenu(Employee employee) {
        return new AirlineSimpleEmployeeProfileMenu(employee);
    }

    @Override
    public ProfileMenu crateCustomerProfileMenu(Customer customer) {
        return new AirlineCustomerProfileMenu(customer);
    }
}
