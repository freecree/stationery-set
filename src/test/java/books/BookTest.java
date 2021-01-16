package books;

import mark.InstrMaterials;
import mark.Pencil;
import mark.PencilColors;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.*;

public class BookTest {
    private ArrayList<Leaf> leaves = new ArrayList<Leaf>();
    private Book book;
    private Pencil pencil;

    @Before
    public void setBook() {
        pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, true, "soft");
        book = new Book(4, BookType.NOTEPAD, PageType.CELL, 12);
        pencil.paint(book.getPage(1),"Leaf1 page1 record1");
        pencil.paint(book.getPage(2),"Leaf1 page2 record1");

        pencil.paint(book.getPage(3),"Leaf2 page1 record1");
        pencil.paint(book.getPage(4),"Leaf2 page2 record1");

    }
    @Test
    public void getPage_GettingExistingPage_CorrectPage() {
        Leaf.Page expectedPage1 = book.getPage(1);
        Leaf leaf = new Leaf(PageType.CELL, 12);
        Leaf.Page actualPage1 = leaf.new Page();
        pencil.paint(actualPage1,"Leaf1 page1 record1");
        assertEquals(expectedPage1.getContent(), actualPage1.getContent());
    }

    @Test
    public void getLeaf_GettingExistingLeaf_CorrectLeaf() {
        Leaf expectedLeaf1 = book.getLeaf(1);
        Leaf expectedLeaf2 = book.getLeaf(2);

        Leaf actualLeaf1 = new Leaf(PageType.CELL, 12);
        Leaf actualLeaf2 = new Leaf(PageType.CELL, 12);
        pencil.paint(actualLeaf1.getFirstPage(), "Leaf1 page1 record1");
        pencil.paint(actualLeaf1.getSecondPage(), "Leaf1 page2 record1");

        pencil.paint(actualLeaf2.getFirstPage(), "Leaf2 page1 record1");
        pencil.paint(actualLeaf2.getSecondPage(), "Leaf2 page2 record1");
        assertEquals(expectedLeaf1.getFirstPage().getContent(), actualLeaf1.getFirstPage().getContent());
        assertEquals(expectedLeaf1.getSecondPage().getContent(), actualLeaf1.getSecondPage().getContent());

        assertEquals(expectedLeaf2.getFirstPage().getContent(), actualLeaf2.getFirstPage().getContent());
        assertEquals(expectedLeaf2.getSecondPage().getContent(), actualLeaf2.getSecondPage().getContent());

    }
}