package com.practise.code.strings;

import java.security.SecureRandom;

/**
 * Another way to prove that Strings provide security in Java is to use the
 * GuardedString class. The GuardedString class is a secure string
 * implementation that solves the problems associated with keeping passwords as
 * Java Strings. The GuardedString class stores the characters in memory in an
 * encrypted form, which makes it much more difficult for hackers to access.
 */

public class GaurdedStringTest {

	public static void main(String[] args) {
		// Generate a random password.
		String password = new SecureRandom().toString();

		// Create a GuardedString object.
		// GuardedString guardedPassword = new GuardedString(password.toCharArray());

		// Try to modify the password.
		// guardedPassword.clear();

		// Print the password.
		// System.out.println(guardedPassword.getChars());
	}

}
