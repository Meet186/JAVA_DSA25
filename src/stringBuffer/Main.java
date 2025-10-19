package stringBuffer;

import java.text.DecimalFormat;
import java.util.Random;

public class Main {
    static String generateString(int size) {
        StringBuffer sb = new StringBuffer(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomChar = 97 + (int) (random.nextFloat() * 26);
            sb.append((char) randomChar);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // DIFFERENCE B/W STRINGBUFFER  & STRINGBUILDER
        /*
        {
         STRINGBUFFER is thread safe a single thread is work {SLOW}
         STRINGBUILDER is not thread safe multiple thread will work on single data {FAST}
        }
         */
        // constructor 1
        StringBuffer sb = new StringBuffer(); // Mutable sequence of character
//        System.out.println(sb.capacity()); // 16
        // constructor 2
        StringBuffer sb2 = new StringBuffer("harsh");
        // constructor 3
        StringBuffer sb3 = new StringBuffer(30);


        sb.append("meet");
        String str = sb.toString();
//        System.out.println(str);
//        System.out.println(sb);

        sb.insert(2, "MAYAN");
//        sb.delete(2,3);
        sb.replace(1, 2, "nanaish");
        sb.reverse();
//        System.out.println(sb);
        String name = generateString(20);
//        System.out.println(name);

        // REMOVE SPACE
        String str1 = "   kdbjdg knkjh k lk lk  kj lkj lk";
        String str1Update = (str1.replaceAll("\\s", ""));

        // SPLIT
        String names = "meet nanish harsh vedick abhay kushgra mayank digvijay ";
        String[] arr = names.split(" ");
//        System.out.println(Arrays.toString(arr));

        // ROUNDING OFF
        DecimalFormat dc = new DecimalFormat("0.0000");
        System.out.println(dc.format(7.2));
    }
}
