package exceptions;

public class MeasureException extends Exception {
    private int sum;
    public int getSum() {
        return sum;
    }
    public MeasureException(String message, int n) {
        super(message);
        sum = n;
    }
}
