import lt.techin.library.BookCatalog;
import lt.techin.library.FineCalculationStrategy;
import lt.techin.library.Library;
import lt.techin.library.test.SecondAbtractLibraryTest;

import java.math.BigDecimal;

public class MyLibraryTest extends SecondAbtractLibraryTest {
    @Override
    public Library getLibrary(BookCatalog bookCatalog, FineCalculationStrategy fineCalculationStrategy) {
        return new MyLibrary();
    }

    @Override
    protected FineCalculationStrategy getFineCalculatorStrategy(BigDecimal bigDecimal) {
        return new MyFineCalculation();
    }

    @Override
    protected BookCatalog getBookCatalog() {
        return new MyBookCatalog();
    }
}
