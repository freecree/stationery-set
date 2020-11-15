package measure;

import mark.InstrMaterials;
import figures.Figures;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProtractorTest {
    private Protractor protractor;

    @Before
    public void setUp() {
        protractor = new Protractor(300, InstrMaterials.IRON.toString());
    }

    @Test
    public void measure_figure() {
        protractor.measure(Figures.TETRAGON);
        int[] expected1 = protractor.getTempFigureAngles();
        int[] actual1 = {30, 60, 150, 120};

        protractor.measure(Figures.PENTAGON);
        int[] expected2 = protractor.getTempFigureAngles();
        int[] actual2 = {90, 110, 80, 100, 160};


        assertArrayEquals(expected1, actual1);
        assertArrayEquals(expected2, actual2);


    }
    @Test
    public void getTempFigureAngles_NO_NULL() {
        int[] expected = protractor.getTempFigureAngles();
        assertNotNull(expected);

    }


        @Test
    public void testMeasure() {
    }

    @Test
    public void checkFigureMeasure() {
    }
}