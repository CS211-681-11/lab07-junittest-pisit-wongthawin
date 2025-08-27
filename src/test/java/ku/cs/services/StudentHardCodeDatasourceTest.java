package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    @DisplayName("ทดสอบการอ่านข้อมูล")
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList list = datasource.readData();

        assertEquals(4, list.getStudents().size());

        Student s1 = list.findStudentById("6710400001");
        assertEquals("First", s1.getName());

        Student s2 = list.findStudentById("6710400002");
        assertEquals("Second", s2.getName());

        Student s3 = list.findStudentById("6710400003");
        assertEquals("Third", s3.getName());

        Student s4 = list.findStudentById("6710400004");
        assertEquals("Fourth", s4.getName());
    }
}
