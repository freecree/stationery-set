package books;

import java.util.ArrayList;

public class Book
{
    private int amountLeaves;
    private BookType bookType;
    private ArrayList<Leaf> leaves = new ArrayList<Leaf>();
    public Book(int amountLeaves, BookType bType, PageType pType, int pageCapacity) {
        this.amountLeaves = amountLeaves;
        bookType = bType;
        for (int i = 0; i < amountLeaves; i++) {
            leaves.add(new Leaf(pType, pageCapacity));
        }
    }
    public Leaf.Page getPage(int n) {
        if(n%2 != 0) {
            return leaves.get((n-1)/2).getFirstPage();
        } else {
            return leaves.get((n-1)/2).getSecondPage();
        }
    }
    public Leaf getLeaf(int n) {
        return leaves.get(n-1);
    }
    public void showRecords() {
        System.out.println(bookType+":");
        for (int i = 0; i < amountLeaves; i++) {
            System.out.println("leaf "+(i+1));
            leaves.get(i).showRecords();
        }
    }
}
