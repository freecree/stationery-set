package books;

public class Leaf {
    //private int pageCapacity;
    //private PageType type;
    private Page page1 = new Page();
    private Page page2 = new Page();

    public Leaf() {
        //type = PageType.EMPTY;
        //pageCapacity = 12;
    }
    public Leaf(PageType type, int pageCapacity) {
        //this.pageCapacity = pageCapacity;
        page1 = new Page(type, pageCapacity);
        page2 = new Page(type, pageCapacity);
    }
    public void delete(int a1, int a2) {
        page1.delete(a1, a2);
        page2.delete(a1, a2);
    }
//    public int getPageCapacity() {
//        return pageCapacity;
//    }
//    public PageType getType() {
//        return type;
//    }
    public Page getFirstPage() {
        return page1;
    }
    public Page getSecondPage() {
        return page2;
    }

//    public void setPageCapacity(int pageCapacity) {
//        this.pageCapacity = pageCapacity;
//    }

    public void showRecords() {
        System.out.println("Page 1:");
        page1.showRecords();
        System.out.println("Page 2:");
        page2.showRecords();
    }
//    public void addContent(int n) {
//        if(n == 1) {
//            page1.
//        }
//    }


}
