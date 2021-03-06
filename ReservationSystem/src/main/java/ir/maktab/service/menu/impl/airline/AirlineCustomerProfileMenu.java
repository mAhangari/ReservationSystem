package ir.maktab.service.menu.impl.airline;

import ir.maktab.model.Customer;
import ir.maktab.service.menu.ProfileMenu;
import lombok.AccessLevel;
import lombok.Getter;

public class AirlineCustomerProfileMenu implements ProfileMenu {

    @Getter(AccessLevel.PRIVATE)
    private final Customer customer;

    public AirlineCustomerProfileMenu(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String dashboard() {
        return "customer";
    }
}
