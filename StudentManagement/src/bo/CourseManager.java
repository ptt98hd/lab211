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

	public CourseManager(ArrayList<Course> courses) {
		this.courses = courses;
	}

//	GETTER + SETTER
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

//	ADD + UPDATE + REMOVE
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public boolean add(Course newCourse) throws Exception {
		if (courses.contains(newCourse)) {
			throw new Exception("Course already exists!!!");
		}
		return courses.add(newCourse);
	}

	public ArrayList<Course> remove(Student student) {
		ArrayList<Course> removed = new ArrayList<>();
		for (Course course : courses) {
			if (course.getStudent().equals(student)) {
				removed.add(course);
				courses.remove(course);
			}
		}
		return removed;
	}

	public Course update(int index, Course newCourse) {
		return courses.set(index, newCourse);
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
		return results;
	}

	private ArrayList<Course> sortByStudentName(ArrayList<Course> courses) {
		courses.sort((o1, o2) -> o1.getStudent().getName().compareToIgnoreCase(o2.getStudent().getName()));
		return courses;
	}

//	OTHERS
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public int getIndex(Course course) {
		for (int index = 0; index < courses.size(); index++) {
			if (courses.get(index).equals(course)) {
				return index;
			}
		}
		return -1;
	}

	public boolean contains(Course course) {
		return courses.contains(course);
	}
}
