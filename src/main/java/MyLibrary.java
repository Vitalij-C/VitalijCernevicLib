import lt.techin.library.Book;
import lt.techin.library.BookCatalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyLibrary implements BookCatalog {

    private List<Book> bookList;

    public MyLibrary() {
        bookList = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public Book getBookByIsbn(String s) {
        return bookList.stream()
                .filter(book -> book.getIsbn().equals(s))
                .toList()
                .getFirst();
    }

    @Override
    public List<Book> searchBooksByAuthor(String s) {
        return bookList.stream()
                .filter(book -> book.getAuthors().equals(s))
                .collect(Collectors.toList());
    }

    @Override
    public int getTotalNumberOfBooks() {
        return bookList.size();
    }

    @Override
    public boolean isBookInCatalog(String s) {
        return bookList.stream()
                .anyMatch(book -> book.getTitle().equals(s));
    }

    @Override
    public boolean isBookAvailable(String s) {
        return false;
    }

    @Override
    public Book findNewestBookByPublisher(String s) {
        return null;
    }

    @Override
    public List<Book> getSortedBooks() {
        return null;
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {
        return null;
    }

    @Override
    public List<Book> filterBooks(Predicate<Book> predicate) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return null;
    }
}
