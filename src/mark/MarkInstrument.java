package mark;

import books.ContentTypes;
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
    public void write(Page page, String content) {
        Page.Content tempcont = new Page.Content(canWipe, ContentTypes.TEXT, content);
        page.addContent(tempcont);
    }
    public void paint(Page page, String content) {
        Page.Content tempcont = new Page.Content(canWipe, ContentTypes.PICTURE, content);
        page.addContent(tempcont);
    }
    public void draw(Page page, Figures content) {
        Page.Content tempcont = new Page.Content(canWipe, ContentTypes.FIGURE, content.toString());
        page.addContent(tempcont);
    }
    void show() {
        System.out.println("Color: " + color);
        System.out.println("Material: " + material);
    }
}
