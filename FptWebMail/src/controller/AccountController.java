/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.AccountInputer;
import bo.AccountManager;
import entity.Account;
import java.util.HashMap;
import utils.Validation;

/**
 *
 * @author Ow3n
 */
public class AccountController {

	private AccountManager accountManager;
	private AccountInputer accountInputer;

	public AccountController() {
		accountManager = new AccountManager();
		accountInputer = new AccountInputer();
	}

	public String addAccount() throws Exception {
		Account newAccount = accountInputer.inputAccount();
		return accountManager.add(newAccount).getUserName();
	}

	public Account login() throws Exception {
		String userName = Validation.getUserName("User name: ");
		String password = Validation.getEncryptedPassword("Password: ");
		return accountManager.login(userName, password);
	}

	public boolean changePassword(String userName) throws Exception {
		String oldPassword = Validation.getEncryptedPassword("Old password: ");
		String newPassword = Validation.getEncryptedPassword("New password: ");
		String renewPassword = Validation.getEncryptedPassword("Renew password: ");
		return accountManager.changePassword(userName, oldPassword, newPassword, renewPassword);
	}

	public HashMap<String, Account> getAllAccounts() {
		return accountManager.getAllAccounts();
	}

}
