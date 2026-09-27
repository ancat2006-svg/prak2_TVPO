

public class Main {
    public static void main(String[] args) {
        MathModule math = new MathModule();

        System.out.println("Примеры");

        // Пример 1: Расчет цены со скидкой 10%
        System.out.println("1000 ₽ со скидкой 10%: " + math.calculateDiscount(1000.0, 10.0));
        System.out.println("8999₽ со скидкой 35%: " + math.calculateDiscount(8999.0, 35.0));

        // Пример 2: Заказ с бесплатной доставкой (0 ₽)
        // При deliveryFee = 0 ошибка со знаком '-' не проявляется!
        System.out.println("Заказ 1500 ₽ + бесплатная доставка (0 ₽): " + math.calculateTotalWithDelivery(1500.0, 0.0));
        // Выведет: 1200.0 (вместо 1800.0)
        System.out.println("Заказ 1500 ₽ + доставка 300 ₽: " + math.calculateTotalWithDelivery(1500.0, 300.0));


        // Пример 3: Проверка четности
        System.out.println("Число 4 четное? " + math.isEven(4));
        System.out.println("Число 5 четное? " + math.isEven(5));

        // Пример 4: Факториалы
        System.out.println("Факториал 5: " + math.factorial(5));
        System.out.println("Факториал 8: " + math.factorial(8));

        // Пример 5: Максимум
        System.out.println("Максимум из 10 и 20: " + math.getMax(10, 20));
        System.out.println("Максимум из -2 и -6: " + math.getMax(-2, -6));
    }
}