/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author ow3n
 */
public class FruitProduct {

	private int id;
	private String name;
	private String origin;
	private double price;

	public FruitProduct() {
	}

	public FruitProduct(int id, String name, String origin, double price) {
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + this.id;
		hash = 23 * hash + Objects.hashCode(this.name);
		hash = 23 * hash + Objects.hashCode(this.origin);
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final FruitProduct other = (FruitProduct) obj;
		if (this.id != other.id) {
			return false;
		}
		if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		return Objects.equals(this.origin, other.origin);
	}
}
