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

	private int quantity;

	public FruitOrder() {
		super();
	}

	public FruitOrder(int id, String name, double price, String origin, int quantity) {
		super(id, name, price, origin);
		this.quantity = quantity;
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
}
