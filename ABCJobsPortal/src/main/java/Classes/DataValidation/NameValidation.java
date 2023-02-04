package Classes.DataValidation;

import java.util.regex.Pattern;

public class NameValidation {
	public static String nameRegex= "[a-zA-Z][a-zA-Z ]*";
			//"^[a-zA-Z].*[\\s\\.]*$";

	
	public Boolean nameValidate(String name) {
		Pattern namePattern = Pattern.compile(nameRegex);
		System.out.println(namePattern.matcher(name).matches());
		return namePattern.matcher(name).matches();
	}
}
