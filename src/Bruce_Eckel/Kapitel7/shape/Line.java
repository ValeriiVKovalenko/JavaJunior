package Bruce_Eckel.Kapitel7.shape;

public class Line extends Shape {

    private int start;
    private int end;

    public Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Рисуем линию Line: " + start + ", " + end);
    }

    @Override
    public void dispose() {
        System.out.println("Стираем линию Line: " + start + ", " + end);
        super.dispose();
    }
}
