/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.FruitProductController;
import entity.FruitProduct;
import java.util.ArrayList;
import utils.Validation;

/**
 *
 * @author ow3n
 */
public class Main {

	private static final String menu = "\nFRUIT SHOP SYSTEM\n"
			+ "1. Create Fruit\n"
			+ "2. View orders\n"
			+ "3. Shopping (for buyer)\n"
			+ "4. Exit\n"
			+ "(Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program)."
			+ "Your choice: ";

	public static void main(String[] args) {
		FruitProductController fruitProductController = new FruitProductController();
		while (true) {
			try {
				int choice = Validation.getInteger(menu, 0, 4);
				switch (choice) {
					case 0:
						System.out.println(getData(fruitProductController.getAllFruitProducts()));
						break;
					case 1:
						System.out.println(getData(fruitProductController.createFruitProducts()));
						break;
					case 2:

						break;
					case 3:

						break;
					case 4:
						return;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	private static String getData(ArrayList<FruitProduct> fruitProducts) {
		String format = "| %-4s | %-16s | %-12s | %-11s |";
		String data = String.format(format, "Item", "Fruit Name", "Origin", "Price") + "\n";
		for (int i = 0; i < fruitProducts.size(); i++) {
			FruitProduct fruitProduct = fruitProducts.get(i);
			data += String.format(format,
					(i + 1), fruitProduct.getName(), fruitProduct.getOrigin(), fruitProduct.getPrice());
		}
		return data;
	}
}
