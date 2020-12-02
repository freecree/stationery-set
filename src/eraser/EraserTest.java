package eraser;

import books.ContentTypes;
import books.Leaf;
import books.PageType;
import mark.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EraserTest {
    private Eraser eraser;
    private Leaf leaf;
    private Pen pen;
    private Pencil pencil;

    @Before
    public void set() {
        pen = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 15.4);
        pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, true, "soft");
        eraser = new Eraser(7);
        leaf = new Leaf(PageType.CELL, 12);
    }

    @Test
    public void Wipe_DeletingWipedContent_FalseWhenFindIt() {
        pencil.write(leaf.getFirstPage(), "Some record1");
        pencil.write(leaf.getFirstPage(), "Some record2");
        Leaf.Page.Content sameRecord = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "Some record2");
        eraser.wipe(leaf.getFirstPage(), 1);
        assertFalse(leaf.getFirstPage().findSameContent(sameRecord));
    }

    @Test
    public void Wipe_DeletingNotWipedContent_TrueWhenFindIt() {
        pen.write(leaf.getFirstPage(), "Some record1");
        pen.write(leaf.getFirstPage(), "Some record2");
        Leaf.Page.Content sameRecord = leaf.getFirstPage().new Content(false, ContentTypes.TEXT, "Some record2");
        eraser.wipe(leaf.getFirstPage(), 1);
        assertTrue(leaf.getFirstPage().findSameContent(sameRecord));
    }
}