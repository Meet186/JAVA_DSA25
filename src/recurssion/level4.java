package recurssion;
import javax.swing.text.Style;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class level4 {
    static String removeA(String str,String ans){
        if(str.length() == 0) return ans;
        char ch = str.charAt(0);
        if(ch == 'A'){
           return removeA(str.substring(1),ans);
        }
        return removeA(str.substring(1),ch+ans);
    }
    static String removeWord(String str,String word){
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith(word)){
            return removeWord(str.substring(word.length()),word);
        } else {
            return str.charAt(0) + removeWord(str.substring(1),word);
        }
    }
    static void printSubset(String str,String ans){
        if(str.isEmpty()){
            System.out.print(ans + " ");
            return;
        }
        printSubset(str.substring(1),str.charAt(0)+ans);
        printSubset(str.substring(1),ans);
    }
    static ArrayList<String> Subset(String str, String ans,ArrayList<String> list){
        if(str.isEmpty()){
            list.add(ans);
            return list;
        }
        Subset(str.substring(1),str.charAt(0)+ans,list);
        Subset(str.substring(1),ans,list);
        return list;
    }
    static ArrayList<String> subset2(String str,String ans){
        if(str.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        ArrayList<String> left = subset2(str.substring(1),ans);
        ArrayList<String> right = subset2(str.substring(1),str.charAt(0) + ans);
        left.addAll(right);
        return left;
    }
    static List<List<Integer>> subset3(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num : arr){
            int n = ans.size();
            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>(ans.get(i));
                temp.add(num);
                ans.add(temp);

            }
        }
        return ans;
    }
    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0 ; i< arr.length; i++){
            start = 0;
            int n = ans.size();
            if(i > 0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = ans.size()-1;
            for (int j = start; j < n; j++) {
                List<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = subsetDuplicate(new int[] {1,2,2});
        System.out.println(ans);
    }
}
