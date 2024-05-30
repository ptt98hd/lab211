/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entity;

/**
 *
 * @author ow3n
 */
public enum CourseName {
	JAVA("Java"), DOT_NET(".NET"), C_CPP("C/C++");

	private final String courseName;

	private CourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return courseName;
	}

	public static CourseName getCourseName(int courseNumber) {
		switch (courseNumber) {
			case 1:
				return JAVA;
			case 2:
				return DOT_NET;
			case 3:
				return C_CPP;
			default:
				throw new AssertionError();
		}
	}
}
