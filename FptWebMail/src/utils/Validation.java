/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ow3n
 */
public class Validation {

	private static final Scanner scanner = new Scanner(System.in);

	private static String getString(String message, String error, String regex) {
		do {
			System.out.println(message);
			String input = scanner.nextLine();
			if (!input.matches(regex)) {
				System.err.println(error);
			} else {
				return input;
			}
		} while (true);
	}

	public static int getInteger(String message, int min, int max) {
		String regex = "[+-]?[0-9]+";
		String errorOutOfRange = "Input number must in range [" + min + "-" + max + "]!!!";
		String errorNumberFormat = "Please input an integer number!!!";
		do {
			int input = Integer.parseInt(getString(message, errorNumberFormat, regex));
			if (input < min || input > max) {
				System.err.println(errorOutOfRange);
			} else {
				return input;
			}
		} while (true);
	}

	public static String getAlphabetic(String message) {
		String regex = "[A-Za-z ]+";
		String error = "Only accept alphabetic character!!!";
		return getString(message, error, regex);
	}

	public static boolean getChoice(String message, String choice1, String choice2) {
		String choices = choice1 + choice2;
		String regex = "[" + choices.toUpperCase() + choices.toLowerCase() + "]";
		String error = "Only accept [" + choice1.toUpperCase() + "/" + choice2.toUpperCase() + "]!!!";
		String input = getString(message, error, regex);
		return input.equalsIgnoreCase(choice1);
	}

	public static String getUserName(String message) {
		String regex = "^[a-zA-Z][a-zA-Z0-9._]{4,19}$";
		String error = "User name must contains:\n"
			+ "4-19 characters\n"
			+ "Start with an alphabetic\n"
			+ "Only accept alphabetic character, number, dot, underscore";
		return getString(message, error, regex);
	}

	public static String getEncryptedPassword(String message) {
		String regex = "[a-zA-Z0-9@#$%^&*]+";
		String errorFormat = "Only accept: \n"
			+ "1. Uppercase + Lowercase characters (a-Z)\n"
			+ "2. Digits (0-9)\n"
			+ "3. Special characters (!@#$%^&*)";
		String errorLength = "Password cannot empty";
		do {
			String input = getString(message, errorFormat, regex);
			if (input.length() != 0) {
				return Encryption.md5(input);
			} else {
				System.err.println("Password cannot empty!!!");
			}
		} while (true);
	}

	public static String getPhone(String message) {
		String regex = "[0-9]+";
		String errorLength = "Phone number must contains 10-11 digit!!!";
		String errorFormat = "Only accept digits (0-9)!!!";
		do {
			String input = getString(message, errorFormat, regex);
			if (input.length() < 10 || input.length() > 11) {
				System.err.println(errorLength);
			} else {
				return input;
			}
		} while (true);
	}

	public static String getEmail(String message) {
		String regex = "^[a-zA-Z0-9._]+[@][a-zA-Z0-9.]+$";
		String error = "Wrong email format (example@email.com)!!!";
		return getString(message, error, regex);
	}

	public static String getAddress(String message) {
		String regex = "[a-zA-Z0-9,/ ]+";
		String error = "Only containts alphabetic, number and comma!!!";
		return getString(message, error, regex);
	}

	public static Date getDate(String message, String regex) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(regex);
		simpleDateFormat.setLenient(false);
		String error = "Wrong date format or value (" + regex + ")!!!";
		while (true) {
			System.out.println(message);
			try {
				return simpleDateFormat.parse(scanner.nextLine());
			} catch (ParseException ex) {
				System.err.println(error);
			}
		}
	}
}
