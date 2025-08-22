package comparing;

public class Main {
    public static void main(String[] args) {
        students meet = new students(18,89.4f);
        students nanish = new students(20,99.5f);

        if(meet.compareTo(nanish) < 0){
            System.out.println("hello");
        }

    }
}
