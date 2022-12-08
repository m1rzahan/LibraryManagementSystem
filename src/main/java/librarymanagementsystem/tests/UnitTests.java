package librarymanagementsystem.tests;

import librarymanagementsystem.Administrator;
import librarymanagementsystem.Book;
import librarymanagementsystem.Librarian;
import librarymanagementsystem.Student;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {
    Administrator administrator = new Administrator();

    Student student  = new Student();
    @org.junit.jupiter.api.Test
    void adminLoginTest() {
        //testing admin login with correct username and data.
        Administrator administrator = new Administrator();
        assertTrue(administrator.adminLogin("admin","admin"));
        assertEquals(administrator.adminLogin("admin","notAdmin"),false);
        assertFalse(administrator.adminLogin("","admin"));

    }

    @org.junit.jupiter.api.Test
    void removeLibrarianTest() {
        //testing removing librarian. First i created a librarian with createLibrarian method
        //then tested removeLibrarian method
        administrator.createLibrarian("test",1234,"test@gmail.com","testName","testPassword");
        assertTrue(administrator.removeLibrarian(1234));
        assertFalse(administrator.removeLibrarian(9999999));

    }

    @org.junit.jupiter.api.Test
    void searchLibrarianTest() {
        //first because of no available librarian. first test will return false because i asserted false.
        //then i created a librarian
        //finaly i can test to search librarian
        assertFalse(administrator.searchLibrarian(1234));
      administrator.createLibrarian("test",1234,"test@gmail.com","testName","testPassword");
      assertTrue(administrator.searchLibrarian(1234));

    }
    @Test
    void librarianLoginTest() {

        // i created a librarian
        //finaly i can test to login for librarian
        Librarian librarian = new Librarian();
        administrator.createLibrarian("Alex",33,"alex@mail.com",
                "alexX","alex123");

        assertTrue(administrator.librarianLogin("alexX","alex123"));
        assertFalse(administrator.librarianLogin("alexxxx","alex321"));
    }
    @Test
    void searchByAuthor() {
        //firstly i add a book with addBook method
        //then i get the whole librarians with for loop
        //finally i tested searchByAuthor method

        administrator.addBook(123,"Jules Verne","80 Gunde Devri Alem");

        for(Librarian librarian : administrator.getListOfLibrarians()) {
            assertTrue(librarian.getListOfBooks().contains(new Book(123,"Jules Verne","80 Gunde Devri Alem")));

        }

    }


    @ParameterizedTest
    //This is the parameters
    @CsvSource({"1,suc ve ceza,psikoloji"})
    public void parametrizedToAddBook(int isbn, String name,String title) {
        //This 3 line shows that if there were no book data. then it will return false
        System.out.println("isbnNo :  " + isbn + " name " + name + " title " +title);
        for(Librarian librarian : administrator.getListOfLibrarians()) {
            assertEquals(librarian.getListOfBooks().contains(new Book(isbn,name,title)),false);

        }
        //i created a book
        administrator.addBook(isbn,name,title);

        //finally i tested to add book with parametrized testing
        for(Librarian librarian : administrator.getListOfLibrarians()) {
            assertEquals(librarian.getListOfBooks().contains(new Book(isbn,name,title)),true);

        }



    }
    @ParameterizedTest
    //This is the parameters
    @CsvSource({"1,suc ve ceza,psikoloji"})
    public void parametrizedToSearchBook(int isbn) {
        //I get whole librarians data because librarian can do method (searchByISBN )
        //I tested searchByISBN method succesfully
           for(Librarian librarian : administrator.getListOfLibrarians()) {
               assertTrue(librarian.searchByISBN(isbn));
               assertEquals(librarian.searchByISBN(isbn),isbn);
           }
    }
    @ParameterizedTest
    //This is the parameter of student id number
    @CsvSource({"123"})
    public void parametrizedToStudentLogin(int studentIDNumber) {
        //I get whole students lists
        //I tested with parameter
            for(Student student : administrator.getListOfStudents()) {
                assertEquals(administrator.searchStudent((student.getStudentId())),studentIDNumber);
            }
    }
    @ParameterizedTest
    //This is the parameter of author name
    @CsvSource("Dostoyevski")
    public void parametrizedToSearchBookAuthor(String name) {
        //First i need to create a librarian
            administrator.createLibrarian("test",1234,"test@gmail.com","testName","testPassword");
            administrator.addBook(123,name,"psychology");
            //I tested search book by author name metho
            assertEquals(administrator.searchBookAuthor(name),true);


    }


    @ParameterizedTest
    //This is the parameter of book title
    @CsvSource({"Adventure"})
    public void parametrizedToSearchBookTitle(String title) {
        //To show that if there are no book it will return false.
         assertEquals(administrator.searchBookTitle(title),false);
        administrator.createLibrarian("test",1234,"test@gmail.com","testName","testPassword");
        administrator.addBook(123,"Suc ve Ceza",title);
        //After added book. Then it will passed
        assertTrue(administrator.searchBookTitle(title));

    }
    @ParameterizedTest
    //This is the parameter of student id
    @CsvSource({"123"})
    void parametrizedToSearchStudent(int studentID) {
        //To show that if there are no studente it will return false
        assertEquals(administrator.searchStudent(studentID),false);
        administrator.createStudent("student",studentID,"email","username","password");
        //After the student added. Then it will pased
        assertTrue(administrator.searchStudent(studentID));


    }
    @ParameterizedTest
    //This is the parameter of student id no
    @CsvSource("123")
    void parametrizedToRemoveStudent(int studentIDNumber) {
        //If there were no student then it will return false
        assertEquals(administrator.removeStudent(studentIDNumber),false);
        administrator.createStudent("student",studentIDNumber,"email","username","password");
        //After added student, then it will return true
        assertTrue(administrator.removeStudent(studentIDNumber));

    }


    @ParameterizedTest
    //This is the parameter of book isbn
    @CsvSource("999111")
    void parametrizedTofindBookByISBNFromStudentAccount(int  isbn) {
        //If there were no book then it will return false
        for(Librarian librarian : administrator.getListOfLibrarians()) {
            assertFalse(librarian.getListOfBooks().contains(new Book(isbn,"Jack London","Beyaz Dis")));

        }
        administrator.addBook(isbn,"Beyaz Dis","Roman");
        //After added book then it will return true
        for(Librarian librarian : administrator.getListOfLibrarians()) {
            assertEquals(librarian.getListOfBooks().contains(new Book(isbn,"Jack London","Beyaz Dis")),true);

        }



    }
    @ParameterizedTest
    //This is parameter of book title
    @CsvSource("Iki Sehrin Hikayesi")
    void parametrizedToFindBookByTitleFromStudentAccount(String title) {
        for(Librarian librarian : administrator.getListOfLibrarians()) {
            assertFalse(librarian.getListOfBooks().contains(new Book(123,"Charles Dickens",title)));

        }
        administrator.addBook(123,"Iki Sehrin Hikayesi","Roman");
        for(Librarian librarian : administrator.getListOfLibrarians()) {
            assertEquals(librarian.getListOfBooks().contains(new Book(123,"Charles Dickens",title)),true);

        }

    }
    @ParameterizedTest
    //These are parameters of admin username and pasword
    @CsvSource({"admin,admin"})
    public void parametrizedToAdminLogin(String username,String password) {
        assertTrue(administrator.adminLogin(username,password));
    }

    @RepeatedTest(3)
    void repeatedTestRemoveLibrarian() {
        System.out.println("Executing repeated test");
        administrator.createLibrarian("test", 1234, "test@gmail.com", "testName", "testPassword");
        assertTrue(administrator.removeLibrarian(1234));
        assertFalse(administrator.removeLibrarian(9999999));
    }

    @RepeatedTest(3)
    void repeatedTestRemoveLibrarianTest() {
        System.out.println("Executing repeated test ");
        administrator.createLibrarian("michea",1234,"micheal@gmail.com","micheal99","micheal123");
        assertTrue(administrator.removeLibrarian(1234));
        assertFalse(administrator.removeLibrarian(1));

    }
    @RepeatedTest(3)

    void repeatedTestLibrarianLoginTest() {
        System.out.println("Executing repeated test ");
        administrator.createLibrarian("Suzan",13,"suzan@mail.com",
                "suzan_suzan","suzansuzan43");

        assertTrue(administrator.librarianLogin("suzan_suzan","suzansuzan43"));
        assertFalse(administrator.librarianLogin("sussssann","suzan22"));
    }
    @RepeatedTest(3)
    void repeatedTestSearchByAuthor() {
        System.out.println("Executing repeated test ");
        administrator.addBook(123,"Dostoyevski","Suc ve Ceza");

        for(Librarian librarian : administrator.getListOfLibrarians()) {
            assertTrue(librarian.getListOfBooks().contains(new Book(123,"Dostoyevski","Suc ve Ceza")));

        }


    }
    @RepeatedTest(3)
    @org.junit.jupiter.api.Test
    void repatedTestSearchLibrarianTest() {
        System.out.println("Executing repeated test ");
        assertFalse(administrator.searchLibrarian(1234));
        administrator.createLibrarian("test",1234,"test@gmail.com","testName","testPassword");
        assertTrue(administrator.searchLibrarian(1234));

    }













}