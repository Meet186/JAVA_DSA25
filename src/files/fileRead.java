package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileRead {
    public static void main(String[] args) {


//        try (FileReader fs = new FileReader("C:\\Users\\win\\OneDrive\\Desktop\\JAVA_DSA_25\\src\\files\\notes.txt")){
//            int letters = fs.read();
//            while (fs.ready()){
//                System.out.print((char) letters);
//               letters =  fs.read();
//            }
//            System.out.println((char) letters);
//            fs.close();
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

//       try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\win\\OneDrive\\Desktop\\JAVA_DSA_25\\src\\files\\notes.txt"))){
//           System.out.println("you type :" + br.readLine());
//           while (br.ready()){
//               br.readLine();
//           }
//           br.close();
//       } catch (IOException e){
//            System.out.println(e.getMessage());
//        }



        String filePath = "C:\\Users\\win\\OneDrive\\Desktop\\JAVA_DSA_25\\src\\files\\notes.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            String lines = br.readLine();
            while (lines != null){
                System.out.println(lines);
                lines = br.readLine();
            }

        } catch (IOException e ){
            System.out.println(e.getMessage());
        }


    }
}
