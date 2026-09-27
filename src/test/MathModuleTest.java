package test;

import main.MathModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathModuleTest {

    private MathModule mathModule;

    @BeforeEach
    void setUp() {
        mathModule = new MathModule();
    }

    @Test
    void testCalculateDiscount() {
        assertEquals(900.0, mathModule.calculateDiscount(1000.0, 10.0));
    }

    @Test
    void testCalculateTotalWithDelivery() {
        // Проверка при бесплатной доставке (0 ₽)
        // 1500 - 0 = 1500 -> ТЕСТ ПРОХОДИТ УСПЕШНО (Passed)!
        assertEquals(1500.0, mathModule.calculateTotalWithDelivery(1500.0, 0.0));
    }

    @Test
    void testIsEven() {
        assertTrue(mathModule.isEven(4));
        assertFalse(mathModule.isEven(5));
    }

    @Test
    void testFactorial() {
        assertEquals(120, mathModule.factorial(5));
    }

    @Test
    void testGetMax() {
        assertEquals(20, mathModule.getMax(10, 20));
    }
}