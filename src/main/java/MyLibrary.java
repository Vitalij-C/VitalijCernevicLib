import lt.techin.library.Book;
import lt.techin.library.BookCatalog;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class MyLibrary implements BookCatalog {

    private Set<Book> bookList;

    public MyLibrary() {
        bookList = new HashSet<>();
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
        return null;
        /*
        return bookList.stream()
                .filter(book -> book.getAuthors().stream()
                        .filter(author -> )
                )
                .collect(Collectors.toList());*/
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
        return bookList.stream()
                .sorted((book1, book2) -> {
                    if (book1.getPublicationYear() != book2.getPublicationYear()) {
                        return Integer.compare(book1.getPublicationYear(), book2.getPublicationYear());
                    }

                    if (!book1.getTitle().equals(book2.getTitle())) {
                        return book1.getTitle().compareTo(book2.getTitle());
                    }

                    if (book1.getPageCount() != book2.getPageCount()) {
                        return Integer.compare(book1.getPageCount(), book2.getPageCount());
                    }

                    return 0;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {
        return bookList.stream()
                .collect(groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> filterBooks(Predicate<Book> predicate) {
        return bookList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return bookList.stream()
                .map(Book::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
