package ir.maktab.model;

import ir.baseCRUD.domain.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer extends User {

	private static final String WALLET_ID = "wallet_id";


	@OneToOne
	@JoinColumn(name = WALLET_ID, unique = true)
	private Wallet wallet;

	public Customer(String username, String password, String firstName,
			String lastName, String nationalCode) {
		super.setUsername(username);
		super.setPassword(password);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setNationalCode(nationalCode);
		super.setUserType(UserType.Customer);
	}
	
	@Override
	public String toString() {
		return  "id='" + getId() + "' " +
                "firstName= '" + getFirstName() + "' " +
                "lastName= '" + getLastName() + "' " +
                "username= '" + getUsername() + "' " +
                "birthday= '" + getBirthDate() + "' ";
	}
}
