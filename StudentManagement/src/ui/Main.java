/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.StudentCourseController;
import entity.Course;
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
			+ "[3] Update/Delete\n"
			+ "[4] Report\n"
			+ "[5] Delete student\n"
			+ "[6] Update student\n"
			+ "[8] Get all Students\n"
			+ "[9] Get all Courses\n"
			+ "[0] Exit\n"
			+ "Your choice: ";

	public static void main(String[] args) {
		StudentCourseController studentCourseController = new StudentCourseController();
		while (true) {
			try {
				int choice = Validation.getInteger(MENU, 0, 9);
				switch (choice) {
					case 0:
						return;
					case 1:
						System.out.println(getData(studentCourseController.createStudents()));
						break;
					case 2:
						System.out.println(getData(studentCourseController.findByName()));
						break;
//					case 3:
//						studentCourseController.updateOrDelete();
//						break;
					case 4:
						System.out.println(getData(studentCourseController.getReports()));
						break;
					case 5:
						System.out.println(getData(studentCourseController.deleteStudent()));
						break;
					case 6:

						break;
					case 7:

						break;
					case 8:
						System.out.println(getData(studentCourseController.getAllStudents()));
						break;
					case 9:
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
