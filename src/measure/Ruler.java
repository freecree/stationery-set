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

    @Override
    public boolean equals(Object o) {
        System.out.println("in hash equals()");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ruler ruler = (Ruler) o;
        return length == ruler.length &&
                tempLength == ruler.tempLength &&
                Objects.equals(material, ruler.material);
    }

    @Override
    public int hashCode() {
        System.out.println("in hash code()");
        return Objects.hash(length, material, tempLength);
    }

    public int getLength() {
        return length;
    }
    public String getMaterial() {
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
