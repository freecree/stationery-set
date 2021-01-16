package figures;

import org.junit.Test;

import static org.junit.Assert.*;

public class FiguresTest {

    @Test
    public void FiguresToString_PentagonToString_CorrespondString() {
        String expected = Figures.PENTAGON.toString();
        String actual = "PENTAGON\n5\n90;110;80;100;160";
        assertEquals(expected, actual);
    }

    @Test
    public void GetRightAnglesSum_PentagonAnglesSum_Equally540() {
        assertEquals(Figures.PENTAGON.getRightAnglesSum(), 540);
    }
}