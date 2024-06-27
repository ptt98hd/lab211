/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Account;
import utils.Validation;

/**
 *
 * @author Ow3n
 */
public class AccountInputer {

	public Account inputAccount() {
		Account input = new Account();
		input.setUserName(Validation.getUserName("Account: "));
		input.setPassword(Validation.getEncryptedPassword("Password: "));
		input.setName(Validation.getAlphabetic("Name: "));
		input.setPhone(Validation.getPhone("Phone: "));
		input.setEmail(Validation.getEmail("Email: "));
		input.setAddress(Validation.getAddress("Address: "));
		input.setDateOfBirth(Validation.getDate("DOB: ", "dd/MM/yyyy"));
		return input;
	}
}
