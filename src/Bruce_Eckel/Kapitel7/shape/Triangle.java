package Bruce_Eckel.Kapitel7.shape;

public class Triangle extends Shape {

    public Triangle(int i) {
        super(i);
        System.out.println("Draw a triangle");
    }

    @Override
    public void dispose() {
        System.out.println("Erasing triangle");
        super.dispose();
    }
}
