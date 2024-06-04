/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

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
		String regex = "[0-9]+";
		String errorOutOfRange = "Only accept number in range [" + min + "-" + max + "]!!!";
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
}
