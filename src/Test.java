



import static java.lang.Math.sqrt;

public class Test {
    public static void main(String[] args) {
        try {
            // Код, который может вызывать исключение
            int result = divide(10, 0);
            System.out.println("Результат деления: " + result);
        } catch (ArithmeticException e) {
            // Исключение деления на ноль
            e.printStackTrace(); // Вывод трассировки стека на консоль
            System.out.println("Ошибка: " + e.getMessage()); // Вывод сообщения об ошибке
            StackTraceElement[] stackTrace = e.getStackTrace(); // Получение трассировки стека
            // Обработка трассировки стека, например, запись в журнал
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println(stackTraceElement.toString());
            }
        }
    }
    public static int divide(int dividend, int divisor) {
        return dividend / divisor;
    }

}

