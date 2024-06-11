/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Student;
import java.util.ArrayList;
import java.util.ListIterator;

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

	public Student remove(int id) throws Exception {
		ListIterator<Student> studentIterator = students.listIterator();
		while (studentIterator.hasNext()) {
			Student student = studentIterator.next();
			if (student.getId() == id) {
				studentIterator.remove();
				return student;
			}
		}
		throw new Exception("Invalid ID!!!");
	}

	public Student update(int id, String newName) throws Exception {
		int index = getIndex(id);
		if (index == -1) {
			throw new Exception("Invalid ID!!!");
		}
		Student student = students.get(index);
		students.get(index).setName(newName);
		return student;
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

//	SORT
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	private ArrayList<Student> sortByName(ArrayList<Student> students) {
		students.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		return students;
	}

	private ArrayList<Student> sortById(ArrayList<Student> students) {
		students.sort((o1, o2) -> o1.getId() - o2.getId());
		return students;
	}

//	OTHERS
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public int getIndex(int id) {
		for (int index = 0; index < students.size(); index++) {
			Student student = students.get(index);
			if (student.getId() == id) {
				return index;
			}
		}
		return -1;
	}
}
