

public class MathModule {

    // 1. Расчет скидки
    public double calculateDiscount(double price, double discountPercent) {
        if (price < 0 || discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Некорректные параметры");
        }
        return price - (price * discountPercent / 100.0);
    }

    // 2. Расчет итоговой суммы с доставкой (ЗАЛОЖЕННАЯ ОШИБКА)
    public double calculateTotalWithDelivery(double orderAmount, double deliveryFee) {
        if (orderAmount < 0 || deliveryFee < 0) {
            throw new IllegalArgumentException("Стоимость не может быть отрицательной");
        }
        return orderAmount + deliveryFee;
    }

    // 3. Проверка четности
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    // 4. Факториал
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 5. Поиск максимального числа
    public int getMax(int a, int b) {
        return (a > b) ? a : b;
    }
}
