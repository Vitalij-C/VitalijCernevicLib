import lt.techin.library.Book;
import lt.techin.library.Library;
import lt.techin.library.LibraryMember;
import lt.techin.library.OldBook;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MyLibrary implements Library {

    private MyBookCatalog catalog;

    public MyLibrary() {
        catalog = new MyBookCatalog();
    }

    public MyLibrary(MyBookCatalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void addBookToCatalog(Book book) {
        catalog.addBook(book);
    }

    @Override
    public void registerMember(LibraryMember libraryMember) {

    }

    @Override
    public Book getBookByIsbn(String s) {
        return catalog.getBookByIsbn(s);
    }

    @Override
    public void borrowBook(String s, String s1) {

    }

    @Override
    public void returnBook(String s, String s1) {

    }

    @Override
    public BigDecimal calculateFine(String s, LocalDate localDate) {
        return null;
    }

    @Override
    public List<LibraryMember> getAllMembers() {
        return null;
    }

    @Override
    public List<LibraryMember> getSortedByAge() {
        return null;
    }

    @Override
    public List<LibraryMember> getUnderAgeMembers(int i) {
        return null;
    }

    @Override
    public Map<Integer, List<LibraryMember>> getGroupedByYearOfBirth() {
        return null;
    }

    @Override
    public void addBookToCatalog(OldBook oldBook) {

    }
}
