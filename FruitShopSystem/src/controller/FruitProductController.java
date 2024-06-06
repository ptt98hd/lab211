/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.FruitProductInputer;
import bo.FruitProductManager;
import entity.FruitProduct;
import java.util.ArrayList;
import utils.Validation;

/**
 *
 * @author ow3n
 */
public class FruitProductController {

	private FruitProductInputer fruitProductInputer;
	private FruitProductManager fruitProductManager;

	public FruitProductController() {
		fruitProductInputer = new FruitProductInputer();
		fruitProductManager = new FruitProductManager();
	}

	public ArrayList<FruitProduct> getAllFruitProducts() {
		return fruitProductManager.getFruitProducts();
	}

	public ArrayList<FruitProduct> createFruitProducts() {
		ArrayList<FruitProduct> createdFruitProducts = new ArrayList<>();
		do {
			FruitProduct newFruitProduct = fruitProductInputer.inputFruitProduct();
			fruitProductManager.add(newFruitProduct);
			createdFruitProducts.add(newFruitProduct);
		} while (Validation.getChoice("Do you want to continue? (Y/N): ", "y", "n"));
		return createdFruitProducts;
	}

}
