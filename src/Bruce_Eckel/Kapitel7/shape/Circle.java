package Bruce_Eckel.Kapitel7.shape;

public class Circle extends Shape {

    public Circle(int i) {
        super(i);
        System.out.println("Draws a circle");
    }

    @Override
    public void dispose() {
        System.out.println("Erasing the circle");
        super.dispose();
    }
}
