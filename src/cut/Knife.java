package cut;

import books.Leaf;

public class Knife implements CuttingTool {
    public Leaf cut(Leaf leaf, double koef) {
        int border = (int)Math.round(leaf.getFirstPage().getPageCapacity()*(1-koef));
        System.out.println("border: "+border);
        Leaf newLeaf = leaf; //new Leaf(leaf.getFirstPage().getType(), leaf.getPageCapacity());
        leaf.delete(border, leaf.getFirstPage().getPageCapacity());
        System.out.println("Leaf: ");
        leaf.showRecords();
        newLeaf.delete(0,border);
        //newLeaf.setPageCapacity(newLeaf.getPageCapacity()-border);
        System.out.println("Knife cuts");
        return newLeaf;
    }

}
