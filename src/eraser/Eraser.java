package eraser;

import books.Leaf;

public class Eraser {
    private int size;
    public Eraser(int size) {
        if (size < 1 || size > 100) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }
    public void wipe(Leaf.Page page, int id) {
        page.deleteWipe(id);
    }
    public void show() {
        System.out.println("Eraser:");
        System.out.println("Size: "+size);
    }
}
