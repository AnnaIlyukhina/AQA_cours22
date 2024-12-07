public class Person {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Сотрудник: " + fio);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }

    public static void main(String[] args) {
        Person [] persArray = new Person [5];
            persArray [0] = new Person ("Иванов Иван", "директор", "ivanov@mail.ru", "87894561245", 300000, 30);
            persArray [1] = new Person ("Петров Василий", "заместитель", "petrov@mail.ru", "81597538458", 150000, 25);
            persArray [2] = new Person ("Сидорова Лариса", "бухгалтер", "sidorova@mail.ru", "84561237856", 100000, 50);
            persArray [3] = new Person ("Плюшкин Алексей", "менеджер", "plyushkin@mail.ru", "89638527452", 80000, 35);
            persArray [4] = new Person ("Орлова Ксения", "секретарь", "orlova@mail.ru", "87418529652", 50000, 18);

        for (Person emp : persArray) {
            emp.printInfo();
            System.out.println();
        }
    }
}
