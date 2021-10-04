package ir.maktab.model;

import ir.baseCRUD.base.domain.BaseEntity;
import ir.baseCRUD.base.service.IUser;
import ir.baseCRUD.domain.enumeration.UserType;
import lombok.*;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<Long> implements IUser {

    public static final String TABLE_NAME = "user_table";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String USER_NAME = "user_name";
    private static final String PASSWORD = "password";
    private static final String USER_TYPE = "user_type";
    private static final String MOBILE_NUMBER = "mobile_number";
    private static final String EMAIL = "email";
    private static final String BIRTH_DATE = "birth_date";
    private static final String USER_ID = "user_id";
    private static final String IS_ACTIVE = "is_active";
    private static final String LOGGED_IN = "logged_in";
    private static final String NATIONAL_CODE = "national_code";

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = USER_NAME, unique = true, nullable = false)
    private String username;

    @Column(name = PASSWORD, nullable = false)
    @Getter(AccessLevel.PRIVATE)
    private String password;

    @Column(name = USER_TYPE, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @ElementCollection
    @CollectionTable(name = MOBILE_NUMBER, joinColumns = @JoinColumn(name = USER_ID))
    @Column(name = MOBILE_NUMBER)
    private Set<String> mobileNumber = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = EMAIL, joinColumns = @JoinColumn(name = USER_ID))
    private Set<String> email = new HashSet<>();

    @Column(name = BIRTH_DATE)
    private ZonedDateTime birthDate;

    @Column(name = NATIONAL_CODE, nullable = false, unique = true)
    private String nationalCode;

    @Column(name = IS_ACTIVE)
    private boolean isActive = true;

    @Column(name = LOGGED_IN)
    private boolean loggedIn;

    @Override
    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    @Override
    public void setLoggedIn(boolean value) {
        this.loggedIn = value;
    }

    @Override
    public void setRevoked(boolean value) {
        setActive(!value);
    }

    @Override
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    @Override
    public boolean isRevoked() {
        return !isActive();
    }
}