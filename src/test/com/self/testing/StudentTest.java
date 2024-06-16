package test.com.self.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.com.self.testing.Student;


public class StudentTest {
	@Test
	public void testEnroll() {
	    // Arrange
	    Student student = new Student();

	    // Act
	    student.enroll("Math");
	    student.enroll("History");
	    student.enroll("English");

	    // Assert
	    assertEquals(3, student.getEnrolledCourses().size());
	}

}
