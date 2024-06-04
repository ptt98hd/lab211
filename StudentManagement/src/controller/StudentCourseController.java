/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.CourseInputer;
import bo.CourseManager;
import bo.StudentInputer;
import bo.StudentManager;
import entity.Course;
import entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import utils.Validation;

/**
 *
 * @author ow3n
 */
public class StudentCourseController {

	private final StudentManager studentManager;
	private final CourseManager courseManager;
	private final StudentInputer studentInputer;
	private final CourseInputer courseInputer;

	public StudentCourseController() {
		studentManager = new StudentManager();
		studentInputer = new StudentInputer();
		courseManager = new CourseManager();
		courseInputer = new CourseInputer();
	}

	public ArrayList<Student> getAllStudents() {
		return studentManager.getStudents();
	}

	public ArrayList<Course> getAllCourses() {
		return courseManager.getCourses();
	}

	public ArrayList<Course> createStudents() throws Exception {
		ArrayList<Course> created = new ArrayList<>();
		do {
			Student newStudent = studentInputer.inputStudent();
			Course newCourse = courseInputer.inputCourse();
			newCourse.setStudent(newStudent);
			studentManager.add(newStudent);
			courseManager.add(newCourse);
			created.add(newCourse);
		} while (Validation.getChoice("Create another student? [Y/N]: ", "y", "n"));
		return created;
	}

	public ArrayList<Course> findByName() throws Exception {
		String name = Validation.getAlphabetic("Enter student name: ");
		return courseManager.searchByStudentName(name);
	}

	public HashMap<String, Integer> getReports() {
		String keyFormat = "%-5s | %-20s | %-5s | ";
		HashMap<String, Integer> reports = new HashMap<>();
		for (Course course : courseManager.getCourses()) {
			String key = String.format(keyFormat,
				course.getStudent().getId(),
				course.getStudent().getName(),
				course.getCourseName().toString());
			if (reports.containsKey(key)) {
				int amount = reports.get(key);
				reports.replace(key, ++amount);
			} else {
				reports.put(key, 1);
			}
		}
		return reports;
	}

	public void updateOrDelete() throws Exception {
		int id = Validation.getInteger("Enter student's id: ", 1, Integer.MAX_VALUE);
		Student student = studentManager.getStudent(id);
		if (student == null) {
			throw new Exception("Invalid ID!!!");
		}
		if (Validation.getChoice("Update or Delete? [U/D]: ", "u", "d")) {
			updateStudent(student);
		} else {
			deleteStudent(student);
		}
	}

	private void deleteStudent(Student student) {
		courseManager.remove(student);
		studentManager.remove(student);
	}

	private void updateStudent(Student student) throws Exception {
		while (true) {
			int choice = Validation.getInteger("1. Change name"
				+ "[2] Add course ; "
				+ "[3] Update Course ; "
				+ "[4] Remove Course\n"
				+ "Your choice: ", 1, 4);
			switch (choice) {
				case 1:
					updateName(student);
					break;
				case 2:
					addCourse(student);
					break;
				case 3:
					removeCourse(student);
					break;
				case 4:
					updateCourse(student);
					break;
			}
		}
	}

	private void updateName(Student student) {
		student.setName(Validation.getAlphabetic("Enter new name: "));
	}

	private void addCourse(Student student) throws Exception {
		Course course = courseInputer.inputCourse();
		if (courseManager.contains(course)) {
			throw new Exception("Course already exists!!!");
		}
		course.setStudent(student);
	}

	private void removeCourse(Student student) {
//		Course course = in
	}

	private void updateCourse(Student student) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
