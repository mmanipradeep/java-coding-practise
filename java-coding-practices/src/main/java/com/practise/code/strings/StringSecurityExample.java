package com.practise.code.strings;

public class StringSecurityExample {

	public static void main(String args) {

		// create a secret messaage.
		String secretMessage = "This is a secret Message";

		// convertstring to bytes

		byte[] secrestMessageBytes = secretMessage.getBytes();

		// Try to modify the String
		secrestMessageBytes[0] = 'A';

		System.out.println(secretMessage);
	}

}
