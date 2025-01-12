public class Main {
    public static void main(String[] args) {
        ArrayProcessor processor = new ArrayProcessor();

        // Корректный массив
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Некорректный массив с текстом вместо числа
        String[][] invalidDataArray = {
                {"1", "2", "three", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Массив неправильного размера
        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"}
        };

        // Обработка корректного массива
        try {
            int sum = processor.processArray(validArray); // Корректный вызов
            System.out.println("Сумма элементов корректного массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        // Обработка некорректного массива с текстом
        try {
            int sum = processor.processArray(invalidDataArray); // Некорректный вызов
            System.out.println("Сумма элементов некорректного массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        // Обработка некорректного размера массива
        try {
            int sum = processor.processArray(invalidSizeArray); // Некорректный вызов
            System.out.println("Сумма элементов некорректного размера массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}