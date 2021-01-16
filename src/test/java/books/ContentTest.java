package books;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContentTest {

    @Test
    public void Clone_CloningPage_NotEqualPages() throws CloneNotSupportedException {
        Leaf leaf = new Leaf(PageType.CELL, 12);
        Leaf.Page.Content record = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record");
        assertNotSame(record, record.clone());
    }

    @Test
    public void Equals_ComparingSameContentObjects_Equal() throws CloneNotSupportedException {
        Leaf leaf = new Leaf(PageType.CELL, 12);
        Leaf.Page.Content record1 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record");
        Leaf.Page.Content record2 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record");
        assertEquals(record1, record2);
    }

    @Test
    public void Equals_ComparingNotSameContentObjects_NotEqual() throws CloneNotSupportedException {
        Leaf leaf = new Leaf(PageType.CELL, 12);
        Leaf.Page.Content record1 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record");
        Leaf.Page.Content record2 = leaf.getFirstPage().new Content(true, ContentTypes.TEXT, "record1");
        assertNotEquals(record1, record2);
    }


}
