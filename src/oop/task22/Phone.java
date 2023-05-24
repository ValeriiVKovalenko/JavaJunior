package oop.task22;

public class Phone {

    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
        Phone phone = new Phone("+3972233122", "Samsung S21");
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {}

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }

    public void receiveCall(String name) {
        System.out.printf("Звонит %s%n", name);
    }

    public void receiveCall(String name, String number) {
        System.out.printf("Звонит %s(%s)%n", name, number);
    }

    public void sendMessage(String... numbers) {
        for (String number : numbers) {
            System.out.println("Отправлено сообщение на номер: " + number);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }
}
