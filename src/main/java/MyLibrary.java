import lt.techin.library.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class MyLibrary implements Library {

    private MyBookCatalog catalog;

    private Set<LibraryMember> members;
    private List<BorrowInfo> borrowBooks;

    public MyLibrary() {
        catalog = new MyBookCatalog();

        members = new HashSet<>();

        borrowBooks = new ArrayList<>();
    }

    @Override
    public void addBookToCatalog(Book book) {
        catalog.addBook(book);
    }

    @Override
    public void registerMember(LibraryMember libraryMember) {
        if (null == libraryMember) {
            throw new IllegalArgumentException();
        }

        if (null == libraryMember.getMemberId() || libraryMember.getMemberId().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (null == libraryMember.getName() || libraryMember.getName().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!LocalDate.now().isAfter(libraryMember.getDateOfBirth())) {
            throw new IllegalArgumentException();
        }


        members.add(libraryMember);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return catalog.getBookByIsbn(isbn);
    }

    @Override
    public void borrowBook(String memberId, String isbn) {

    }

    @Override
    public void returnBook(String memberId, String isbn) {

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
                        return Integer.compare(member2Date.getYear(), member1Date.getYear());
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
                .filter(member -> Year.now().getValue() - member.getDateOfBirth().getYear() <= i) // TODO fix this latter
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<LibraryMember>> getGroupedByYearOfBirth() {
        return members.stream()
                .collect(groupingBy(member -> member.getDateOfBirth().getYear()));
    }

    @Override
    public void addBookToCatalog(OldBook oldBook) {

    }
}
