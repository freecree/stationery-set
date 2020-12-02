package cut;

import books.Leaf;
import books.PageType;
import mark.InstrMaterials;
import mark.Pencil;
import mark.PencilColors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScissorsTest {

    @Test
    public void Cut_LeavesCutting_TwoCutLeaves() {
        Knife knife = new Knife();
        Leaf leaf = new Leaf(PageType.CELL, 6);
        Pencil pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, true, "soft");
        for (int i = 1; i < 7; i++) {
            String s1 = "some record"+i+" on first page";
            String s2 = "some record"+i+" on second page";
            pencil.paint(leaf.getFirstPage(), s1);
            pencil.paint(leaf.getSecondPage(), s2);
        }

        Leaf cutLeaf = knife.cut(leaf, 0.3);

        Leaf mainLeafPart = new Leaf(PageType.CELL, 4);
        Leaf cutLeafPart = new Leaf(PageType.CELL, 2);
        for (int i = 1; i < 5; i++) {
            String s1 = "some record"+i+" on first page";
            String s2 = "some record"+i+" on second page";
            pencil.paint(mainLeafPart.getFirstPage(), s1);
            pencil.paint(mainLeafPart.getSecondPage(), s2);
        }
        for (int i = 5; i < 7; i++) {
            String s1 = "some record"+i+" on first page";
            String s2 = "some record"+i+" on second page";
            pencil.paint(cutLeafPart.getFirstPage(), s1);
            pencil.paint(cutLeafPart.getSecondPage(), s2);
        }
        assertEquals(leaf.getFirstPage().getContent(), mainLeafPart.getFirstPage().getContent());
        assertEquals(leaf.getSecondPage().getContent(), mainLeafPart.getSecondPage().getContent());

        assertEquals(cutLeaf.getFirstPage().getContent(), cutLeafPart.getFirstPage().getContent());
        assertEquals(cutLeaf.getSecondPage().getContent(), cutLeafPart.getSecondPage().getContent());
    }
}