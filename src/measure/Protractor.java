package measure;

import exceptions.MeasureException;
import figures.Figures;

public class Protractor extends Ruler {
    private int tempFigureAngles[];
    private int tempAngle;

    public Protractor(int length, String material) {
        super(length, material);
    }

    public int getTempAngle() {
        return tempAngle;
    }
    public int [] getTempFigureAngles() {
        return tempFigureAngles;
    }
        public void measure(Figures figure) {
        String[] arr = figure.toString().split("\n");
        int n = Integer.parseInt(arr[1]);
        String[] angles = arr[2].split(";");
        tempFigureAngles = new int[n];

        for (int i = 0; i < n; i++) {
            tempFigureAngles[i] = Integer.parseInt(angles[i]);
        }

        try{
            checkFigureMeasure(figure);
        }
        catch(MeasureException ex){
            System.out.println(ex.getMessage());
            System.out.println("The sum of angles must be: " + ex.getSum());
        }
    }
    @Override
    public void measure(int angle) {
        tempAngle = angle;
    }

    public void checkFigureMeasure(Figures figure) throws MeasureException {
        int sum = 0;
        for( int num : tempFigureAngles) {
            sum = sum + num;
        }
        if (sum != figure.getRightAnglesSum()) {
            throw new MeasureException("angles measured incorrectly", figure.getRightAnglesSum());
        }
     }
    public void show() {
        System.out.println("Protractor");
        System.out.println("Length: " + getLength() + "mm");
        System.out.println("material: " + getMaterial());
        System.out.println("Last angle was measured: " + tempAngle + " C");
        System.out.println("Last figure was measured: " );
        for( int angle : tempFigureAngles) {
            System.out.println(angle);
        }
    }

}
