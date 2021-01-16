package books;

import mark.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PageTest {
    private Pencil pencil;
    private Leaf leaf;

    @Before
    public void set() {
        pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, true, "soft");
        leaf = new Leaf(PageType.CELL, 12);
    }
    @Test
    public void FindSameCont_PageHasSameRecord_True() {
        pencil.write(leaf.getFirstPage(), "some record");
        Leaf.Page.Content sameRecord =  leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "some record");
        assertTrue(leaf.getFirstPage().findSameContent(sameRecord));
    }

    @Test
    public void FindSameCont_PageHasNotSameRecord_False() {
        pencil.write(leaf.getFirstPage(), "some record");
        Leaf.Page.Content sameRecord =  leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "another record");
        assertFalse(leaf.getFirstPage().findSameContent(sameRecord));
    }

    @Test
    public void AddContent_AddingContentToEmptyPage_True() {
        Leaf.Page.Content sameRecord = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "some record");
        leaf.getSecondPage().addContent(sameRecord);
        assertTrue(leaf.getSecondPage().findSameContent(sameRecord));
    }

    @Test
    public void AddContent_AddingContentToFullPage_False() {
        Leaf.Page.Content sameRecord1 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "some record1");
        Leaf.Page.Content sameRecord2 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "some record2");
        Leaf smallLeaf = new Leaf(PageType.CELL, 1);
        smallLeaf.getSecondPage().addContent(sameRecord1);
        smallLeaf.getSecondPage().addContent(sameRecord2);
        assertFalse(smallLeaf.getSecondPage().findSameContent(sameRecord2));
    }

    @Test
    public void DeleteWipe_DeletingWipedContent_FalseWhenFindIt() {
        Leaf.Page.Content sameRecord = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "some record2");
        pencil.write(leaf.getSecondPage(), "some record1");
        pencil.write(leaf.getSecondPage(), "some record2");
        leaf.getSecondPage().deleteWipe(1);
        assertFalse(leaf.getSecondPage().findSameContent(sameRecord));
    }

    @Test
    public void DeleteWipe_DeletingNotWipedContent_TrueWhenFindIt() {
        Pen pen = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 15.4);
        Leaf.Page.Content sameRecord = leaf.getFirstPage().new Content(false, ContentTypes.TEXT, "some record2");
        pencil.write(leaf.getSecondPage(), "some record1");
        pen.write(leaf.getSecondPage(), "some record2");
        leaf.getSecondPage().deleteWipe(1);
        assertTrue(leaf.getSecondPage().findSameContent(sameRecord));
    }

    @Test
    public void Delete_CorrectDiapason_FalseWhenFindDeletedRecords() {
        Leaf.Page.Content record1 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record1");
        Leaf.Page.Content record2 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record2");
        Leaf.Page.Content record3 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record3");
        pencil.write(leaf.getFirstPage(), "record1");
        pencil.write(leaf.getFirstPage(), "record2");
        pencil.write(leaf.getFirstPage(), "record3");

        leaf.getFirstPage().delete(0, 2);
        assertFalse(leaf.getFirstPage().findSameContent(record1));
        assertFalse(leaf.getFirstPage().findSameContent(record2));
    }

    @Test
    public void Delete_FirstArgumentMoreThanSecond_NotThrowingException() {
        pencil.write(leaf.getFirstPage(), "record1");
        MyAssertions.assertDoesNotThrow(() -> {
            leaf.getFirstPage().delete(2, 1);
        });
    }

    @Test
    public void Delete_FirstArgumentLessThanZero_NotThrowingException() {
        pencil.write(leaf.getFirstPage(), "record1");
        MyAssertions.assertDoesNotThrow(() -> {
            leaf.getFirstPage().delete(-2, 1);
        });
    }

    @Test
    public void Delete_SizeLessThanSecondArgument_DeleteToSize() {
        Leaf.Page.Content record1 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record1");
        Leaf.Page.Content record2 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record2");
        Leaf.Page.Content record3 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record3");
        pencil.write(leaf.getFirstPage(), "record1");
        pencil.write(leaf.getFirstPage(), "record2");
        pencil.write(leaf.getFirstPage(), "record3");

        leaf.getFirstPage().delete(1, 5);
        assertFalse(leaf.getFirstPage().findSameContent(record2));
        assertFalse(leaf.getFirstPage().findSameContent(record3));
    }

    @Test
    public void Clone_CloningPage_NotEqualsPages() throws CloneNotSupportedException {
        Leaf.Page clonePage = leaf.getFirstPage().clone();
        assertNotEquals(leaf.getFirstPage(), clonePage);
    }


}