package mark;

public class Pencil extends MarkInstrument {
    private String softness;  //мягкость

    public Pencil(String color, String material, int length, String softness) {
        super(color, material, length);
        this.softness = softness;
    }

    public void show() {
        System.out.println("Pen");
        super.show();
        System.out.println("Length: " + length);
        System.out.println("Softness: " + softness);
    }
};
