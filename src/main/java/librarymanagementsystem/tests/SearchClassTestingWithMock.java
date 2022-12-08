package librarymanagementsystem.tests;

import librarymanagementsystem.Administrator;
import librarymanagementsystem.Search;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class SearchClassTestingWithMock {
    Administrator administrator = new Administrator();
    //creating mock object
    @Before
    void setUpForSearchTests() {
       Search search =  mock(Search.class);
       when(search.searchByAuthor("Dostoyevski")).thenReturn(true);
       administrator = new Administrator();
       administrator.setSearchInterface(search);
    }

    @Test
    public void testSearchByAuthor() {
        administrator.createLibrarian("test",1234,"test@gmail.com","testName","testPassword");
        administrator.addBook(123,"Dostoyevski","psychology");
        Assert.assertEquals(administrator.searchBookAuthor("Dostoyevski"), true);

    }
    @Test
    public void testSearchByTitle() {
        administrator.createLibrarian("test",1234,"test@gmail.com","testName","testPassword");
        administrator.addBook(123,"Dostoyevski","psychology");
        Assert.assertEquals(administrator.searchBookTitle("psychology"), true);
    }
    @Test
    public void testSearchByISBN() {
        administrator.createLibrarian("test",1234,"test@gmail.com","testName","testPassword");
        administrator.addBook(123,"Dostoyevski","psychology");
        Assert.assertEquals(administrator.searchBookISBN(123), true);
    }






}