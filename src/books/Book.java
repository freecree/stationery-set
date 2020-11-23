package books;

import java.util.ArrayList;

public class Book
{
    private int amountLeaves;
    private BookType bookType;
    //ArrayList<Page> pages = new ArrayList<Page>();
    ArrayList<Leaf> leaves = new ArrayList<Leaf>();
    public Book(int amountLeaves, BookType bType, PageType pType, int pageCapacity) {
        this.amountLeaves = amountLeaves;
        bookType = bType;
        for (int i = 0; i < amountLeaves; i++) {
            leaves.add(new Leaf(pType, pageCapacity));
        }
    }
    public void open(int pageNum) {
        System.out.println("Book opened on " + pageNum );
    }
    public Page getPage(int n) {
        //try {
            if(n%2 != 0) {
                return leaves.get((n-1)/2).getFirstPage();
            } else {
                return leaves.get((n-1)/2).getSecondPage();
            }
//        } catch (Exception ex) {
//            return new Page();
//        }

    }
    public void showRecords() {
        for (int i = 0; i < amountLeaves; i++) {
            System.out.println("leave "+i);
            leaves.get(i).showRecords();
        }
    }
}
//    public class BookMark {
//        int currentPageNumber;
//        public BookMark() {
//            currentPageNumber = 0;
//        }
//        void put(int n) {
//            currentPageNumber = n;
//        }
//        int open() {
//            return currentPageNumber;
//        }
//    }