public class ArrayProcessor {

    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4x4");
            }
        }

        int sum = 0;

        // Проход по элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Преобразование элемента в int и добавление к сумме
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если преобразование не удалось, выбрасываем исключение с детализацией
                    throw new MyArrayDataException("Ошибка преобразования в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }
}
