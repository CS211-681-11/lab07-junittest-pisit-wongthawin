package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    static Student s;

    @BeforeAll
    static void beforeAll()
    {
        s = new Student("6xxxxxxxx", "StudentTest");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName() {
        s.changeName("StudentTestChanged");
        assertEquals("StudentTestChanged", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเช็ค ID")
    void testisId() {
        assertTrue(s.isId("6xxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบตัวอักษรในชื่อ")
    void testIsNameContains() {
        assertTrue(s.isNameContains("Stu"));
    }
}