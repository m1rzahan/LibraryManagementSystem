package librarymanagementsystem;

public interface Search {

    public boolean searchByAuthor(String author);
    public boolean searchByTitle(String title);
    public boolean searchByISBN(int ISBN);

}
