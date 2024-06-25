/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Course;
import entity.Student;
import java.util.ArrayList;

/**
 *
 * @author ow3n
 */
public class CourseManager {

	private ArrayList<Course> courses;

//	CONSTRUCTOR
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public CourseManager() {
		courses = new ArrayList<>();
	}

//	GETTER
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public ArrayList<Course> getAllCourses() {
		return courses;
	}

	public ArrayList<Course> getCourses(Student student) {
		ArrayList<Course> results = new ArrayList<>();
		for (Course course : courses) {
			if (course.getStudent().equals(student)) {
				results.add(course);
			}
		}
		return results;
	}

//	CRUD
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public boolean add(Course newCourse) throws Exception {
		if (courses.contains(newCourse)) {
			throw new Exception("Course already exists!!!");
		}
		return courses.add(newCourse);
	}

	public boolean remove(Course course) throws Exception {
		if (!courses.contains(course)) {
			throw new Exception("Course does not exits!!!");
		}
		return courses.remove(course);
	}

//	SEARCH & SORT
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public ArrayList<Course> searchByStudentName(String name) {
		ArrayList<Course> results = new ArrayList<>();
		for (Course course : courses) {
			if (course.getStudent().getName().toLowerCase().contains(name.toLowerCase())) {
				results.add(course);
			}
		}
		return sortByName(courses);
	}

	private ArrayList<Course> sortByName(ArrayList<Course> courses) {
		courses.sort((o1, o2) -> o1.getStudent().getName().compareToIgnoreCase(o2.getStudent().getName()));
		return courses;
	}
}
