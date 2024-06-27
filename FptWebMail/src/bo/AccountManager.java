/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Account;
import java.util.HashMap;

/**
 *
 * @author Ow3n
 */
public class AccountManager {

	HashMap<String, Account> accounts;

	public AccountManager() {
		accounts = new HashMap<>();
	}

	public HashMap<String, Account> getAllAccounts() {
		return accounts;
	}

	public Account add(Account newAccount) throws Exception {
		if (accounts.containsKey(newAccount.getUserName())) {
			throw new Exception("User name already exist!!!");
		}
		return accounts.put(newAccount.getUserName(), newAccount);
	}

	public Account login(String userName, String encryptedPassword) throws Exception {
		Account account = accounts.get(userName);
		if (account == null) {
			throw new Exception("Invalid user name!!!");
		}
		if (!account.getPassword().equals(encryptedPassword)) {
			throw new Exception("Wrong password!!!");
		}
		return account;
	}

	public boolean changePassword(String userName, String oldEncryptedPassword, String newEncryptedPassword, String renewEncryptedPassword) throws Exception {
		Account account = login(userName, oldEncryptedPassword);
		if (!renewEncryptedPassword.equals(newEncryptedPassword)) {
			throw new Exception("Renew password does not match with new password!!!");
		}
		account.setPassword(newEncryptedPassword);
		return true;
	}
}
