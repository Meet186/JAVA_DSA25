package ATOZsheet.Strings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class leetcode451 {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // max heap based on frequency
        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {

            char ch = pq.poll();
            int freq = map.get(ch);

            for (int i = 0; i < freq; i++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
