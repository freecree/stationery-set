package books;

import java.util.ArrayList;
import java.util.Iterator;

public class Page {
    private int pageCapacity = 10;
    private ArrayList<Content> records = new ArrayList<Content>();
    private PageType type;
    Page() {
        this.type = PageType.EMPTY;
        records = new ArrayList<>(12);
    }
    Page(PageType type, int pageCapacity) {
        this.type = type;
        this.pageCapacity = pageCapacity;

        records = new ArrayList<>(pageCapacity);
    }
    public int getPageCapacity() {
        return pageCapacity;
    }
    public PageType getType() {
        return type;
    }

    public void setPageCapacity(int pageCapacity) {
        this.pageCapacity = pageCapacity;
    }
    public void addContent(Content content) {
        records.add(content);
    }
    public void delete(int id) {
        records.remove(id);
    }
    public void delete(int a1, int a2) {
        Iterator<Content> iter = records.iterator();
        for (int i = a1; i < a2; i++) {
            if (records.get(i) != null) {
                records.remove(i);
            }
//            try {
//
//            } catch (Exception ex) {
//                ex.getMessage();
//                System.out.println("Catched!!! "+ i);
//            }
        }
    }
    public void showRecords() {
        for ( int i = 0; i < records.size(); i++) {
            System.out.println("Content: " + i);
            records.get(i).show();
        }
    }

    public static class Content {
        private boolean canWipe;
        private ContentTypes contentType;
        private String content;

        public Content(boolean canWipe, ContentTypes contentType, String content) {
            this.canWipe = canWipe;
            this.contentType = contentType;
            this.content = content;
        }
        public boolean getCanWipe() {
            return canWipe;
        }
        public ContentTypes getContentType() {
            return contentType;
        }
        public String getContent() {
            return content;
        }
        void show() {
            System.out.println(contentType);
            if(canWipe) {
                System.out.println("Wiped");
            } else {
                System.out.println("Not wiped");
            }
            System.out.println(content);

        }
    }


}
