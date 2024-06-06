/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.FruitProduct;
import java.util.ArrayList;

/**
 *
 * @author ow3n
 */
public class FruitProductManager {

	private ArrayList<FruitProduct> fruitProducts;
	private int currentId;

	public FruitProductManager() {
		fruitProducts = new ArrayList<>();
		currentId = 0;
	}

	public ArrayList<FruitProduct> getFruitProducts() {
		return fruitProducts;
	}

	public boolean add(FruitProduct newFruitProduct) {
		newFruitProduct.setId(++currentId);
		return fruitProducts.add(newFruitProduct);
	}

	public boolean remove(FruitProduct fruitProduct) {
		return fruitProducts.remove(fruitProduct);
	}

	public FruitProduct update(int index, FruitProduct newFruitProduct) {
		return fruitProducts.set(index, newFruitProduct);
	}

	public int getIndex(FruitProduct fruit) {
		for (int i = 0; i < fruitProducts.size(); i++) {
			if (fruitProducts.get(i).equals(fruit)) {
				return i;
			}
		}
		return -1;
	}

	public boolean contains(FruitProduct fruit) {
		return fruitProducts.contains(fruit);
	}

}
