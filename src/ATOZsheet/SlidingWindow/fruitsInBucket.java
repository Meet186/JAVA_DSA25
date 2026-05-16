package ATOZsheet.SlidingWindow;

public class fruitsInBucket {

    public static int totalFruits(int[] fruits) {
      int max = -1;
      for(int num : fruits){
          if(num > max){
              max = num;
          }
      }
      int[] freq = new int[max];
      for(int i=0; i<fruits.length; i++){
          freq[fruits[i]]++;
      }
      int total = 0;
        total += freq[fruits[0]]; // fruits in firstBucket
        max = -1;
        for(int i=0; i<freq.length; i++){
            if(i == fruits[0]) continue;
            if(freq[i] > max){
                max = freq[i];
            }
        }

      return total + max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};
        System.out.println(totalFruits(arr)); // 4

    }
}
