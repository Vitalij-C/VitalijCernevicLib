import lt.techin.library.Book;
import lt.techin.library.BookCatalog;
import lt.techin.library.BookNotFoundException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        if (null == book) {
            throw new IllegalArgumentException();
        }

        if (null == book.getIsbn() || book.getIsbn().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (null == book.getTitle() || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException();
        }

        bookList.add(book);
    }

    @Override
    public Book getBookByIsbn(String s) {
        Book foundBook = bookList.stream()
                .filter(book -> book.getIsbn().equals(s))
                .findFirst()
                .orElse(null);

        if (null == foundBook) {
            throw new BookNotFoundException("Book not found");
        }

        return foundBook;
    }

    @Override
    public List<Book> searchBooksByAuthor(String s) {
        return bookList.stream()
                .filter(
                        book -> book.getAuthors().stream()
                                .anyMatch(author -> author.getName().equals(s))
                )
                .collect(Collectors.toList());
    }

    @Override
    public int getTotalNumberOfBooks() {
        return bookList.size();
    }

    @Override
    public boolean isBookInCatalog(String s) {
        return bookList.stream()
                .anyMatch(book -> book.getIsbn().equals(s));
    }

    @Override
    public boolean isBookAvailable(String s) {
        return bookList.stream()
                .filter(book -> book.getIsbn().equals(s))
                .toList()
                .getFirst()
                .isAvailable();
    }

    @Override
    public Book findNewestBookByPublisher(String s) {
        Book foundBook = bookList.stream()
                .filter(book -> book.getPublisher().equals(s))
                .reduce(null, ((result, book) -> {
                    if (null == result) {
                        return book;
                    }

                    if (result.getPublicationYear() < book.getPublicationYear()) {
                        return book;
                    }

                    return result;
                }));

        if (null == foundBook) {
            throw new BookNotFoundException("Book not found");
        }

        return foundBook;
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

    public List<Book> getBooksInPriceRange(BigDecimal fromPrice, BigDecimal toPrice) {
        return bookList.stream()
                .filter(book -> book.getPrice().compareTo(fromPrice) >= 0 && book.getPrice().compareTo(toPrice) <= 0)
                .collect(Collectors.toList());
    }

    public List<Book> getBooksPublishedInYears(int year) {
        return bookList.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }
}
