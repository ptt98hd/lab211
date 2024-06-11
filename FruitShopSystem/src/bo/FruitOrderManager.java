/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.FruitOrder;
import java.util.ArrayList;

/**
 *
 * @author ow3n
 */
public class FruitOrderManager {

	private ArrayList<FruitOrder> fruitOders;

	public FruitOrderManager() {
		fruitOders = new ArrayList<>();
	}

	public ArrayList<FruitOrder> getFruitOders() {
		return fruitOders;
	}

	public void add(FruitOrder newFruitOrder) {
		if (this.contains(newFruitOrder)) {
			int index = getIndex(newFruitOrder);
			FruitOrder fruitOrder = fruitOders.get(index);
			int newQuantity = fruitOrder.getQuantity() + newFruitOrder.getQuantity();
			fruitOrder.setQuantity(newQuantity);
		} else {
			fruitOders.add(newFruitOrder);
		}
	}

	public int getIndex(FruitOrder fruitOrder) {
		for (int i = 0; i < fruitOders.size(); i++) {
			if (fruitOders.get(i).equals(fruitOrder)) {
				return i;
			}
		}
		return -1;
	}

	public boolean contains(FruitOrder fruitOrder) {
		return fruitOders.contains(fruitOrder);
	}
}
