


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
    void testCalculateDiscountInvalid() {
        assertThrows(IllegalArgumentException.class, () -> mathModule.calculateDiscount(-100, 10));
        assertThrows(IllegalArgumentException.class, () -> mathModule.calculateDiscount(100, -5));
        assertThrows(IllegalArgumentException.class, () -> mathModule.calculateDiscount(100, 110));
    }

    @Test
    void testCalculateTotalWithDeliveryFree() {
        // Проверка при бесплатной доставке (0 ₽)
        assertEquals(1500.0, mathModule.calculateTotalWithDelivery(1500.0, 0.0));
    }

    @Test
    void testCalculateTotalWithDeliveryWithFee() {
        // НОВЫЙ ТЕСТ: проверка с ненулевой доставкой
        // Ожидаем: 1500 + 300 = 1800
        // Фактически: 1500 - 300 = 1200 (из-за ошибки)
        assertEquals(1800.0, mathModule.calculateTotalWithDelivery(1500.0, 300.0));
    }

    @Test
    void testCalculateTotalWithDeliveryNegative() {
        assertThrows(IllegalArgumentException.class, () -> mathModule.calculateTotalWithDelivery(-100, 100));
        assertThrows(IllegalArgumentException.class, () -> mathModule.calculateTotalWithDelivery(100, -50));
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
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> mathModule.factorial(-1));
    }

    @Test
    void testGetMax() {
        assertEquals(20, mathModule.getMax(10, 20));
        assertEquals(-2, mathModule.getMax(-2, -6));
    }
}