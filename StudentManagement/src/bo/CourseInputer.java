/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Course;
import entity.CourseName;
import utils.Validation;

/**
 *
 * @author ow3n
 */
public class CourseInputer {

	public Course inputCourse() {
		Course course = new Course();
		course.setSemester(Validation.getInteger("Enter semester", 1, 9));
		course.setCourseName(CourseName.getCourseName(Validation.getInteger(
			"Enter course name: "
			+ "[1] Java ; [2] .NET ; [3] C/C++",
			1, 3
		)));
		return course;
	}
}
