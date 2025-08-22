package Expection;

public class Main {
    public static void main (String[] args) throws Exception{
//        try{
//            divide(4,0);
//        } catch (ArithmeticException e ){
//            System.out.println(e.getMessage());
//        }

        divide(1,0);
    }

   static int divide (int a , int b) throws Exception{
      if(b == 0){
          throw new ArithmeticException("please do not divide by 0");
      }
      return a/b;
    }
}
