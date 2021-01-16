package figures;

public enum Figures {
    TRIANGLE(3,"31;60;90"),
    TETRAGON(4,"30;60;150;120"),
    PENTAGON(5,"90;110;80;100;160");
    int anglesNum;
    String anglesValues;
    Figures(int anglesNum, String anglesValues) {
        this.anglesNum = anglesNum;
        this.anglesValues = anglesValues;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.name());
        sb.append("\n");
        sb.append(anglesNum);
        sb.append("\n");
        sb.append(anglesValues);
        return sb.substring(0);
        //return this.name()+"\n"+anglesNum+"\n"+anglesValues;
    }
    public int getRightAnglesSum() {
        return  (anglesNum-2)*180;
    }


}
