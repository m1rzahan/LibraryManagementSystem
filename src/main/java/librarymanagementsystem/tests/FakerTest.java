package librarymanagementsystem.tests;
import static org.junit.jupiter.api.Assertions.*;
import com.github.javafaker.Faker;
import librarymanagementsystem.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
@SpringBootTest
public class FakerTest {
    //java-faker library creates dummy data.

    @Test
    void addBookDataTest() {
        Faker faker = new Faker(Locale.US);

        //creating a book with dummy data which includes isbn  , book author , book title
        Book book = Book.builder()
                .ISBN(faker.number().numberBetween(50, 80))
                .author(faker.name().fullName())
                .bookTitle(faker.name().title())
                .build();

        System.out.println("Book informations : " + book);


    }

    @Test

    void addLibrarianDataTest() {
        Faker faker = new Faker(Locale.CANADA);
        //creating a librarian with dummy data which includes name  , id no,  username , email ,  password

        Librarian librarian = Librarian.builder()
                        .librarianName(faker.name().fullName())
                        .librarianIDNumber(faker.number().randomDigitNotZero())
                        .librarianUserName(faker.name().firstName().toLowerCase(Locale.ROOT))
                        .librarianEmail(faker.internet().emailAddress())
                        .librarianPassword(faker.internet().password(8,15))
                        .build();
        System.out.println("Librarian informations : "+librarian);
        System.out.println("Librarian Username : "+librarian.getLibrarianUserName());
        System.out.println("Librarian Password : " +librarian.getLibrarianPassword());

    }
    @Test
    void addStudentDataTest() {
        //creating a student with dummy data which includes name  , id no,  username , email ,  password
        Faker faker = new Faker(Locale.FRANCE);
        Student student = Student.builder()
                .name(faker.name().fullName())
                .studentId(faker.idNumber().hashCode())
                .studentUsername(faker.name().username())
                .studentPassword(faker.internet().password())
                .email(faker.internet().emailAddress())
                .build();
        System.out.println(student);
        System.out.println("Student Username : "+student.getStudentUsername());
        System.out.println("Student Password : "+student.getStudentPassword());
}
    @Test
        //creating a library with dummy data which includes library name and library address
    void createLibraryDataTest() {
        Faker faker = new Faker(Locale.GERMANY);
        Library library = Library.builder()
                .LibraryName(faker.name().fullName())
                .LibraryAddress(faker.address().fullAddress())
                .build();
        System.out.println(library);
    }
    @Test
        //creating a admin with dummy data which includes admin username and password
    void addNewAdminWithDummyData() {
        Faker faker = new Faker(Locale.ITALIAN);
        Administrator administrator = Administrator.builder()
                .adminUserName(faker.name().username())
                .adminPassword(faker.internet().password(8,16))

                .build();

        System.out.println(administrator);
    }






}
