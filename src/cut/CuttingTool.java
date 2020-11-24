package cut;

import books.Leaf;

public interface CuttingTool {
    public Leaf cut(Leaf leaf, double koef) throws IllegalAccessException;
}
