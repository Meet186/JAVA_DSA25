package OOPS.inheritance;

public class weight extends box {
    double weight;
    String name = "meet";

    public weight() {
        this.weight = -1;
    }

    public weight(double l, double w, double h, double weight) {
        super(l, w, h);
        super.l = l;
        super.w = w;
        super.h = h;
        //super.weight = weight; //call parent class value
        this.weight = weight;
    }

    public weight(double weight) {
        this.weight = weight;
    }
}
