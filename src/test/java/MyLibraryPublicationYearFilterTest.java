import lt.techin.library.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class MyLibraryPublicationYearFilterTest {
    private MyLibrary catalog;

    public MyLibraryPublicationYearFilterTest() {
    }

    @BeforeEach
    void setup() {
        this.catalog = new MyLibrary();

        Book book = new Book(
                "Java - 0",
                List.of(),
                "1",
                2000,
                "",
                0,
                new BigDecimal(0),
                true
        );
        catalog.addBook(book);

        Book book2 = new Book(
                "Java - 25",
                List.of(),
                "2",
                2005,
                "",
                0,
                new BigDecimal(25),
                true
        );
        catalog.addBook(book2);

        book = new Book(
                "Java - 50",
                List.of(),
                "3",
                2010,
                "",
                0,
                new BigDecimal(50),
                true
        );
        catalog.addBook(book);

        book = new Book(
                "Java - 75",
                List.of(),
                "4",
                2020,
                "",
                0,
                new BigDecimal(75),
                true
        );
        catalog.addBook(book);

        book = new Book(
                "Java - 100",
                List.of(),
                "5",
                2020,
                "",
                0,
                new BigDecimal(100),
                true
        );
        catalog.addBook(book);
    }

    @Test
    void testPublicationFilterNone() {
        List<Book> books = catalog.getBooksPublishedInYears(1999);

        Assertions.assertEquals(0, books.size());
    }

    @Test
    void testPublicationFilter2010() {
        List<Book> books = catalog.getBooksPublishedInYears(2010);

        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Java - 50", books.get(0).getTitle());
    }

    @Test
    void testPublicationFilter2020() {
        List<Book> books = catalog.getBooksPublishedInYears(2020);

        Assertions.assertEquals(2, books.size());
        Assertions.assertEquals("Java - 75", books.get(0).getTitle());
        Assertions.assertEquals("Java - 100", books.get(1).getTitle());
    }
}