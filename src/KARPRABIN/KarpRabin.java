package KARPRABIN;
public class KarpRabin { // TC - BEST CASE - O(n + m);
    // TC - worst - O(n) where n is the text length which we have to search for pattern

   private final int PRIME = 101;
   private long calculateHash(String str){
       long hash = 0;
       for (int i = 0; i < str.length(); i++) {
           hash = (long)(hash + str.charAt(i) * Math.pow(PRIME,i));
       }
       return hash;
   }
   private long updateHash(long prevHash , char oldChar,char newChar,int patternLength){ // Rolling Hash
       long newHash = (prevHash-oldChar)/PRIME;
       newHash = (long) (newHash + newChar * Math.pow(PRIME,patternLength-1));
       return newHash;
   }
   public void searchFor(String text,String pattern){
       int patternLength = pattern.length();
       long patternHash = calculateHash(pattern);
       long textHash = calculateHash(text.substring(0,patternLength));

       for (int i = 0; i <= text.length()-patternLength; i++) {
           if(patternHash == textHash){
               if(text.substring(i,i+patternLength).equals(pattern)){
                   System.out.println("pattern found at index : " + i);
               }
           }
           if(i < text.length()-patternLength){
               textHash = updateHash(textHash,text.charAt(i),text.charAt(i + pattern.length()),patternLength);
           }
       }

   }

}
