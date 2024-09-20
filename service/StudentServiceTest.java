package java_assessment.service;

import java_assessment.model.Course;
import java_assessment.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @Test
    void testFindStudent() {
        Student student = studentService.findStudent("stu01");
        //Check whether the student exists through the assertion
        assertNotNull(student, "Student should be found");
        assertEquals("Adrian",student.getFirstName(), "First name of student should be Adrian");
        assertEquals("Tan",student.getLastName(), "Last name should be Tan");
        assertEquals("Adriantan@gmail.com", student.getEmail(),"email should be ");
    }

    @Test
    void testNotFound(){
        Student student = studentService.findStudent("stu09");
        assertNull(student, "Student not be found");
    }



    @Test
    void testIsSubscribed() {
        assertTrue(studentService.isSubscribed("stu01"));
        assertFalse(studentService.isSubscribed("stu00"));
    }

    @Test
    void testIsAttendingCourse(){
        Course courseJava = new Course("introduction to Java", "INTRO-CS-J", 100);
        Student student = new Student("Tony", "Stark", "Tony@gmail.com", new Date(101, 0,17),"stu0X");

        student.enrollToCourse(courseJava);
        assertTrue(student.isAttendingCourse("INTRO-CS-J"),"Student should be attending INTRO-CS-J");
        assertFalse(student.isAttendingCourse("INTO-CS-T"),"Student not taking this course");
    }


}