package files;

import java.io.FileReader;
import java.io.IOException;

public class zoom {
    static void readfile() throws IOException {
        FileReader fs = new FileReader("C:\\Users\\win\\OneDrive\\Desktop\\JAVA_DSA_25\\src\\files\\notes.txt");
        int letters = fs.read();
            while (fs.ready()){
                System.out.print((char) letters);
               letters =  fs.read();
            }
    }

    public static void main(String[] args) {
        try{
            readfile();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
