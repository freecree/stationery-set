package mark;

import books.ContentTypes;
import books.Leaf;
import figures.Figures;

abstract class MarkInstrument {
    private boolean canWipe;
    private String color;
    private String material;
    int length;
    MarkInstrument(String color, String material, int length, boolean canWipe) {
        this.color = color;
        this.material = material;
        this.length = length;
        this.canWipe = canWipe;
    }
    public void write(Leaf.Page page, String content) {
        Leaf.Page.Content tempCont =  page.new Content(canWipe, ContentTypes.TEXT, content);
        if(!page.findSameContent(tempCont)) {
            page.addContent(tempCont);
        }

    }
    public void paint(Leaf.Page page, String content) {
        Leaf.Page.Content tempCont =  page.new Content(canWipe, ContentTypes.PICTURE, content);
        if(!page.findSameContent(tempCont)) {
            page.addContent(tempCont);
        }
    }
    public void draw(Leaf.Page page, Figures content) {
        Leaf.Page.Content tempCont =  page.new Content(canWipe, ContentTypes.FIGURE, content.toString());
        if(!page.findSameContent(tempCont)) {
            page.addContent(tempCont);
        }
    }
    void show() {
        System.out.println("Color: " + color);
        System.out.println("Material: " + material);
    }
}
