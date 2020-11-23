package books;

import java.util.ArrayList;
import java.util.Iterator;

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
            for (int i = 0; i < records.size(); i++) {
                System.out.println("Content: " + i);
                records.get(i).show();
            }
        }

        public class Content {
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
                if (canWipe) {
                    System.out.println("Wiped");
                } else {
                    System.out.println("Not wiped");
                }
                System.out.println(content);

            }
        }

    }
}
