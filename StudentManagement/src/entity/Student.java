/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ow3n
 */
public class Student {

	private int id;
	private String name;

	public Student() {
	}

	public Student(int id, String name, ArrayList<Course> courses) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		String format = "%-5s | %-20s | ";
		return String.format(format, id, name);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + this.id;
		hash = 79 * hash + Objects.hashCode(this.name);
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
		final Student other = (Student) obj;
		if (this.id != other.id) {
			return false;
		}
		return Objects.equals(this.name, other.name);
	}

}
