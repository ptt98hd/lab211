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

	private StudentManager studentManager;
	private CourseManager courseManager;
	private StudentInputer studentInputer;
	private CourseInputer courseInputer;

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
		if (Validation.getChoice("Update student's name? [Y/N]: ", "y", "n")) {
			student.setName(Validation.getAlphabetic("Enter new name: "));
		}

		if (Validation.getChoice("Update student's courses? [Y/N]", "y", "n")) {
			while (true) {
				int choice = Validation.getInteger("[1] Add course ; "
					+ "[2] Update Course ; "
					+ "[3] Remove Course\n"
					+ "Your choice: ", 1, 3);
				switch (choice) {
					case 1:
						addCourse(student);
						break;
					case 2:

						break;
					case 3:

						break;
					default:
						throw new AssertionError();
				}
			}
		}
	}

	private void addCourse(Student student) {
		Course course;// = new Course();
		do {
			course = courseInputer.inputCourse();
		} while (courseManager.contains(course));
		course.setStudent(student);
	}

	private void removeCourse(Student student) {
//		Course course = in
	}
}
