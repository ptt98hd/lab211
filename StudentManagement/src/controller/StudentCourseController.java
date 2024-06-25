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
		return studentManager.getAllStudents();
	}

	public ArrayList<Course> getAllCourses() {
		return courseManager.getAllCourses();
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
		return courseManager.getReports();
	}

	public Course addCourse() throws Exception {
		int studentId = Validation.getInteger("Student ID: ", 1, Integer.MAX_VALUE);
		Student student = studentManager.getStudent(studentId);
		Course newCourse = courseInputer.inputCourse();
		newCourse.setStudent(student);
		courseManager.add(newCourse);
		return newCourse;
	}

	public Course updateOrDelete() throws Exception {
		int studentId = Validation.getInteger("Enter ID: ", 1, Integer.MAX_VALUE);
		boolean updateOrDelete = Validation.getChoice("Update or Delete? [u/d]?", "u", "d");
		Course course = chooseCourse(courseManager.getCourses(studentId));
		if (updateOrDelete) {
			return update(studentId, course);
		} else {
			return delete(course);
		}
	}

	private Course update(int studentId, Course oldCourse) throws Exception {
		String newName = Validation.getAlphabetic("New name: ");
		Course newCourse = courseInputer.inputCourse();
		studentManager.update(studentId, newName);
		return courseManager.update(oldCourse, newCourse);
	}

	private Course delete(Course course) throws Exception {
		courseManager.remove(course);
		return course;
	}

	private Course chooseCourse(ArrayList<Course> courses) {
		String data = "";
		for (int i = 0; i < courses.size(); i++) {
			data += i + " | " + courses.get(i).toString() + "\n";
		}
		data += "Your choice: ";
		int index = Validation.getInteger(data, 0, courses.size() - 1);
		return courses.get(index);
	}
}
