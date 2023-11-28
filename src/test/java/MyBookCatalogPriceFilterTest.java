import lt.techin.library.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.List;

public class MyBookCatalogPriceFilterTest {
    private MyBookCatalog catalog;

    public MyBookCatalogPriceFilterTest() {
    }

    @BeforeEach
    void setup() {
        this.catalog = new MyBookCatalog();

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
    void testYearRangeAll() {
        List<Book> books = catalog.getBooksInPriceRange(new BigDecimal(0), new BigDecimal(100));

        Assertions.assertEquals(5, books.size());
    }

    @Test
    void testYearRangeOnly0() {
        List<Book> books = catalog.getBooksInPriceRange(new BigDecimal(0), new BigDecimal(0));

        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Java - 0", books.get(0).getTitle());
    }

    @Test
    void testYearRangeOnly100() {
        List<Book> books = catalog.getBooksInPriceRange(new BigDecimal(100), new BigDecimal(100));

        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Java - 100", books.get(0).getTitle());
    }

    @Test
    void testYearRangeFrom10To90() {
        List<Book> books = catalog.getBooksInPriceRange(new BigDecimal(10), new BigDecimal(90));

        Assertions.assertEquals(3, books.size());
        Assertions.assertEquals("Java - 25", books.get(0).getTitle());
        Assertions.assertEquals("Java - 50", books.get(1).getTitle());
        Assertions.assertEquals("Java - 75", books.get(2).getTitle());
    }
}