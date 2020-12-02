package mark;

import books.ContentTypes;
import books.Leaf;
import books.PageType;
import figures.Figures;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarkInstrumentTest {
    private Pen pen;
    private Leaf leaf;

    @Before
    public void set() {
        pen = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 15.4);
        leaf = new Leaf(PageType.CELL, 12);
    }

    @Test
    public void Write_WritingRecord_ThisRecordIsFound() {
        //WHEN
        pen.write(leaf.getFirstPage(), "some record");
        Leaf.Page.Content actualContent =  leaf.getFirstPage().new Content(false, ContentTypes.TEXT, "some record");
        //THEN
        assertTrue(leaf.getFirstPage().findSameContent(actualContent));
    }

    @Test
    public void Write_WritingSameRecord_SizeIs1() {
        //WHEN
        pen.write(leaf.getFirstPage(), "some record");
        pen.write(leaf.getFirstPage(), "some record");
        //THEN
        assertEquals(leaf.getFirstPage().getRecordsSize(), 1);
    }

    @Test
    public void Paint_PaintingRecord_ThisRecordIsFound() {
        //WHEN
        pen.paint(leaf.getFirstPage(), "some record");
        Leaf.Page.Content actualContent =  leaf.getFirstPage().new Content(false, ContentTypes.PICTURE, "some record");
        //THEN
        assertTrue(leaf.getFirstPage().findSameContent(actualContent));
    }

    @Test
    public void Paint_PaintingSameRecord_SizeIs1() {
        //WHEN
        pen.paint(leaf.getFirstPage(), "some record");
        pen.paint(leaf.getFirstPage(), "some record");
        //THEN
        assertEquals(leaf.getFirstPage().getRecordsSize(), 1);
    }

    @Test
    public void Draw_DrawingRecord_ThisRecordIsFound() {
        //WHEN
        pen.draw(leaf.getFirstPage(), Figures.PENTAGON);
        Leaf.Page.Content actualContent =  leaf.getFirstPage().new Content(false, ContentTypes.FIGURE, Figures.PENTAGON.toString());
        //THEN
        assertTrue(leaf.getFirstPage().findSameContent(actualContent));
    }

    @Test
    public void Draw_DrawingSameRecord_SizeIs1() {
        //WHEN
        pen.draw(leaf.getFirstPage(), Figures.PENTAGON);
        pen.draw(leaf.getFirstPage(), Figures.PENTAGON);
        //THEN
        assertEquals(leaf.getFirstPage().getRecordsSize(), 1);
    }
}