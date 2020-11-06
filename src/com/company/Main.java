package com.company;


import exceptions.MeasureException;
import figures.Figures;
import mark.Pen;
import mark.Pencil;
import measure.Protractor;
import measure.Ruler;

enum InstrMaterials {
    WOOD,
    IRON,
    PLASTIC;
}
enum PencilColors {
    SIMPLE,
    RED,
    GREEN,
    YELLOW,
    BLUE,
    BROWN,
    BLACK,
    PURPLE
}
enum PenColors {
    BLUE,
    RED,
    PURPLE
}
public class Main {

    public static void main(String[] args) {
        Pen pen = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, 0.7, 15.4);

        Pencil pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, "soft");
        
        pen.mark();
        pen.show();
        pencil.show();

        Ruler ruler = new Ruler(300, InstrMaterials.WOOD.toString());
        Ruler ruler2 = new Ruler(300, InstrMaterials.WOOD.toString());

        Protractor protractor = new Protractor(300,InstrMaterials.IRON.toString());
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

        ruler.show();
        protractor.show();
        System.out.println("Finish");

    }

}
