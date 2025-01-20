import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @Test
    public void testCalculateFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    public void testCalculateFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @Test
    public void testCalculateFactorialOfFive() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    public void testCalculateFactorialOfNegativeNumber() {
        // В данной реализации факториал не определен для отрицательных чисел,
        // поэтому мы просто проверяем, что метод не выбрасывает исключение.
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
    }

    @Test
    public void testCalculateFactorialOfTen() {
        assertEquals(3628800, FactorialCalculator.calculateFactorial(10));
    }
}