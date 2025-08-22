package comparing;

public class students implements Comparable<students> {
    int rollno;
    float mark ;

    public students(int rollno, float mark) {
        this.rollno = rollno;
        this.mark = mark;
    }

    @Override
    public int compareTo(students o) {
        int diff = (int) (this.mark - o.mark);
        return diff;
    }
}
