package ir.maktab.util;

import ir.maktab.service.menu.BaseMenu;
import java.util.regex.Pattern;

public class CheckInputInformation {

	public boolean checkUsername(String username) {
		boolean check = ApplicationContext.userServ.existsByUsername(username);
		if(check) {
			BaseMenu.singlePrintMessage("This Username is already Exists.");
			return true;
		}
		boolean match = Pattern.matches("^[A-Za-z0-9_-]{3,15}$", username);
		return !match;
	}

	public boolean checkPassword(String password) {
		boolean match = Pattern.matches("^.{8,}$", password);
		return !match;
	}

	public boolean checkDate(String date) {
		boolean match = Pattern.matches("^(19|20)\\d\\d(-)(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$", date);
		return !match;
	}

	public boolean checkEmailAddress(String email) {
		boolean match = Pattern.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", email);
		return !match;
	}

	public boolean checkPhoneNumber(String Phone) {
		boolean match = Pattern.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", Phone);
		return !match;
	}

}
