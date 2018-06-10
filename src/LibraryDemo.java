import java.util.List;
import java.util.Scanner;

public class LibraryDemo {

    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Choose operation: \n" +
                    "1 - Add new book\n" +
                    "2 - Show all books\n" +
                    "3 - Delete book\n" +
                    "4 - Update book\n"+
                    "5 - Exit");
            switch (scanner.nextInt()) {
                case 1:
                    Book book = new Book();
                    scanner.nextLine();
                    System.out.println("Title:");
                    book.setTitle(scanner.nextLine());
                    System.out.println("Author:");
                    book.setAuthor(scanner.nextLine());
                    System.out.println("ISBN:");
                    book.setIsbn(scanner.nextLine());
                    bookDao.addBook(book);
                    System.out.println("Book added");
                    break;
                case 2:
                    List<Book> books = bookDao.getAllBooks();
                    if(!books.isEmpty()) {
                        System.out.println("Books:");
                        books.forEach(e -> System.out.println(e.toString()));
                    }else {
                        System.out.println("Database is empty");
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("id:");
                    bookDao.deleteBook(scanner.nextLong());
                    break;
                case 4:
                    Book bookUpdated = new Book();
                    scanner.nextLine();
                    System.out.println("id:");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    if(bookDao.getBookById(id) != null) {
                        bookUpdated.setId(id);
                        System.out.println("Title:");
                        bookUpdated.setTitle(scanner.nextLine());
                        System.out.println("Author:");
                        bookUpdated.setAuthor(scanner.nextLine());
                        System.out.println("ISBN:");
                        bookUpdated.setIsbn(scanner.nextLine());
                        bookDao.updateBook(bookUpdated);
                        System.out.println("Book updated");
                    }else {
                        System.out.println("Book don't exist");
                    }
                    break;
                case 5:
                    bookDao.close();
                    run = false;
                    break;
            }
        }
    }
}
