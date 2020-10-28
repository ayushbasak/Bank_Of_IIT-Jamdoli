package HelperClasses;

public class ValidationChecks {
	boolean name(String name) {
		if(name.length() <= 20)
			return true;
		return false;
	}
	boolean date(String dob) {
		if(dob.length() != 10)
			return false;
		else if(Integer.parseInt(dob.substring(0,2)) > 31)
			return false;
		else if(Integer.parseInt(dob.substring(3, 5)) > 12)
			return false;
		else if(Integer.parseInt(dob.substring(6)) > 2002)
			return false;
		return true;
	}
	boolean gender(char gender) {
		if(gender == 'M' || gender  == 'F' || gender == 'O')
			return true;
		return false;
	}
	boolean address(String address) {
		if(address.length() <= 100)
			return true;
		return false;
	}
	boolean pincode(int pincode) {
		if(pincode <= 1000000 && pincode > 9999999)
			return false;
		return true;
	}
}
