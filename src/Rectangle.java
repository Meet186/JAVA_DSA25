public class Rectangle {
    private int length;
    private int width;

    Rectangle(){

    }
    Rectangle(int length,int width){
        this.length = length;
        this.width = width;
    }

    public int calculateArea(){
        return length * width;
    }

    public int calculatePerimetre(){
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(12,12);
        int area = r1.calculateArea();
        System.out.println(area);
    }
}
