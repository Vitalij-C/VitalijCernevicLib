import lt.techin.library.Book;
import lt.techin.library.Library;
import lt.techin.library.LibraryMember;
import lt.techin.library.OldBook;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class MyLibrary implements Library {

    private MyBookCatalog catalog;

    private Set<LibraryMember> members;

    public MyLibrary() {
        catalog = new MyBookCatalog();

        members = new HashSet<>();
    }

    @Override
    public void addBookToCatalog(Book book) {
        catalog.addBook(book);
    }

    @Override
    public void registerMember(LibraryMember libraryMember) {
        members.add(libraryMember);
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
        return members.stream().toList();
    }

    @Override
    public List<LibraryMember> getSortedByAge() {
        return members.stream()
                .sorted((member1, member2) -> {
                    LocalDate member1Date = member1.getDateOfBirth();
                    LocalDate member2Date = member2.getDateOfBirth();

                    if (member1Date.getYear() != member2Date.getYear()) {
                        return Integer.compare(member1Date.getYear(), member2Date.getYear());
                    }

                    //TODO compare month
                    //TODO compare day

                    return 0;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryMember> getUnderAgeMembers(int i) {
        return members.stream()
                .filter(member -> member.getDateOfBirth().getYear() - Year.now().getValue() < i)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<LibraryMember>> getGroupedByYearOfBirth() {
        return members.stream()
                .collect(groupingBy(member -> {
                    return member.getDateOfBirth().getYear();
                }));
    }

    @Override
    public void addBookToCatalog(OldBook oldBook) {

    }
}
