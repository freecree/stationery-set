package com.company;

import books.Leaf;
import books.PageType;
import mark.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.company.Main.*;
import static org.junit.Assert.*;

public class MainTest extends OutputTest  {
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

    @Test
    public void GetGeneralDistByMaterial_NullCollection_Zero() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expectedGeneralDist = GetGeneralDistByMaterial(null, "lol");
        assertEquals(expectedGeneralDist, 0, 0.01);
    }

    //the biggest

    @Test
    public void GetTheBiggestDistPen_FullCollection_CorrectDistance() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        Optional expected = GetTheBiggestDistPen(pens);
        assertEquals(expected, Optional.of(PEN4));
    }

    @Test (expected = NoPensException.class)
    public void GetTheBiggestDistPen_NullCollection_ThrowNoPensException() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        Optional<Pen> expected = GetTheBiggestDistPen(null);
    }


    // avarage
    @Test
    public void GetAverageDist_FullCollection_CorrectDistance() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expected = GetAverageDist(pens);
        double actual = (15.4 + 16.4 + 35.4 + 60.7)/4;
        //THEN
        assertEquals(expected, actual, 0.1);
    }

    // avarage
    @Test
    public void GetAverageDist_NullCollection_CorrectDistance() {
        //GIVEN
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        //WHEN
        double expected = GetAverageDist(null);
        //THEN
        assertEquals(expected, 0, 0.1);
    }

    @Test
    public void toMap() {
        List pens = List.of(PEN1,PEN2,PEN3,PEN4 );
        Map<Boolean, List<Pen>> actualMap = Map.of(false, List.of(PEN1, PEN2, PEN3), true, List.of(PEN4));
        ToMap(pens, "PLASTIC", "RED");
        Assert.assertEquals(output.toString(), actualMap.toString());
    }

    @Test
    public void Concat() {
        //GIVEN
        Leaf leaf = new Leaf(PageType.CELL, 12);
        Pencil pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, true, "soft");
        pencil.write(leaf.getFirstPage(), "Record1 in first page");
        pencil.write(leaf.getSecondPage(), "Record1 in second page");
        pencil.write(leaf.getFirstPage(), "the most frequent record");
        pencil.write(leaf.getSecondPage(), "the most frequent record");
        //WHEN
        String expected = concat(leaf);
        //THEN
        assertEquals(expected, "the most frequent record");
    }
}