package files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
public class createFile {
    public static void main(String[] args) {
        File fo = new File("data.txt");
        // create
        try{
            fo.createNewFile();
        } catch (IOException e ){
            e.printStackTrace();
        }
        // write
        String filePath = "C:\\Users\\win\\OneDrive\\Desktop\\JAVA_DSA_25\\src\\files\\data.txt";
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(filePath,true))) {
            fw.write("hare krishna ");
            fw.newLine();
            fw.write("कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।");
            fw.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // read

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            String lines = br.readLine();
            while (lines != null){
                System.out.println(lines);
                lines = br.readLine();
            }

        } catch (IOException e ){
            System.out.println(e.getMessage());
        }

        // JAVA 7+
        Path path = Paths.get("C:\\Users\\win\\OneDrive\\Desktop\\JAVA_DSA_25\\src\\files\\niofile.txt");

        try {
            Files.write(path, Arrays.asList("Line 1", "Line 2", "Line 3"));
            System.out.println("File created and lines written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
