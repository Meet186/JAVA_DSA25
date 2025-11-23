package TRIE;

public class subString {
    // unique substring
//    static List<String> makeSufixArray(String word){
//        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < word.length(); i++) {
//            String sufix = word.substring(i);
//            ans.add(sufix);
//        }
//        return ans;
//    }

//    static List<String> makePrefixArray(String word){
//        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < word.length(); i++) {
//            String prefix = word.substring(0,i);
//            ans.add(prefix);
//        }
//        return ans;
//    }
//
//    static List<String> uniqueSubString(String str){
//        List<String> sufixArray = makeSufixArray(str);
//        Set<String> set = new HashSet<>();
//        for(String el : sufixArray){
//          List<String> current = makePrefixArray(el);
//            for (int i = 0; i < current.size(); i++) {
//                set.add(current.get(i));
//            }
//        }
//        List<String> ans = new ArrayList<>();
//        set.forEach(element -> ans.add(element));
//        return ans;
//    }
}
