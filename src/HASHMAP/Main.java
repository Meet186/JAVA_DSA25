package HASHMAP;

public class Main {
    public static void main(String[] args) {
        OWNMAP<String,Integer> map = new OWNMAP<>();
        map.put("meet",12);
        map.put("nanish",13);
        map.put("vedick",122);
        map.put("harsh",122);
        map.put("kushagra",122);
        map.put("hariom",122);
        map.remove("harsh");

        map.display();
        map.displayKey_Value();

//        System.out.println(map.get("meet"));
//        System.out.println(map.getDeafultCapacity());
//        System.out.println(map.getLoadFactor());
//        System.out.println(map.size());
    }
}
