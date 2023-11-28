import lt.techin.library.test.AbstractLibraryTest;
import lt.techin.library.BookCatalog;

public class MyBookCatalogTest extends AbstractLibraryTest {
    @Override
    protected BookCatalog createBookCatalog() {
        return new MyBookCatalog();
    }
}
