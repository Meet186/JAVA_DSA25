package DP.DPonStrings;

import java.util.ArrayList;
import java.util.List;

public class generateAllSubstring {
    public static List<String> generateSubstrings(String str) {
        List<String> result = new ArrayList<>();
        int n = str.length();

        for (int i = 0; i < n; i++) {          // starting index
            for (int j = i; j < n; j++) {      // ending index
                result.add(str.substring(i, j + 1));
            }
        }

        return result;
    }




    public static void main(String[] args) {
        String str = "abc";
        System.out.println(generateSubstrings(str));
    }
}
