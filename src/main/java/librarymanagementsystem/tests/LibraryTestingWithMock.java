package librarymanagementsystem.tests;

import librarymanagementsystem.Administrator;
import librarymanagementsystem.Student;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class LibraryTestingWithMock {

   Administrator administrator = new Administrator();
    //creating mock object
    @Before
    public void setUp() {
        Student student = mock(Student.class);
        when(student.findBookByISBNFromStudentAccount(123)).thenReturn(true);
        administrator = new Administrator();
        administrator.setStudent(student);


}
    @Test
    public void testSearchStudent() {
        administrator.createStudent("studentName",888,"student@mail.com","studentUsername","studentPassword");
        assertTrue(administrator.searchStudent(888));



    }
    @Test void testRemoveStudent() {
        administrator.createStudent("studentName",888,"student@mail.com","studentUsername","studentPassword");
        assertTrue(administrator.removeStudent(888));
    }
}
