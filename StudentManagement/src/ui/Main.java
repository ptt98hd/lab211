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
		+ "[5] Exit\n"
		+ "Your choice: ";

	public static void main(String[] args) {
		StudentCourseController studentCourseController = new StudentCourseController();
		while (true) {
			try {
				int choice = Validation.getInteger(MENU, 0, 5);
				switch (choice) {
					case 0:
						System.out.println(getData(studentCourseController.getAllCourses()));
						break;
					case 1:
						System.out.println(getData(studentCourseController.createStudents()));
						break;
					case 2:
						System.out.println(getData(studentCourseController.findByName()));
						break;
					case 3:
						studentCourseController.updateOrDelete();
						break;
					case 4:
						System.out.println(getData(studentCourseController.getReports()));
						break;
					case 5:
						return;
					default:
						throw new Exception("Invalid choice!!!");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static String getData(ArrayList<Course> courses) {
		String data = "";
		for (Course course : courses) {
			data += course.toString() + "\n";
		}
		return data;
	}

	public static String getData(HashMap<String, Integer> reports) {
		String data = "";
		for (String key : reports.keySet()) {
			data += key + reports.get(key) + "\n";
		}
		return data;
	}
}
