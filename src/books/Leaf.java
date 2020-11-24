package books;

import java.util.ArrayList;

public class Leaf implements Cloneable {
    private int pageCapacity;
    private Page page1 = new Page();
    private Page page2 = new Page();

    public Leaf() {
        pageCapacity = 12;
    }
    public Leaf(PageType type, int pageCapacity) {
        this.pageCapacity = pageCapacity;
        page1 = new Page(type);
        page2 = new Page(type);
    }
    public void delete(int a1, int a2) {
        page1.delete(a1, a2);
        page2.delete(a1, a2);
    }
    public int getPageCapacity() {
        return pageCapacity;
    }
    public Page getFirstPage() {
        return page1;
    }
    public Page getSecondPage() {
        return page2;
    }
    public void setPageCapacity(int pageCapacity) {
        this.pageCapacity = pageCapacity;
    }

    public void showRecords() {
        System.out.println("Page 1:");
        page1.showRecords();
        System.out.println("Page 2:");
        page2.showRecords();
    }

    @Override
    public Leaf clone() throws CloneNotSupportedException {
        Leaf leaf = (Leaf) super.clone();
        leaf.page1 = (Page) page1.clone();
        leaf.page2 = (Page) page2.clone();
        return leaf;
    }

    public class Page implements Cloneable {
        private ArrayList<Content> records = new ArrayList<Content>();
        private PageType type;

        Page() {
            this.type = PageType.EMPTY;
            records = new ArrayList<>(12);
        }

        Page(PageType type) {
            this.type = type;
            records = new ArrayList<>(pageCapacity);
        }

        public int getPageCapacity() {
            return pageCapacity;
        }

        public PageType getType() {
            return type;
        }
        public void setPageCapacity(int pageCapacity) {
            Leaf.this.pageCapacity = pageCapacity;
        }

        public void addContent(Content content) {
            records.add(content);
        }

        public void delete(int id) {
            records.remove(id);
        }

//        void delete(int a1, int a2) {
//            //Iterator<Content> iter = records.iterator();
//            System.out.println("In delete(): "+ a1+" "+a2+" "+records.size());
//            if (a1 <= records.size() && records.size() < a2) {
//                a2 = records.size();
//            }
//            if (a1 <= a2 && a2 <= records.size()) {
//                for (int i = a1; i < a2; i++) {
//                    records.remove(a1);
//                }
//            }
//        }
        void delete(int a1, int a2) {
            try {
                if (a1 > a2 || a1 < 0) {
                    throw new IllegalArgumentException("Negative argument or a1 > a2");
                }
                try {
                    if (records.size() < a2) {
                        throw new IllegalArgumentException("a2 > size of records");
                    }
                } catch (Exception ex) {
                    a2 = records.size();
                    System.out.println("Exception in Leaf.Page.delete():");
                    System.out.println(ex.getMessage());
                } finally {
                    if (a1 <= a2 && a2 <= records.size()) {
                        for (int i = a1; i < a2; i++) {
                            records.remove(a1);
                        }
                    }
                    System.out.println("Records deleted successfully");
                }
            } catch (Exception ex) {
                System.out.println("Exception in Leaf.Page.delete():");
                System.out.println(ex.getMessage());
            }
        }

        public void showRecords() {
            for (int i = 0; i < records.size(); i++) {
                System.out.println("Content: " + i);
                records.get(i).show();
            }
        }
        @Override
        public Page clone() throws CloneNotSupportedException {
            Page page = (Page) super.clone();
            page.records = new ArrayList<Content>(records);
            return page;
        }
        public class Content implements Cloneable {
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
            public Content clone() throws CloneNotSupportedException {
                return (Content) super.clone();
            }
        }

    }
}
