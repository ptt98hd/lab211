/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Student;
import utils.Validation;

/**
 *
 * @author ow3n
 */
public class StudentInputer {

	public Student inputStudent() {
		Student student = new Student();
		student.setName(Validation.getAlphabetic("Enter student name: "));
		return student;
	}
}
