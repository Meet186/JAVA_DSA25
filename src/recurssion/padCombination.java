package recurssion;

import java.util.ArrayList;
import java.util.List;

public class padCombination {
    static void numberCombination(String p,String up){
        if(up.isEmpty()){
            System.out.print(p + " ");
            return;
        }
        int digit = up.charAt(0)-'0'; // convert '2' -> 2
        for (int i = (digit - 1) * 3 ; i < digit * 3 ; i++) {
            char ch = (char) ('a' + i);
            numberCombination(p+ch,up.substring(1));
        }
    }

    static List<String> numberCombination2(String p, String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0)-'0'; // convert '2' -> 2
        List<String> temp = new ArrayList<>();
        for (int i = (digit - 1) * 3 ; i < digit * 3 ; i++) {
            char ch = (char) ('a' + i);
            temp.addAll(numberCombination2(p + ch,up.substring(1)));
        }
        return temp;
    }

    static List<String> letterCombinations(String digits) {
         if(digits.length() == 0){
             return new ArrayList<>();
         }
        ArrayList<String> result = new ArrayList<>();
        String kp [] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,kp,"",result);
        return result;
    }

    static void helper(String digit, String[] kp, String currans ,ArrayList<String> result){
        if(digit.length() == 0){
            result.add(currans);
            return;
        }
        int currDigit = digit.charAt(0) - '0';
        String currchoices = kp[currDigit];

        for (int i = 0; i < currchoices.length(); i++) {
            helper(digit.substring(1),kp,currans+currchoices.charAt(i),result);
        }

    }

    public static void main(String[] args) {
      List<String> ans =  numberCombination2("","12");
        System.out.println(ans);
    }
}
