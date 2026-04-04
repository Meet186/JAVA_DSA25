package huffmanCoding;

public class Main {
    public static void main(String[] args) throws Exception {
        String str = "aabbccdea";
        self hf = new self(str);
        String codedString = hf.Encoder(str);
        String decodecString = hf.Decoder(codedString);
        System.out.println(codedString);
        System.out.println(decodecString);

    }


}
