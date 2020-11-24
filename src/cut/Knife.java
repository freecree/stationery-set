package cut;

import books.Leaf;
import exceptions.SameObjectsException;

public class Knife implements CuttingTool {

    public Leaf cut(Leaf leaf, double koef) {
        System.out.println("Cut by knife:");
        int border = (int) Math.round(leaf.getFirstPage().getPageCapacity() * (1 - koef));
        try {
            Leaf newLeaf = leaf.clone();
            if (newLeaf.equals(leaf)) {
                throw new SameObjectsException("Clonning has done incorrectly. Two leaves are equals!");
            }
            leaf.delete(border, leaf.getFirstPage().getPageCapacity());
            leaf.setPageCapacity(border);
            newLeaf.delete(0, border);
            newLeaf.setPageCapacity(newLeaf.getPageCapacity() - border);
            return newLeaf;
        } catch (CloneNotSupportedException | SameObjectsException ex) {
            System.err.println("Couldn't clone object");
            System.err.println("Leaf hadn't cut");
            ex.getMessage();
        }
        return leaf;
    }
}
