package Expection;

public class Main {
    public static void main (String[] args) throws Exception{
       try{
           int a = 10;
           int b = 0;
           System.out.println(a/b);
       } catch (ArithmeticException e){
           System.out.println(e.getMessage());
       }
    }

//   static int divide (int a , int b) throws Exception{
//      if(b == 0){
//          throw new ArithmeticException("please do not divide by 0");
//      }
//      return a/b;
//    }
}
