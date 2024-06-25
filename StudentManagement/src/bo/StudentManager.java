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

//	GETTER
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public ArrayList<Student> getAllStudents() {
		return students;
	}

	private Student getStudent(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

//	CRUD
//	== == == == == == == == == == == == == == == == == == == == == == == == == ==
	public boolean add(Student newStudent) throws Exception {
		if (students.contains(newStudent)) {
			throw new Exception("Student's name already exists!!!");
		}
		newStudent.setId(++currentId);
		return students.add(newStudent);
	}

	public Student remove(int id) throws Exception {
		Student student = getStudent(id);
		if (student == null) {
			throw new Exception("Invalid ID!!!");
		}
		if (students.remove(student)) {
			return student;
		}
		throw new Exception("Unknow error: Can not remove student!!!");
	}

	public Student update(int id, String newName) throws Exception {
		Student student = getStudent(id);
		if (student == null) {
			throw new Exception("Invalid ID!!!");
		}
		student.setName(newName);
		return student;
	}
}
