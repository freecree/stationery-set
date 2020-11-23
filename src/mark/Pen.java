package mark;

public class Pen extends MarkInstrument {
    private double line_thickness;  //жирность
    private double distance;  //км

    public Pen(String color, String material, int length, boolean canWipe, double line_thickness, double distance) {
        super(color, material, length, canWipe);
        this.line_thickness = line_thickness;
        this.distance = distance;
    }

    public void show() {
        System.out.println("Pen");
        super.show();
        System.out.println("Length: " + length);
        System.out.println("line_thickness: " + line_thickness);
        System.out.println("Distance: " + distance);
    }
}
