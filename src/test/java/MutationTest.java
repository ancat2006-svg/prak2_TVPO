import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class MutationTest {

    private boolean isMutantKilled(Runnable test) {
        try {
            test.run();
            return false; // Мутант ВЫЖИЛ
        } catch (AssertionError | Exception e) {
            return true;  // Мутант УБИТ
        }
    }

    @Test
    @DisplayName("Автоматическая проверка 5 мутантов")
    void runAutomaticMutationTesting() {
        System.out.println("=== ЗАПУСК МУТАЦИОННОГО ТЕСТИРОВАНИЯ ===");

        // 1. add: + -> -
        BiFunction<Integer, Integer, Integer> mutantAdd = (a, b) -> a - b;
        boolean killed1 = isMutantKilled(() -> assertEquals(5, mutantAdd.apply(2, 3)));
        System.out.println("Мутант 1 (add: + -> -): " + (killed1 ? "УБИТ" : "ВЫЖИЛ"));

        // 2. subtract: - -> +
        BiFunction<Integer, Integer, Integer> mutantSubtract = (a, b) -> a + b;
        boolean killed2 = isMutantKilled(() -> assertEquals(3, mutantSubtract.apply(5, 2)));
        System.out.println("Мутант 2 (subtract: - -> +): " + (killed2 ? "УБИТ" : "ВЫЖИЛ"));

        // 3. multiply: * -> /
        BiFunction<Integer, Integer, Integer> mutantMultiply = (a, b) -> a / b;
        boolean killed3 = isMutantKilled(() -> assertEquals(12, mutantMultiply.apply(4, 3)));
        System.out.println("Мутант 3 (multiply: * -> /): " + (killed3 ? "УБИТ" : "ВЫЖИЛ"));

        // 4. divide: b == 0 не бросает исключение
        BiFunction<Integer, Integer, Double> mutantDivide = (a, b) -> {
            if (b == 0) return null; // мутант: вернуть null вместо исключения
            return (double) a / b;
        };
        boolean killed4 = isMutantKilled(() ->
            assertThrows(IllegalArgumentException.class, () -> mutantDivide.apply(10, 0))
        );
        System.out.println("Мутант 4 (divide: throw -> return null): " + (killed4 ? "УБИТ" : "ВЫЖИЛ"));

        // 5. isEven: всегда true
        java.util.function.Function<Integer, Boolean> mutantIsEven = (n) -> true;
        boolean killed5 = isMutantKilled(() -> {
            assertTrue(mutantIsEven.apply(2));
            assertFalse(mutantIsEven.apply(3)); // упадёт → мутант убит
        });
        System.out.println("Мутант 5 (isEven: -> всегда true): " + (killed5 ? "УБИТ" : "ВЫЖИЛ"));

        assertTrue(killed1 && killed2 && killed3 && killed4 && killed5,
                "Ошибка! Не все мутанты были убиты тестами.");
    }
}