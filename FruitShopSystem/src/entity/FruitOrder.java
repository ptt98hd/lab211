/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ow3n
 */
public class FruitOrder extends FruitProduct {

	private String customer;
	private int quantity;

	public FruitOrder(FruitOrder fruitOrder, int quantity, String customer) {
		super(fruitOrder.getId(), fruitOrder.getName(), fruitOrder.getOrigin(), fruitOrder.getPrice());
		this.quantity = quantity;
		this.customer = customer;
	}

	public FruitOrder() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return getPrice() * quantity;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
}
