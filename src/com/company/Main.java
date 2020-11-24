package com.company;
import books.*;
import cut.Knife;
import eraser.Eraser;
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




    }

}
