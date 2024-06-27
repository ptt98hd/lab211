/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Course;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ow3n
 */
public class CourseManager {

	private ArrayList<Course> courses;

	// CONSTRUCTOR
	// == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public CourseManager() {
		courses = new ArrayList<>();
	}

	// GETTER
	// == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public ArrayList<Course> getAllCourses() {
		return courses;
	}

	public ArrayList<Course> getCourses(int studentId) {
		ArrayList<Course> results = new ArrayList<>();
		for (Course course : courses) {
			if (course.getStudent().getId() == studentId) {
				results.add(course);
			}
		}
		return results;
	}

	// C.R.U.D
	// == == == == == == == == == == == == == == == == == == == == == == == == == ==
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

	public Course update(Course oldCourse, Course newCourse) throws Exception {
		int index = courses.indexOf(oldCourse);
		if (index == -1) {
			throw new Exception("Invalid old course!!!");
		}
		return courses.set(index, newCourse);
	}

	// SEARCH & SORT
	// == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public ArrayList<Course> searchByStudentName(String name) {
		ArrayList<Course> results = new ArrayList<>();
		for (Course course : courses) {
			if (course.getStudent().getName().toLowerCase().contains(name.toLowerCase())) {
				results.add(course);
			}
		}
		return sortByName(results);
	}

	private ArrayList<Course> sortByName(ArrayList<Course> courses) {
		courses.sort((o1, o2) -> o1.getStudent().getName().compareToIgnoreCase(o2.getStudent().getName()));
		return courses;
	}

	// REPORT
	// == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public HashMap<String, Integer> getReports() {
		String keyFormat = "%-20s | %-5s | ";
		HashMap<String, Integer> reports = new HashMap<>();
		for (Course course : courses) {
			String key = String.format(keyFormat,
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
}
