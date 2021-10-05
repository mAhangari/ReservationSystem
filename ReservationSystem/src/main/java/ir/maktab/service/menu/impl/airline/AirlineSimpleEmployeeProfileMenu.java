package ir.maktab.service.menu.impl.airline;

import ir.maktab.model.Employee;
import ir.maktab.service.menu.ProfileMenu;
import lombok.AccessLevel;
import lombok.Getter;

public class AirlineSimpleEmployeeProfileMenu implements ProfileMenu {

    @Getter(AccessLevel.PRIVATE)
    private final Employee employee;

    public AirlineSimpleEmployeeProfileMenu(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String dashboard() {
        return "simpleEmployee";
    }
}
