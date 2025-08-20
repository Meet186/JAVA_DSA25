package OOPS.inheritance;

public class box {
    double l;
    double w;
    double h;
    double weight;

    public box(double l, double w, double h, double weight) {
        this.l = l;
        this.w = w;
        this.h = h;
        this.weight = weight;
    }

    public box() {
        this.l = -1;
        this.w = -1;
        this.h = -1;
        this.weight = -1;
    }

    public box(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    public box(double l) {
        this.l = l;
    }

    public box(double l, double w) {
        this.l = l;
        this.w = w;

    }

    public void display() {
        System.out.println(l + " " + w + " " + h + "" + weight);
    }
}
