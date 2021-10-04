package ir.maktab.model;

import ir.baseCRUD.domain.enumeration.UserType;
import ir.maktab.model.enumeration.WorkPlace;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Employee extends User {

    private static final String WORK_PLACE = "work_place";

    @Column(name = WORK_PLACE)
    @Setter(AccessLevel.PRIVATE)
    @Enumerated(EnumType.STRING)
    private WorkPlace workPlace;

    @ManyToOne
    private Airline airline;

    public Employee(String username, String password, String firstName, String lastName,
                    String nationalCode, UserType userType, WorkPlace workPlace) {
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        super.setNationalCode(nationalCode);
        setUserType(userType);
        setWorkPlace(workPlace);
    }

    @Override
    public String toString() {
        return "Employee{" +
                '}';
    }
}
