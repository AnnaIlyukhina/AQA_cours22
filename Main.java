// Базовый класс Животное
class Animal {
    private static int animalCount = 0; // Счетчик животных

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " метров.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " метров.");
    }
}

// Класс Собака, наследуется от Животное
class Dog extends Animal {
    private static int dogCount = 0; // Счетчик собак

    public Dog() {
        super(); // Вызов конструктора базового класса
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " метров.");
        } else {
            System.out.println("Собака не может пробежать больше 500 метров.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " метров.");
        } else {
            System.out.println("Собака не может проплыть больше 10 метров.");
        }
    }
}

// Класс Кот, наследуется от Животное
class Cat extends Animal {
    private static int catCount = 0; // Счетчик котов
    private Bowl bowl; // Миска с едой
    private boolean isFull; // Поле сытости
    public Cat(Bowl bowl) {
        super(); // Вызов конструктора базового класса
        catCount++;
        this.bowl = bowl; // Инициализация миски
        this.isFull = false; // Кот изначально голоден
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " метров.");
        } else {
            System.out.println("Кот не может пробежать больше 200 метров.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public void eat(int amount) { // Проверяем, достаточно ли еды в миске для кормления кота
        if (bowl.getFoodAmount() < amount)
        {
            System.out.println("Недостаточно еды в миске. Кот не может поесть");
            return; // Кот не ест, если еды не доcтаточно
        }
        int eaten = bowl.eat(amount); //Кот ест из миски
        if (eaten > 0) {  // Если кот поел
            isFull = true; // Устанавливаем сытость в true
            System.out.println("Кот теперь сыт");
        }
    }
    public boolean isFull() {
        return isFull; // Метод для проверки сытости кота
    }
}
// Класс Миска
class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }

    public void feed(int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть положительным.");
            return;
        }

        foodAmount += amount;
        System.out.println("В миске теперь " + foodAmount + " единиц еды.");
    }

    public int eat(int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть положительным.");
            return 0;
        }

        if (amount > foodAmount) {
            System.out.println("Недостаточно еды в миске. Кот съел только " + foodAmount + " единиц.");
            int eaten = foodAmount;
            foodAmount = 0; // Миска опустошена
            return eaten;
        } else {
            foodAmount -= amount;
            System.out.println("Кот съел " + amount + " единиц еды. В миске осталось " + foodAmount + " единиц.");
            return amount;
        }
    }
    public int getFoodAmount() {  // Метод для получения количества еды в миске
        return foodAmount;
    }

    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Количество добавляемой еды должно быть положительным");
            return;
        }

    foodAmount += amount;
    System.out.println("Добавлено " + amount + " единиц еды. В миске теперь " + foodAmount + " единиц.");
    }
}

// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        Bowl catBowl = new Bowl(50); //Создаем миску с 50 единицами еды
        Dog dog1 = new Dog();
        Cat cat1 = new Cat(catBowl);

        Cat[] cats = new Cat[5]; //Создаем массив котов
        for (int i = 0; i < cats.length; i++)
        {
            cats[i] = new Cat(catBowl); // Каждому коту передаем одну  и ту же миску
        }

        dog1.run(300); // Собака пробежала 300 метров.
        dog1.run(550); // Собака не может пробежать больше 500 метров.
        dog1.swim(5); // Собака проплыла 5 метров.
        dog1.swim(11); // Собака не может проплыть больше 10 метров.

        cat1.run(150); // Кот пробежал 150 метров.
        cat1.run(250); // Кот не может пробежать больше 200 метров.
        cat1.swim(5);  // Кот не умеет плавать.

        // Проверяем сытость кота перед кормлением
        System.out.println("Кот сыт? " + cat1.isFull());

        // Кормим кота
        cat1.eat(25); // Недостаточно еды в миске. Кот не может поесть.
        cat1.eat(5); // Кот съел 5 единиц еды
        System.out.println("Кот сыт? " + cat1.isFull()); // Проверяем сытость после первого кормления
        cat1.eat(10); // Кот съел 10 единиц еды
        System.out.println("Кот сыт? " + cat1.isFull()); // Проверяем сытость после второго кормления
        cat1.eat(10); // Недостаточно еды в миске. Кот не может поесть.

        // Добавляем еду в миску
        catBowl.addFood(30); // Добавляем 30 единиц

        // Коты пытаются покушать
        for (int i = 0; i < cats.length; i++)
        {
            System.out.println("Кот " + i + 1 + " пытается поесть:");
            cats[i].eat(15); // Каждый кот пытается съесть 15 единиц еды
            System.out.println("Кот " + (i + 1) + " сыт?" + cats[i].isFull());
            System.out.println();
        }

        // Выводим общую информацию о сытости всех котов
        System.out.println("Информация о сытости всех котов из массива:");
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сыт? " + cats[i].isFull());
        }

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}

