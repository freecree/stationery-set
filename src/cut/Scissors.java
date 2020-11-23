package cut;

import books.Leaf;

public class Scissors implements CuttingTool {
    public Leaf cut(Leaf leaf, double koef) {
        System.out.println("Knife cuts");
        return leaf;

    }
}
