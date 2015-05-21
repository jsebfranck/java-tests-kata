package com.jsebfranck.kata.password;

public class PasswordUtils {

	/**
	 * To be valid a password must respect the following rules :
	 * - not null
	 * - length >= 8
	 * - at least one digit
	 * - at least one letter in upper case
	 * - at least one letter in lower case
	 * - at least a none alphanumeric character
	 */
	public static boolean isPasswordValid(String password) {
		boolean hasAnUpperCaseLetter = false;
		boolean hasALowerCaseLetter = false;
		boolean hasADigit = false;
		boolean hasANoneAlphaNumericCharacter = false;

		for (int i = 0 ; i <= password.length() ; i++) {
			char currentChar = password.charAt(i);

			if (Character.isLowerCase(currentChar)) {
				hasALowerCaseLetter = true;
			} else if (Character.isUpperCase(currentChar)) {
				hasALowerCaseLetter = true;
			} else if (Character.isDigit(currentChar)) {
				hasADigit = true;
			} else if (!Character.isAlphabetic(currentChar)) {
				hasANoneAlphaNumericCharacter = true;
			}
		}

		return hasADigit && hasALowerCaseLetter && hasALowerCaseLetter && hasANoneAlphaNumericCharacter;
	}
}
