package com.company;

import mark.InstrMaterials;
import mark.Pen;
import mark.PenColors;
import org.junit.Test;

import java.util.List;

import static com.company.Main.GetGeneralDistByMaterial;
import static com.company.Main.GetTheBiggestDistByMaterial;
import static org.junit.Assert.*;

public class MainTest {
    final Pen PEN1 = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 15.4);
    final Pen PEN2 = new Pen(PenColors.BLUE.toString(), InstrMaterials.IRON.toString(), 150, false, 0.7, 16.4);
    final Pen PEN3 = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 35.4);
    final Pen PEN4 = new Pen(PenColors.RED.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 60.7);

    @Test
    public void GetGeneralDistByMaterial_ExistingMaterial_CorrectDistance() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expectedGeneralDist = GetGeneralDistByMaterial(pens, "PLASTIC");
        double actualGeneralDist = 15.4 + 35.4 + 60.7;
        assertEquals(expectedGeneralDist, actualGeneralDist, 0.01);
    }

    @Test
    public void GetGeneralDistByMaterial_NotExistingMaterial_Zero() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expectedGeneralDist = GetGeneralDistByMaterial(pens, "oh no");
        assertEquals(expectedGeneralDist, 0, 0.01);
    }

    @Test
    public void GetGeneralDistByMaterial_NullMaterial_Zero() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expectedGeneralDist = GetGeneralDistByMaterial(pens, null);
        assertEquals(expectedGeneralDist, 0, 0.01);
    }

    //the biggest

    @Test
    public void GetTheBiggestDistByMaterial_ExistingMaterial_CorrectDistance() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expectedGeneralDist = GetTheBiggestDistByMaterial(pens, "PLASTIC");
        double actualGeneralDist = 60.7;
        assertEquals(expectedGeneralDist, actualGeneralDist, 0.01);
    }

    @Test
    public void GetTheBiggestDistByMaterial_NotExistingMaterial_Zero() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expectedGeneralDist = GetTheBiggestDistByMaterial(pens, "oh no");
        assertEquals(expectedGeneralDist, 0, 0.01);
    }

    @Test
    public void GetTheBiggestDistByMaterial_NullMaterial_Zero() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expectedGeneralDist = GetTheBiggestDistByMaterial(pens, null);
        assertEquals(expectedGeneralDist, 0, 0.01);
    }


    @Test
    public void getAverageDistByMaterial() {
    }
}