package nested_classes.static_nested_class;

public class Test {
    public static void main(String[] args) {
        Car.Engine engine1 = new Car.Engine(250);
        Car car = new Car("red", 4, engine1);
    }
}
