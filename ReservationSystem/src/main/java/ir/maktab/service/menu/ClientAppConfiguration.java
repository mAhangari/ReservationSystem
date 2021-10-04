package ir.maktab.service.menu;

import ir.baseCRUD.domain.enumeration.UserType;
import ir.maktab.model.Employee;
import ir.maktab.model.User;
import ir.maktab.model.enumeration.WorkPlace;
import ir.maktab.service.menu.impl.ClientApp;
import ir.maktab.service.menu.impl.airline.AirlineProfileMenuFactory;
import java.util.*;

public class ClientAppConfiguration {

    static Scanner input = new Scanner(System.in);
    public static ProfileMenuAbstractFactory abstractFactory;
    public static ClientApp clientApp;

    public static ClientApp configureApp(User user) {

        String logisticName = "";

        if (user.getUserType().equals(UserType.Customer)) {
            logisticName = "airline";

        } else {
            Employee employee = (Employee) user;
            if (employee.getWorkPlace().equals(WorkPlace.AIRLINE)){
                logisticName = "airline";
            }else if (employee.getWorkPlace().equals(WorkPlace.ROAD_LOGISTIC)){
                logisticName = "rad";
            }else logisticName = "sea";
        }

        if (logisticName.equalsIgnoreCase("airline")) {
            abstractFactory = new AirlineProfileMenuFactory();
            clientApp = new ClientApp(abstractFactory, user);
        } else if (logisticName.equalsIgnoreCase("road")) {
//            abstractFactory = new RoadLogisticProfileMenu();
//            clientApp = new ClientApp(abstractFactory);
        } else {
            //abstractFactory = new SeaLogisticProfileMenu();
            //clientApp = new ClientApp(abstractFactory);
        }

        return clientApp;

    }
}
