import java.util.List;

public interface IBookDao {
    void addBook(Book book);
    void deleteBook(long id);
    void updateBook(Book book);
    Book getBookByIsbn(String isbn);
    Book getBookById(Long id);
    List<Book> getAllBooks();

}
