package ir.maktab.service.menu;

import ir.maktab.model.Customer;
import ir.maktab.model.Employee;

public interface ProfileMenuAbstractFactory {

    ProfileMenu createBossProfileMenu(Employee employee);

    ProfileMenu createSimpleEmployeeProfileMenu(Employee employee);

    ProfileMenu crateCustomerProfileMenu(Customer customer);

}
