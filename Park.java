public class Park {
    
    public class Attraction {
        private String name;
        private String workingHours;
        private double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printInfo() {
            System.out.println(name);
            System.out.println("время работы: " + workingHours);
            System.out.println("стоимость билета: " + cost + " руб.");
        }
    }

    public static void main(String[] args) {
        Park park = new Park();

        Attraction attraction1 = park.new Attraction("\"Ромашка\"", "10:00 - 18:00", 15.0);
        Attraction attraction2 = park.new Attraction("\"Колесо обозрения\"", "11:00 - 20:00", 10.0);

        System.out.println("В парке действуют аттракционы:");
        attraction1.printInfo();
        System.out.println();
        attraction2.printInfo();
    }
}
