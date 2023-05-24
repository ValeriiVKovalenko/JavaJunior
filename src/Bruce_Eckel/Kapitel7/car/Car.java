package Bruce_Eckel.Kapitel7.car;

public class Car {

    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door left = new Door();
    public Door right = new Door();

    public Car() {
        for (int i = 0; i < 4; i++) {
            wheel[i] = new Wheel();
        }
    }

    public static void main(String[] args) {

        Car car = new Car();
        car.left.window.rolldown();
        car.wheel[0].inflate(82);
        car.engine.service();
    }
}
