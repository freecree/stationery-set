package com.company;
import books.Book;
import books.BookType;
import books.PageType;
import figures.Figures;
import mark.*;
import measure.Protractor;
import measure.Ruler;

public class Main {

    public static void main(String[] args) {
        Pen pen = new Pen(PenColors.BLUE.toString(), InstrMaterials.PLASTIC.toString(), 150, 0.7, 15.4);

        Pencil pencil = new Pencil(PencilColors.SIMPLE.toString(), InstrMaterials.WOOD.toString(), 150, "soft");
        
        pen.mark();
        pen.show();
        pencil.show();

        Ruler ruler = new Ruler(300, InstrMaterials.WOOD.toString());


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
        Book notepad = new Book(30, BookType.NOTEPAD, PageType.CELL);

        //Book.Door door = new Book().new Door();
    }

}
