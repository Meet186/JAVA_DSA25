package recurssion;
import java.util.ArrayList;
import java.util.List;
public class dicethrow {
    static void dice(String p, int target){ // TC _ O(6^N)
        if(target == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target ; i++) {
            dice(p+i,target-i);
        }
    }
    static List<String> dice2(String p, int target){
        if(target == 0){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> temp = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target ; i++) {
            temp.addAll(dice2(p+i,target-i));
        }
        return temp;
    }
    static int dicecount(String p, int target){
        if(target == 0){
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= 6 && i <= target ; i++) {

            count = count + dicecount(p+i,target-i);
        }
        return count;
    }
    public static void main(String[] args) {
      int ans =  dicecount("",4);
        System.out.println(ans);
    }
}
