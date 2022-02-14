package Game.Utils;

import java.util.regex.Pattern;

public class Form {
	public static boolean verifyEmail(String email) {
		String regexPattern = "^(.+)@(\\S+)$";
		
		return Pattern.compile(regexPattern)
			.matcher(email)
			.matches();	}
}
