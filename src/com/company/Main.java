package com.company;
import books.*;
import cut.Knife;
import eraser.Eraser;
import figures.Figures;
import mark.*;
import measure.Protractor;
import measure.Ruler;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Pen pen = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 15.4);
        Pencil pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, true, "soft");
        Ruler ruler = new Ruler(300, InstrMaterials.WOOD.toString());
        Protractor protractor = new Protractor(300,InstrMaterials.IRON.toString());
        Knife knife = new Knife();
        Eraser eraser = new Eraser(7);

        pen.show();
        pencil.show();
        ruler.show();
        protractor.show();

        int [] figureAngles;
        protractor.measure(Figures.TRIANGLE);
        figureAngles = protractor.getTempFigureAngles();
        System.out.println("angles of "+Figures.TRIANGLE.name());
        for( int angle : figureAngles) {
            System.out.println(angle);
        }
        protractor.measure(30);
        int someAngle = protractor.getTempAngle();
        System.out.println("size of angle: "+someAngle);
        System.out.println("Finish");

        Book notepad = new Book(4, BookType.NOTEPAD, PageType.CELL, 12);

        for (int i = 1; i < 7; i++) {
            String s = "Some record "+i;
            pen.write(notepad.getPage(1),s);
            pencil.paint(notepad.getPage(2),s);
        }
        pen.write(notepad.getPage(1),"Some record 1" ); //not added
        notepad.showRecords();
        Leaf newLeaf = knife.cut(notepad.getLeaf(1),0.8);
        System.out.println("\nOne part of cut leaf:\n");
        notepad.getLeaf(1).showRecords();
        System.out.println("\nSecond part of cut leaf:\n");
        newLeaf.showRecords();
        eraser.wipe(newLeaf.getSecondPage(),2);
        System.out.println("New leaf after wiping:");
        newLeaf.showRecords();

        Pen pen1 = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 15.4);
        Pen pen2 = new Pen(PenColors.BLUE.toString(), InstrMaterials.IRON.toString(), 150, false, 0.7, 16.4);
        Pen pen3 = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 35.4);
        Pen pen4 = new Pen(PenColors.RED.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 60.7);
        List pens = List.of(pen1, pen2, pen3, pen4);

        double generalDist = GetGeneralDistByMaterial(pens, "lol"); //"PLASTIC"
        System.out.println(generalDist);
        double maxDist = GetTheBiggestDistByMaterial(pens, "PLASTIC"); //"PLASTIC"
        System.out.println(maxDist);
        double averageDist = GetAverageDistByMaterial(pens, "PLASTIC"); //"PLASTIC"
        System.out.println(averageDist);
        ToMap(pens, "PLASTIC", "RED");


    }
    public static double GetGeneralDistByMaterial(Collection<Pen> pens, String material) {
        if( material == null)  {
            return 0.0;
        }
        return pens.stream().
                filter(s-> s.getMaterial() != null).
                filter(s -> material.equals(s.getMaterial()))
                .mapToDouble(Pen::getDistance).
                        sum();
//        return material. (pens.stream().
//                filter(s-> s.getMaterial() != null).
//                map(s->material.isEmpty()
//
//                ).
//                filter(s -> material.equals(s.getMaterial()))
//                .mapToDouble(Pen::getDistance).
//                        sum();
    }
    public static double GetTheBiggestDistByMaterial(Collection<Pen> pens, String material) {
        if( material == null)  {
            return 0.0;
        }
        return pens.stream().
                mapToDouble(Pen::getDistance).max().orElse(0.0);
    }
    public static double GetAverageDistByMaterial(Collection<Pen> pens, String material) {
        if( material == null)  {
            return 0.0;
        }
        return pens.stream().
                mapToDouble(Pen::getDistance).average().orElse(0.0);
    }
    public static void ToMap(Collection<Pen> pens, String material, String color) {
        //Map<Boolean, List<Pen>> partitioned =

//        List<Pen> truePens = pens.stream().
//                filter(s -> material.equals(s.getMaterial())&& color.equals(s.getColor())).
//                collect(Collectors.toList());
//        List<Pen> falsePens = pens.stream().
//                filter(s -> !material.equals(s.getMaterial()) || !color.equals(s.getColor())).
//                collect(Collectors.toList());
//        Map<Pen, Pen> allPens = truePens.s
//        for(Pen collect : truePens ) {
//            collect.show();
//        }
//        System.out.println("False pens: ");
//        for(Pen collect : falsePens ) {
//            collect.show();
//        }


    }

}
