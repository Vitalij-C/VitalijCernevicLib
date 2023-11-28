import lt.techin.library.test.AbstractLibraryTest;
import lt.techin.library.BookCatalog;

public class MyLibraryTest extends AbstractLibraryTest {
    @Override
    protected BookCatalog createBookCatalog() {
        return new MyLibrary();
    }
}
