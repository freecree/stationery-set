package com.company;
import books.*;
import cut.Knife;
import figures.Figures;
import mark.*;
import measure.Protractor;
import measure.Ruler;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Pen pen = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, false, 0.7, 15.4);
        Pencil pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, true, "soft");
        Ruler ruler = new Ruler(300, InstrMaterials.WOOD.toString());
        Protractor protractor = new Protractor(300,InstrMaterials.IRON.toString());
        Knife knife = new Knife();

//        pen.show();
//        pencil.show();
//        ruler.show();
//        protractor.show();

        int [] figureAngles;
        protractor.measure(Figures.TRIANGLE);
        figureAngles = protractor.getTempFigureAngles();
//        System.out.println("angles of "+Figures.TRIANGLE.name());
//        for( int angle : figureAngles) {
//            System.out.println(angle);
//        }
        protractor.measure(30);
        int someAngle = protractor.getTempAngle();
        //System.out.println("size of angle: "+someAngle);
        //System.out.println("Finish");

        Book notepad = new Book(3, BookType.NOTEPAD, PageType.CELL, 12);
        //System.out.println("Show: ");
        //notepad.showRecords();

        Leaf leaf = new Leaf(PageType.CELL, 10);
        pen.write(leaf.getFirstPage(),"Some record1");
        pen.write(leaf.getFirstPage(),"Some record2");
        pen.write(leaf.getFirstPage(),"Some record3");
        pen.write(leaf.getFirstPage(),"Some record4");
        pen.write(leaf.getFirstPage(),"Some record5");
        pen.write(leaf.getFirstPage(),"Some record5");
        leaf.showRecords();
        //leaf.delete(0,2);

//        Leaf newLeaf = knife.cut(leaf,0.8);
//        System.out.println("\nMain: \n");
//
//        System.out.println("\n Leaf: \n");
//        leaf.showRecords();
//        System.out.println("\n NewLeaf: \n");
//        newLeaf.showRecords();

        //int a = del(5, 1);
        //System.out.println("a: "+ a);

    }

}
