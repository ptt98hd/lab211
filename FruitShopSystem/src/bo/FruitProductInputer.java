/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.FruitProduct;
import utils.Validation;

/**
 *
 * @author ow3n
 */
public class FruitProductInputer {

	public FruitProduct inputFruitProduct() {
		FruitProduct fruitProduct = new FruitProduct();
		fruitProduct.setName(Validation.getAlphabetic("Enter name: "));
		fruitProduct.setOrigin(Validation.getAlphabetic("Enter orgin: "));
		fruitProduct.setPrice(Validation.getDouble("Enter price", 0, Double.MAX_VALUE));
		return fruitProduct;
	}
}
