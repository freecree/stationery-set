package books;

import java.util.ArrayList;

public class Book
{
    private int amountPages;
    private BookType bookType;
    private PageType pageType;
    ArrayList<Page> pages = new ArrayList<Page>();
    public Book(int amountPages, BookType bType, PageType pType) {
        this.amountPages = amountPages;
        bookType = bType;
        pageType = pType;
    }
    public void open() {
        System.out.println("Book opened on " + BookMark.getPageNumber() );
    }
    public static class BookMark {
        static int pageNumber;
        public BookMark() {
            pageNumber = 0;
        }
        void setPageNumber(int n) {
            pageNumber = n;
        }
        static int getPageNumber() {
            return pageNumber;
        }
    }


}