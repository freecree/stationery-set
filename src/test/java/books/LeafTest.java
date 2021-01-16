package books;

import mark.InstrMaterials;
import mark.Pencil;
import mark.PencilColors;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class LeafTest {
    private Pencil pencil;
    private Leaf expectedLeaf;

    @Before
    public void set() {
        pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, true, "soft");
        expectedLeaf = new Leaf(PageType.CELL, 12);
        pencil.paint(expectedLeaf.getFirstPage(),"First page");
        pencil.paint(expectedLeaf.getSecondPage(),"Second page");
    }

    @Test
    public void GetFirstPage_GettingFirstPageFromLeaf_CorrespondingPage() {
        Leaf actualLeaf = new Leaf(PageType.CELL, 12);
        Leaf.Page actualPage = actualLeaf.new Page();
        pencil.paint(actualPage,"First page");

        assertEquals(expectedLeaf.getFirstPage().getContent(), actualPage.getContent());
    }

    @Test
    public void GetFirstPage_GettingNotInitializedFirstPageFromLeaf_NotNull() {
        Leaf expected = new Leaf();
        assertNotNull(expected.getFirstPage());
    }

    @Test
    public void GetSecondPage_GettingNotInitializedSecondPageFromLeaf_NotNull() {
        Leaf expected = new Leaf();
        assertNotNull(expected.getSecondPage());
    }

    @Test
    public void GetSecondPage_GettingFirstPageFromLeaf_CorrespondingPage() {
        Leaf actualLeaf = new Leaf(PageType.CELL, 12);
        Leaf.Page actualPage = actualLeaf.new Page();
        pencil.paint(actualPage,"Second page");

        assertEquals(expectedLeaf.getSecondPage().getContent(), actualPage.getContent());
    }

    @Test
    public void Clone_CloningLeaf_NotEqualsLeaves() throws CloneNotSupportedException {
        Leaf cloneLeaf = expectedLeaf.clone();
        assertNotEquals(expectedLeaf, cloneLeaf);
    }


}