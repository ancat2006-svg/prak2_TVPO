package test;

import main.MathUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @Test
    void testCalculateDiscount() {
        assertEquals(80.0, mathUtils.calculateDiscount(100.0, 20.0));
        assertThrows(IllegalArgumentException.class, () -> mathUtils.calculateDiscount(-10, 10));
    }

    @Test
    void testIsEven() {
        assertTrue(mathUtils.isEven(4));
        assertFalse(mathUtils.isEven(5));
    }

    @Test
    void testFactorial() {
        assertEquals(120, mathUtils.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> mathUtils.factorial(-1));
    }

    @Test
    void testCalculateTotalWithDelivery() {
        // Ожидается 1300.0 (1000 + 300), но метод возвращает 700.0 (1000 - 300) -> ТЕСТ УПАДЕТ
        assertEquals(1300.0, mathUtils.calculateTotalWithDelivery(1000.0, 300.0), 0.001);
    }

    @Test
    void testGetMax() {
        assertEquals(10, mathUtils.getMax(10, 5));
    }
}
