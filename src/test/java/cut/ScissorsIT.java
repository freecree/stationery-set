package cut;

import books.Leaf;
import books.PageType;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ScissorsIT {

    private Leaf.Page page1 = mock(Leaf.Page.class);
    private Knife knife = new Knife();
    private Leaf leaf1 = mock(Leaf.class);
    private Leaf leafClone = mock(Leaf.class);
    @Test
    public void cut_CuttingLeafWithCorrectData_VerifyDeletingPartOfLeaves() throws CloneNotSupportedException {
        //WHEN
        when(leaf1.getFirstPage()).thenReturn(page1);
        when(page1.getPageCapacity()).thenReturn(12);
        when(leaf1.clone()).thenReturn(leafClone);
        knife.cut(leaf1, 0.8);
        //THEN
        verify(leaf1).delete(2, 12);
        verify(leafClone).delete(0, 2);
    }

    @Test
    public void cut_CuttingLeafWithIncorrectData_NotVerifyDeletingPartOfLeaves() throws CloneNotSupportedException {
        //WHEN
        when(leaf1.getFirstPage()).thenReturn(page1);
        when(page1.getPageCapacity()).thenReturn(12);
        when(leaf1.clone()).thenReturn(leafClone);
        knife.cut(leaf1, 0.4);
        //THEN
        verify(leaf1, never()).delete(2, 12);
        verify(leafClone, never()).delete(0, 2);
    }
}
