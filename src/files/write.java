package files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class write {
    public static void main(String[] args) {

//        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)){
//
//            osw.write("hello world");
//            osw.write(97);
//            osw.write('\n');
//            osw.write("meet");
//            char[] arr = "my name".toCharArray();
//            osw.write(arr);
//
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }


        String filePath = "C:\\Users\\win\\OneDrive\\Desktop\\JAVA_DSA_25\\src\\files\\notes.txt";
//        try (FileWriter fw = new FileWriter(filePath,true)) {
//
//            fw.write("hello world");
//            fw.write("meet ");
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


        try (BufferedWriter fw = new BufferedWriter(new FileWriter(filePath,true))) {
            fw.write("hare krishna ");
            fw.newLine();
            fw.write("happy");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
