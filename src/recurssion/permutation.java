package recurssion;

import java.util.ArrayList;
import java.util.List;

public class permutation {
    static void permutation(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            permutation(first + ch + second,up.substring(1));

        }
    }
    static List<String> permutation2(String p,String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        List<String> temp = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            temp.addAll( permutation2(first + ch + second,up.substring(1)));

        }
        return temp;
    }
    static List<String> permutation3(String p,String up,List<String> list){
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        List<String> temp = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            temp = ( permutation3(first + ch + second,up.substring(1),list));
        }
       return temp;
    }
    public static void main(String[] args) {
        String str = "abc";
        List<String> temp = new ArrayList<>();
        temp =   permutation3("",str,temp);
        System.out.println(temp);
    }
}
