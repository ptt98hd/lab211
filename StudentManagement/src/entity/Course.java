/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author ow3n
 */
public class Course {

	private Student student;
	private int semester;
	private CourseName courseName;

	public Course() {
	}

	public Course(Student student, int semester, CourseName courseName) {
		this.student = student;
		this.semester = semester;
		this.courseName = courseName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public CourseName getCourseName() {
		return courseName;
	}

	public void setCourseName(CourseName courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		String format = "%-5s | %-5s";
		return student.toString() + String.format(format, semester, courseName);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.student);
		hash = 97 * hash + this.semester;
		hash = 97 * hash + Objects.hashCode(this.courseName);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Course other = (Course) obj;
		if (this.semester != other.semester) {
			return false;
		}
		if (!Objects.equals(this.student, other.student)) {
			return false;
		}
		return this.courseName == other.courseName;
	}
}
