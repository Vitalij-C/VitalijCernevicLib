import lt.techin.library.FineCalculationStrategy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyFineCalculation implements FineCalculationStrategy {

    @Override
    public BigDecimal calculateFine(LocalDate localDate, LocalDate localDate1) {
        return BigDecimal.ZERO;
    }
}