package mark;

import books.ContentTypes;
import books.Leaf;
import figures.Figures;

abstract class MarkInstrument {
    boolean canWipe;
    String color;
    String material;
    int length;
    public MarkInstrument(String color, String material, int length, boolean canWipe) {
        this.color = color;
        this.material = material;
        this.length = length;
        this.canWipe = canWipe;
    }
//    public void mark() {
//        System.out.println("Marking");
//    }
    public void write(Leaf.Page page, String content) {
        Leaf.Page.Content tempcont = new page.Content(canWipe, ContentTypes.TEXT, content);
        page.addContent(tempcont);
    }
    public void paint(Leaf.Page page, String content) {
        Leaf.Page.Content tempcont = new Leaf.Page.Content(canWipe, ContentTypes.PICTURE, content);
        page.addContent(tempcont);
    }
    public void draw(Leaf.Page page, Figures content) {
        Leaf.Page.Content tempcont = new Leaf.Page.Content(canWipe, ContentTypes.FIGURE, content.toString());
        page.addContent(tempcont);
    }
    void show() {
        System.out.println("Color: " + color);
        System.out.println("Material: " + material);
    }
}
