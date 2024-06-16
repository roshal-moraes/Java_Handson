package main.com.self.testing;

import java.util.ArrayList;
import java.util.List;


public class Student {
    private List<String> enrolledCourses = new ArrayList<>();
    private static final int MAX_COURSES = 3;

    // Other existing code...
    
    public void enroll(String course) {
        if (enrolledCourses.size() < MAX_COURSES) {
            enrolledCourses.add(course);
            System.out.println("Enrolled in course: " + course);
        } else {
            System.out.println("Enrollment limit exceeded. Cannot enroll in more courses.");
        }
    }

	public List<String> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(List<String> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public static int getMaxCourses() {
		return MAX_COURSES;
	}

    // Other existing code...
}
