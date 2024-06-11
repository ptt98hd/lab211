/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Customer;
import java.util.Hashtable;

/**
 *
 * @author ow3n
 */
public class CustomerFruitOrderManager {

	private Hashtable<Customer, FruitOrderManager> customerFruitOrders;
	private int currentId;

	public CustomerFruitOrderManager() {
		customerFruitOrders = new Hashtable<>();
		currentId = 0;
	}

}
