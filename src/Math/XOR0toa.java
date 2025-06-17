package Math;

public class XOR0toa {
    static int xor(int a ){
        if(a % 4 == 0) return a;
        else if (a % 4 == 1) return 1;
        else if (a % 4 == 2) return a + 1;
        else return 0;
    }

    public int[][] flipAndInvertImage(int[][] image) {
            for(int[] row : image){
                for (int i = 0; i < ( image[0].length + 1 ) / 2; i++) {
                    int temp = row[i] ^ 1;
                    row[i] = row[image[0].length-i-1] ^ 1;
                    row[image[0].length-i-1] = temp;
                }
            }
            return image;
    }

    static int XOR_Range(int l , int r){
        return xor(r) ^ xor(l-1);

    }
    public static void main(String[] args) {
        System.out.println(XOR_Range(5,9));
    }
}
