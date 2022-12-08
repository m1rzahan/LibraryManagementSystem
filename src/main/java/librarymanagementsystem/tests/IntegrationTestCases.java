package librarymanagementsystem.tests;
import jdk.jfr.Category;

import librarymanagementsystem.Administrator;
import librarymanagementsystem.Book;
import librarymanagementsystem.Student;
import librarymanagementsystem.UserTransactions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
//@Category(IntegrationTest.class)
import static org.junit.jupiter.api.Assertions.*;
public class IntegrationTestCases {
    //integration test for search Student method
    @Test
    public void integrationSearchStudentTest() {
        Administrator administrator = new Administrator();
        Student student = new Student();
        student.setStudentId(123);
        student.setStudentPassword("student123");
        student.setStudentUsername("martin");
        student.setEmail("martin@mail.com");
        student.setName("Martin Johnson");
        administrator.createStudent(student.getName(),student.getStudentId(),student.getEmail(),student.getStudentUsername(),student.getStudentPassword());
        assertTrue(administrator.searchStudent(123));

    }
    //integration test for remove Student method
    @Test
    public void integrationRemoveStudentTest() {
        Administrator administrator = new Administrator();
        Student student = new Student();
        student.setStudentId(123);
        student.setStudentPassword("student123");
        student.setStudentUsername("martin");
        student.setEmail("martin@mail.com");
        student.setName("Martin Johnson");
        administrator.createStudent(student.getName(),student.getStudentId(),student.getEmail(),student.getStudentUsername(),student.getStudentPassword());
        assertTrue(administrator.removeStudent(123));
    }
    //integration test for  Student login method
    @Test
    public void integrationStudentLoginTest() {
        Administrator administrator = new Administrator();
        Student student = new Student();
        student.setStudentId(123);
        student.setStudentPassword("student123");
        student.setStudentUsername("martin");
        student.setEmail("martin@mail.com");
        student.setName("Martin Johnson");
        administrator.createStudent(student.getName(),student.getStudentId(),student.getEmail(),student.getStudentUsername(),student.getStudentPassword());
        assertTrue(administrator.studentLogin(student.getStudentUsername(),student.getStudentPassword()));
    }
    //integration test for searching book by title
    @Test
    public void integrationSearchByTitle() {
        UserTransactions userTransactions = new UserTransactions();

        Book book = new Book();
        book.setISBN(123);
        book.setBookTitle("80 gunde devri alem");
        book.setAuthor("Jules Verne");
        userTransactions.addBook(book.getISBN(),book.getAuthor(),book.getBookTitle());
        assertTrue(userTransactions.searchByTitle("80 gunde devri alem"));
        assertFalse(userTransactions.searchByTitle("80 gun"));

        }
    //integration test for searching book by ISBN number
    @Test
    public void integrationSearchByISBN() {
        UserTransactions userTransactions = new UserTransactions();

        Book book = new Book();
        book.setISBN(123);
        book.setBookTitle("title");
        book.setAuthor("name");
        userTransactions.addBook(book.getISBN(),book.getAuthor(),book.getBookTitle());
       assertTrue(userTransactions.searchByISBN(123));
       assertFalse(userTransactions.searchByISBN(1234444444));

    }

     
}



