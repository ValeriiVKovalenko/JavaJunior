package nested_classes.static_nested_class;

import java.util.Objects;

public class Car {

    private String color;
    private int doorCount;
    private Engine engine;
    private static int count;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    public static class Engine {
        public int horsePower;
        public void say() {

        }
        @Override
        public String toString() {
            return "My engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }
    }

    @Override
    public String toString() {
        return "My car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return doorCount == car.doorCount && Objects.equals(color, car.color) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, doorCount, engine);
    }
}
