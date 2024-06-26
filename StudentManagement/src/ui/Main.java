/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.StudentCourseController;
import java.util.ArrayList;
import java.util.HashMap;
import utils.Validation;

/**
 *
 * @author ow3n
 */
public class Main {

	private static final String MENU = "\nWELCOME TO STUDENT MANAGEMENT\n"
		+ "[1] Create\n"
		+ "[2] Find and Sort\n"
		+ "[3] Update or Delete\n"
		+ "[4] Report\n"
		+ "[5] Add Course\n"
		+ "[6] Get all Students\n"
		+ "[7] Get all Courses\n"
		+ "[0] Exit\n"
		+ "Your choice: ";

	public static void main(String[] args) {
		StudentCourseController studentCourseController = new StudentCourseController();
		while (true) {
			try {
				int choice = Validation.getInteger(MENU, 0, 7);
				switch (choice) {
					case 0:
						return;
					case 1:
						System.out.println(getData(studentCourseController.createStudents()));
						break;
					case 2:
						System.out.println(getData(studentCourseController.findByName()));
						break;
					case 3:
						System.out.println(studentCourseController.updateOrDelete());
						break;
					case 4:
						System.out.println(getData(studentCourseController.getReports()));
						break;
					case 5:
						System.out.println(getData(studentCourseController.addCourse()));
						break;
					case 6:
						System.out.println(getData(studentCourseController.getAllStudents()));
						break;
					case 7:
						System.out.println(getData(studentCourseController.getAllCourses()));
						break;
					default:
						System.err.println("Function is not created!!!");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static <Type> String getData(ArrayList<Type> list) {
		String data = "";
		for (Type item : list) {
			data += item.toString() + "\n";
		}
		return data;
	}

	public static <Type> String getData(Type item) {
		String data = item.toString();
		return data;
	}

	public static <Key, Value> String getData(HashMap<Key, Value> map) {
		String data = "";
		for (Key key : map.keySet()) {
			data += key + map.get(key).toString() + "\n";
		}
		return data;
	}
}
