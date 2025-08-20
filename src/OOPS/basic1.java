package OOPS;
public class basic1 {
   static class students {
         int roll_Num;
         String ID;
         String name;
        students(){
            // Deafult Constructor { NO NEED TO CREATE }
        }
       students(int roollno,String id , String name){
           this.roll_Num = roollno;
           this.ID = id;
           this.name = name;

       }
         void greet(){
            System.out.println("Hello ! " + this.name);
        }
    }
    public static void main(String[] args) {
     students s1 = new students(18,"0818CS241191","meet");
     students s2 = new students(11,"0818CS241167","krish");
     s1.greet();
     s2.greet();
    final A obj = new A("meet");
    obj.name = "harsh"; // change the value is possible;
//    obj = new A("new object created"); // not poosible to change
    }
    static class A {
        final int num = 0;
        String name;

        A(String name){
            this.name = name;
        }

    }

}
