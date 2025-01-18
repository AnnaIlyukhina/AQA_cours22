import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UniqueAnimalsCounter {
    public static void main(String[] args) {
        // Создание массива животных с повторениями
        String[] animalsArray = {
                "Dog", "Cat", "Elephant", "Dog", "Tiger",
                "Cat", "Lion", "Elephant", "Giraffe", "Cat",
                "Dog", "Zebra", "Tiger", "Bear", "Lion",
                "Fox", "Elephant", "Giraffe", "Bear", "Zebra"
        };

        // Используем HashMap для подсчета уникальных животных и их частоты
        Map<String, Integer> animalCountMap = new HashMap<>();

        // Подсчет частоты каждого животного
        for (String animal : animalsArray) {
            animalCountMap.put(animal, animalCountMap.getOrDefault(animal, 0) + 1);
        }

        // Получение уникальных животных
        Set<String> uniqueAnimals = animalCountMap.keySet();

        // Вывод уникальных животных и их частоты
        System.out.println("Уникальные животные и их частота:");
        for (String uniqueAnimal : uniqueAnimals) {
            System.out.println(uniqueAnimal + ": " + animalCountMap.get(uniqueAnimal));
        }
    }
}