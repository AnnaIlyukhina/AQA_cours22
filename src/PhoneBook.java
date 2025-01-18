import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    // Хранит фамилии и соответствующие им списки телефонных номеров
    private Map<String, List<String>> phoneBook;

    // Конструктор
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String lastName, String phoneNumber) {
        // Получаем список номеров для данной фамилии
        List<String> numbers = phoneBook.getOrDefault(lastName, new ArrayList<>());
        // Добавляем новый номер в список
        numbers.add(phoneNumber);
        // Обновляем запись в справочнике
        phoneBook.put(lastName, numbers);
    }

    // Метод для поиска номеров по фамилии
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }

    // Метод для вывода всего справочника (для удобства)
    public void printAll() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println("Фамилия: " + entry.getKey() + ", Номера: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавление записей
        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Иванов", "789-012");
        phoneBook.add("Петров", "345-678");
        phoneBook.add("Сидоров", "901-234");

        // Поиск номеров по фамилии
        System.out.println("Номера для Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Номера для Петрова: " + phoneBook.get("Петров"));

        // Вывод всех записей
        System.out.println("\nВсе записи в справочнике:");
        phoneBook.printAll();
    }
}
