package measure;

import java.util.Objects;

public class Ruler {
    private int length; // in mm
    private String material;
    private int tempLength;
    public Ruler(int length, String material) {
        tempLength = 0;
        this.length = length;
        this.material = material;
    }

    int getLength() {
        return length;
    }
    String getMaterial() {
        return material;
    }
    public void measure(int length) {
        tempLength = length;
    }
    public int getMeasuring() {
        return tempLength;
    }
    public void show() {
        System.out.println("Ruler");
        System.out.println("Length: " + length + "mm");
        System.out.println("material: " + material);
    }
}
