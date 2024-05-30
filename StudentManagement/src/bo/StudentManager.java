/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Student;
import java.util.ArrayList;

/**
 *
 * @author ow3n
 */
public class StudentManager {

	private ArrayList<Student> students;
	private int currentId;

//	CONSTRUCTOR
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public StudentManager() {
		students = new ArrayList<>();
		currentId = 0;
	}

//	GETTER + SETTER
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
		setCurrentId(students);
	}

	private void setCurrentId(ArrayList<Student> students) {
		int maxId = students.get(0).getId();
		for (Student student : students) {
			if (student.getId() > maxId) {
				maxId = student.getId();
			}
		}
		this.currentId = maxId;
	}

//	ADD + UPDATE + REMOVE
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public boolean add(Student newStudent) {
		newStudent.setId(++currentId);
		return students.add(newStudent);
	}

	public boolean remove(Student student) {
		return students.remove(student);
	}

	public void update(int index, String newName) {
		students.get(index).setName(newName);
	}

//	SEARCH
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public ArrayList<Student> searchByName(String name) {
		ArrayList<Student> results = new ArrayList<>();
		for (Student student : students) {
			if (student.getName().toLowerCase().contains(name.toLowerCase())) {
				results.add(student);
			}
		}
		return sortByName(results);
	}

	private ArrayList<Student> sortByName(ArrayList<Student> students) {
		students.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		return students;
	}

//	OTHERS
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public int getIndex(int id) {
		for (int index = 0; index < students.size(); index++) {
			if (students.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}

	public Student getStudent(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}
}
