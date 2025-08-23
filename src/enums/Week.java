package enums;

public class Week {
    enum days {
        Monday,Tuesday,Wednesday,Thrusday,Friday,Saturday,Sunday;
        // these are enum constant
        // public,static,final
        // since its final you can not create child enums
        // type is Week

        days(){
            System.out.println("constructor for " + this);
        }
    }


    public static void main(String[] args) {
        days week;

//        System.out.println( days.valueOf("Tuesday"));
         for(days day : days.values()){
             System.out.println(day);
         }
    }
}
