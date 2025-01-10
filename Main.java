import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSing();
        printColor();
        compareNumbers();
        boolean result = isSumInRange(5, 5); // Пример чисел
        System.out.println(result);
        checkNumber(-3); // Пример числа
        boolean result2 = isNegative(0); // Пример числа
        System.out.println(result2);
        printString("Azazello", 3); // Пример строки, которая должна напечататься 3 раза
        int year = 2024; // Пример года для проверки
        boolean isLeapYear = isLeapYear(year);
        System.out.println(year + "-" + isLeapYear);
        
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}; // задание 10

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else if (arr[i] == 1) {
                arr[i] = 0;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    
        System.out.println();
        
        int[] arr2 = new int[100]; // Задание 11
        
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1; 
        }

        for (int num : arr2) {
            System.out.print(num + " ");
        }
        
        System.out.println();
        
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // Задание 12

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2; 
            }
        }

        for (int num : arr3) {
            System.out.print(num + " ");
        }
        
        System.out.println();
        
        int n = 5; // Задание 13 (размер квадратного массива)
        int[][] arr4 = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr4[i][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
    
        int len = 5; // Задание 14
        int initialValue = 10; 

        int[] initializeArray = createInitializedArray(len, initialValue);
        
        System.out.println(Arrays.toString(initializeArray));
    }
    public static int[] createInitializedArray(int len, int initialValue) {    
            int[] newArray = new int[len];
            Arrays.fill(newArray, initialValue);
            return newArray;
        }
    
    public static void printThreeWords() { //задание 1
        System.out.println("Orange\nBanana\nApple");
            }
    
    public static void checkSumSing () { //задание 2
        int a = 5; 
        int b = -3; 

        int sum = a + b; 

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    
    public static void printColor() { //задание 3
        int value = 50; 

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    
    public static void compareNumbers() { //задание 4
        int a = 10; 
        int b = 20; 

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    
    public static boolean isSumInRange(int a, int b) { // задание 5
        int sum = a + b; 
        return sum >= 10 && sum <= 20; 
    }

    public static void checkNumber(int number) { // задание 6
        if (number >= 0) {
            System.out.println(number + " - положительное число");
        } else {
            System.out.println(number + " - отрицательное число");
        }
    }
    
    public static boolean isNegative(int number) { // задание 7
        return number < 0;
    }
    
    public static void printString(String text, int count) { //задание 8
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    
    public static boolean isLeapYear(int year) { // задание 9
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
