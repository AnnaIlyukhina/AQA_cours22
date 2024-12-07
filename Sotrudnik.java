public class Sotrudnik {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private String salary;
    private int age;

    public Sotrudnik(String fio, String position, String email, String phone, String salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fio);
        System.out.println("должность: " + position);
        System.out.println("email: " + email);
        System.out.println("телефон: " + phone);
        System.out.println("зарплата: " + salary);
        System.out.println("возраст: " + age);
    }

    public static void main(String[] args) {
        Sotrudnik employee1 = new Sotrudnik("Иванов Иван Иванович", "офис-менеджер", "ivanov@rambler.ru", "+7(999)111-11-11", "50000 руб.", 30);
        
        employee1.printInfo();
    }
}
