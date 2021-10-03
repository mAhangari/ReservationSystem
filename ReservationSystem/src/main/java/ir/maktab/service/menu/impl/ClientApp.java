package ir.maktab.service.menu.impl;

import ir.baseCRUD.domain.enumeration.UserType;
import ir.maktab.model.Customer;
import ir.maktab.model.Employee;
import ir.maktab.model.User;
import ir.maktab.service.menu.ProfileMenu;
import ir.maktab.service.menu.ProfileMenuAbstractFactory;

public class ClientApp {

    private static ProfileMenu profileMenu;

    public ClientApp(ProfileMenuAbstractFactory abstractFactory, User user) {
        if (user.getUserType().equals(UserType.Customer))
            profileMenu = abstractFactory.crateCustomerProfileMenu((Customer) user);
        else if (user.getUserType().equals(UserType.Employee))
            profileMenu = abstractFactory.createSimpleEmployeeProfileMenu((Employee) user);
        else profileMenu = abstractFactory.createBossProfileMenu((Employee) user);
    }

    public ProfileMenu getProfileMenu() {

        return profileMenu;
    }

}
