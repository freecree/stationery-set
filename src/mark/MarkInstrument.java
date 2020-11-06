package mark;

abstract class MarkInstrument {
    String color;
    String material;
    int length;
    public MarkInstrument(String color, String material, int length) {
        this.color = color;
        this.material = material;
        this.length = length;
    }
    public void mark() {
        System.out.println("Marking");
    }
    void show() {
        System.out.println("Color: " + color);
        System.out.println("Material: " + material);
    }
}
