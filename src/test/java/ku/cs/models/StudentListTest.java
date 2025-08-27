package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList sl;

    @BeforeEach
    void beforeEach() {
        sl = new StudentList();
        sl.addNewStudent("6710405125", "Pisit", 80);
        sl.addNewStudent("6710405888", "Bew", 60);
        sl.addNewStudent("6710405999", "Auto", 50);
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนโดยไม่มีคะแนน")
    void testAddNewStudentWithoutScore() {
        sl.addNewStudent("6710405100", "Meow");
        Student s = sl.findStudentById("6710405100");
        assertEquals("Meow", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนซ้ำ")
    void testAddDuplicateStudentIdShouldNotAdd() {
        sl.addNewStudent("6710405125", "Pisit", 90);
        ArrayList<Student> students = sl.getStudents();
        long count = students.stream().filter(s -> s.getId().equals("6710405125")).count();
        assertEquals(1, count);
    }

    @Test
    @DisplayName("ทดสอบการหานักเรียนโดย ID")
    void testFindStudentById() {
        Student s = sl.findStudentById("6710405888");
        assertEquals("Bew", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการหานักเรียนไม่เจอโดย ID")
    void testFindStudentByIdNotFound() {
        Student s = sl.findStudentById("6610405125");
        assertNull(s);
    }

    @Test
    @DisplayName("ทดสอบการกรองนักเรียนด่วยตัวอักษร")
    void testFilterByName() {
        StudentList filtered = sl.filterByName("o");
        assertEquals(1, filtered.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนนให้นักเรียน")
    void testGiveScoreToId() {
        sl.giveScoreToId("6710405999", 20);
        Student s = sl.findStudentById("6710405999");
        assertEquals(70, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดนักเรียน")
    void testViewGradeOfId() {
        String grade = sl.viewGradeOfId("6710405125");
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดกรณีไม่เจอนักเรียน")
    void testViewGradeOfIdNotFound() {
        String grade = sl.viewGradeOfId("6610405888");
        assertNull(grade);
    }
}