/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.AccountController;
import entity.Account;
import utils.Validation;

/**
 *
 * @author Ow3n
 */
public class Main {

	private static final String MENU = "\n========== Login Program ==========\n"
		+ "1. Add User\n"
		+ "2. Login\n"
		+ "3. Exit\n"
		+ "Please choice one option: ";

	public static void main(String[] args) {
		AccountController accountController = new AccountController();
		while (true) {
			try {
				int choice = Validation.getInteger(MENU, 1, 4);
				switch (choice) {
					case 1:
						String userName = accountController.addAccount();
						System.out.println(userName + "Create account scuccessfull!");
						break;
					case 2:
						System.out.println("\n========== Login ==========");
						Account account = accountController.login();
						System.out.println("\n========== Welcome ==========");
						if (Validation.getChoice("Hi " + account.getName() + ", do you want to change password now? Y/N:",
							"y", "n")) {
							if (accountController.changePassword(account.getUserName())) {
								System.out.println("Password has been changed!");
							}
						}
						break;
					case 3:
						return;
					default:
						break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
